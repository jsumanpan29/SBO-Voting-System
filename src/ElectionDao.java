
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public interface ElectionDao {
    Election findByID(int id) throws SQLException;
    Set<Election> all() throws SQLException;
    boolean insert(Election election) throws SQLException;
    boolean update(Election election) throws SQLException;
    boolean delete(int id) throws SQLException;
    boolean electionPause(int id) throws SQLException;
    boolean electionRun(int id) throws SQLException;
    boolean isElectionRunning(int id) throws SQLException;
    boolean electionPending(int id) throws SQLException;
    boolean electionEnd(int id) throws SQLException;
    boolean isElectionNameUsed(String election_name) throws SQLException;
    boolean updateStartDate(int id)throws SQLException;
    boolean updateEndDate(int id)throws SQLException;
//    Party findPartyBy(int studentno) throws SQLException;
    Election returnElectionRunningID() throws SQLException;
}

class ElectionDaoImpl implements ElectionDao{

    private static final int MYSQL_AS_DB = 1; 
    private static final String INSERT = "INSERT INTO election VALUES (NULL, ?, NULL, NULL, ?, ?)";
    private static final String ALL = "SELECT * from election WHERE record_status = 1";
    private static final String FIND_BY_ID = "SELECT * FROM election WHERE election_id =";
    private static final String DELETE = "UPDATE election SET record_status = 0, election_status_id = 4 WHERE election_id = ?";
    private static final String ELECTION_RUN = "UPDATE election SET election_status_id = 2 WHERE election_id = ?";
//    private static final String ELECTION_END = "UPDATE election SET record_status = 0, election_status_id = 4 WHERE election_id = ?";
    private static final String UPDATE = "UPDATE election SET election_name = ? WHERE election_id = ?";
    private static final String UPDATE_STARTDATE = "UPDATE election SET election_record_startdate = ? WHERE election_id = ?";
    private static final String UPDATE_ENDDATE = "UPDATE election SET election_record_enddate = ? WHERE election_id = ?";
    private static final String FIND_BY_ELECTIONNAME = "SELECT * FROM election WHERE record_status = 1 and election_name =";
    private static final String IS_ELECTION_RUNNING = "SELECT * FROM election WHERE election_status_id = 2 and election_id =";
    private static final String RETURN_RUNNING_ELECTION_ID = "SELECT * FROM election WHERE election_status_id = 2";
    @Override
    public Election findByID(int id) throws SQLException {
        Connection conn = DaoFactory.getDB(MYSQL_AS_DB).openConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(FIND_BY_ID + id);
        if (rs.next()) {
            return extractUserFromResultSet(rs);
        }
        st.close();
        conn.close();
        return null;
    }
    
    private Election extractUserFromResultSet(ResultSet rs) throws SQLException {

      Election election = new Election(rs.getInt("election_id"), 
                          rs.getString("election_name"), 
                          rs.getDate("election_record_startdate"), 
                          rs.getDate("election_record_enddate"),
                          rs.getInt("election_status_id"),
                          rs.getBoolean("record_status"));
    return election;
    }

    @Override
    public Set<Election> all() throws SQLException {
        Connection conn = DaoFactory.getDB(MYSQL_AS_DB).openConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(ALL);

        Set elections = new HashSet();

        while (rs.next()) {
            Election election = extractUserFromResultSet(rs);
            elections.add(election);
        }
        st.close();
        conn.close();
        return elections;
    }

    @Override
    public boolean insert(Election election) throws SQLException {
        Connection conn = DaoFactory.getDB(MYSQL_AS_DB).openConnection();
        PreparedStatement pst = conn.prepareStatement(INSERT);
        pst.setString(1, election.getElection_name());
        pst.setInt(2, election.getElection_status_id());
        pst.setBoolean(3, true);

        int i = pst.executeUpdate();
        if (i == 1) {
            return true;
        }
        pst.close();
        conn.close();
        return false;
    }

    @Override
    public boolean update(Election election) throws SQLException {
        Connection conn = DaoFactory.getDB(MYSQL_AS_DB).openConnection();
        PreparedStatement pst = conn.prepareStatement(UPDATE);
        pst.setString(1, election.getElection_name());
//        pst.setInt(2, election.getElection_status_id());
        pst.setInt(2, election.getElection_id());
        int i = pst.executeUpdate();

        if (i == 1) {
            return true;
        }
        pst.close();
        conn.close();
        return false;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        Connection conn = DaoFactory.getDB(MYSQL_AS_DB).openConnection();
        PreparedStatement pst = conn.prepareStatement(DELETE);
        pst.setInt(1, id);
        int i = pst.executeUpdate();

        if (i == 1) {
            return true;
        }
        pst.close();
        conn.close();
        return false;
    }

    @Override
    public boolean electionPending(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean electionRun(int id) throws SQLException {
        Connection conn = DaoFactory.getDB(MYSQL_AS_DB).openConnection();
        PreparedStatement pst = conn.prepareStatement(ELECTION_RUN);
        pst.setInt(1, id);
        int i = pst.executeUpdate();

        if (i == 1) {
            return true;
        }
        pst.close();
        conn.close();
        return false;
    }

    @Override
    public boolean electionPause(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean electionEnd(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isElectionNameUsed(String election_name) throws SQLException {
        Connection conn = DaoFactory.getDB(MYSQL_AS_DB).openConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(FIND_BY_ELECTIONNAME + " '" +election_name+ "'");
//        ResultSet rs = st.executeQuery(FIND_BY_ELECTIONNAME + election_name);
        if (rs.next()) {
            return true;
        }
        st.close();
        conn.close();
        return false;
    }

    @Override
    public boolean isElectionRunning(int id) throws SQLException {
        Connection conn = DaoFactory.getDB(MYSQL_AS_DB).openConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(IS_ELECTION_RUNNING + id);
        if (rs.next()) {
            return true;
        }
        st.close();
        conn.close();
        return false;
    }

    @Override
    public boolean updateStartDate(int id) throws SQLException {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(date);
        Connection conn = DaoFactory.getDB(MYSQL_AS_DB).openConnection();
        PreparedStatement pst = conn.prepareStatement(UPDATE_STARTDATE);
        pst.setString(1, currentTime);
//        pst.setInt(2, election.getElection_status_id());
        pst.setInt(2, id);
        int i = pst.executeUpdate();

        if (i == 1) {
            return true;
        }
        pst.close();
        conn.close();
        return false;
    }

    @Override
    public boolean updateEndDate(int id) throws SQLException {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(date);
        Connection conn = DaoFactory.getDB(MYSQL_AS_DB).openConnection();
        PreparedStatement pst = conn.prepareStatement(UPDATE_ENDDATE);
        pst.setString(1, currentTime);
//        pst.setInt(2, election.getElection_status_id());
        pst.setInt(2, id);
        int i = pst.executeUpdate();

        if (i == 1) {
            return true;
        }
        pst.close();
        conn.close();
        return false;
    }

    @Override
    public Election returnElectionRunningID() throws SQLException {
        Connection conn = DaoFactory.getDB(MYSQL_AS_DB).openConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(RETURN_RUNNING_ELECTION_ID);
        if (rs.next()) {
            return extractUserFromResultSet(rs);
        }
        st.close();
        conn.close();
        return null;
    }

    

}
