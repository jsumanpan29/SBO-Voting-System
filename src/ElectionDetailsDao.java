
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;


public interface ElectionDetailsDao {
    boolean findByID(int id) throws SQLException;
    Set<ElectionDetails> all(int id) throws SQLException;
    boolean insert(ElectionDetails electionDetails) throws SQLException;
    boolean update(ElectionDetails electionDetails) throws SQLException;
    boolean delete(int election_id) throws SQLException;
    boolean delete_student(int election_id, int student_id) throws SQLException;
    boolean findByStudentID(int election_id, int student_id) throws SQLException;
    ElectionDetails findByStudentID_Value(int election_id, int student_id) throws SQLException;
    Set<ElectionDetails> findByPositionID_Value(int election_id, int position_id) throws SQLException;
}

class ElectionDetailsDaoImpl implements ElectionDetailsDao{
//DELETE FROM user WHERE id=?
    private static final int MYSQL_AS_DB = 1; 
    private static final String INSERT = "INSERT INTO election_details VALUES (?, ?, ?, ?)";
//    private static final String ALL = "SELECT * from election_details where election_id =";
    private static final String FIND_BY_ID = "SELECT * FROM election_details WHERE election_id =";
    private static final String FIND_BY_STUDENTID = "SELECT * FROM election_details WHERE election_id = ? and student_candidate_id = ?";
    private static final String DELETE_STUDENT = "DELETE FROM election_details WHERE election_id = ? and student_candidate_id = ?";
    private static final String FIND_BY_POSITIONID = "SELECT * FROM election_details WHERE election_id = ? and position_id = ?";
    private static final String DELETE = "DELETE FROM election_details WHERE election_id = ?";
    private static final String UPDATE = "UPDATE election_details SET party_id = ?, position_id = ? WHERE student_candidate_id = ? and election_id = ?";

    @Override
    public boolean findByID(int id) throws SQLException {
        Connection conn = DaoFactory.getDB(MYSQL_AS_DB).openConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(FIND_BY_ID + id);
        if (rs.next()) {
            return true;
        }
        st.close();
        conn.close();
        return false;
    }

    private ElectionDetails extractUserFromResultSet(ResultSet rs) throws SQLException {

      ElectionDetails electionDetails = new ElectionDetails(rs.getInt("election_id"),
                          rs.getInt("student_candidate_id"),
                          rs.getInt("party_id"),
                          rs.getInt("position_id"));
    return electionDetails;
    }
    
    @Override
    public Set<ElectionDetails> all(int id) throws SQLException {
        Connection conn = DaoFactory.getDB(MYSQL_AS_DB).openConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(FIND_BY_ID + id);

        Set electionD = new HashSet();

        while (rs.next()) {
            ElectionDetails electionDetails = extractUserFromResultSet(rs);
            electionD.add(electionDetails);
        }
        st.close();
        conn.close();
        return electionD;
        
    }

    @Override
    public boolean insert(ElectionDetails electionDetails) throws SQLException {
        Connection conn = DaoFactory.getDB(MYSQL_AS_DB).openConnection();
        PreparedStatement pst = conn.prepareStatement(INSERT);
        pst.setInt(1, electionDetails.getElection_id());
        pst.setInt(2, electionDetails.getStudent_candidate_id());
        pst.setInt(3, electionDetails.getParty_id());
        pst.setInt(4, electionDetails.getPosition_id());

        int i = pst.executeUpdate();
        if (i == 1) {
            return true;
        }
        pst.close();
        conn.close();
        return false;
    }

    @Override
    public boolean delete_student(int election_id, int student_id) throws SQLException {
        Connection conn = DaoFactory.getDB(MYSQL_AS_DB).openConnection();
        PreparedStatement pst = conn.prepareStatement(DELETE_STUDENT);
        pst.setInt(1, election_id);
        pst.setInt(2, student_id);

        int i = pst.executeUpdate();
        if (i == 1) {
            return true;
        }
        pst.close();
        conn.close();
        return false;
    }

    @Override
    public boolean findByStudentID(int election_id, int student_candidate_id) throws SQLException {
        Connection conn = DaoFactory.getDB(MYSQL_AS_DB).openConnection();
//        Statement st = conn.createStatement();
        PreparedStatement pst = conn.prepareStatement(FIND_BY_STUDENTID);
        pst.setInt(1, election_id);
        pst.setInt(2, student_candidate_id);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            return true;
        }
        pst.close();
        conn.close();
        return false;
    }

    @Override
    public ElectionDetails findByStudentID_Value(int election_id, int student_id) throws SQLException {
        Connection conn = DaoFactory.getDB(MYSQL_AS_DB).openConnection();
//        Statement st = conn.createStatement();
        PreparedStatement pst = conn.prepareStatement(FIND_BY_STUDENTID);
        pst.setInt(1, election_id);
        pst.setInt(2, student_id);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            return extractUserFromResultSet(rs);
        }
        pst.close();
        conn.close();
        return null;
    }

    @Override
    public Set<ElectionDetails> findByPositionID_Value(int election_id, int position_id) throws SQLException {
        Connection conn = DaoFactory.getDB(MYSQL_AS_DB).openConnection();
//        Statement st = conn.createStatement();
        PreparedStatement pst = conn.prepareStatement(FIND_BY_POSITIONID);
        pst.setInt(1, election_id);
        pst.setInt(2, position_id);
        ResultSet rs = pst.executeQuery();
        Set electionD = new HashSet();

        while (rs.next()) {
            ElectionDetails electionDetails = extractUserFromResultSet(rs);
            electionD.add(electionDetails);
        }
        pst.close();
        conn.close();
        return electionD;
    }

    
    @Override
    public boolean delete(int election_id) throws SQLException {
        Connection conn = DaoFactory.getDB(MYSQL_AS_DB).openConnection();
        PreparedStatement pst = conn.prepareStatement(DELETE);
        pst.setInt(1, election_id);

        int i = pst.executeUpdate();
        if (i == 1) {
            return true;
        }
        pst.close();
        conn.close();
        return false;
    }
    
    

    @Override
    public boolean update(ElectionDetails electionDetails) throws SQLException {
        Connection conn = DaoFactory.getDB(MYSQL_AS_DB).openConnection();
        PreparedStatement pst = conn.prepareStatement(UPDATE);
        
        pst.setInt(1, electionDetails.getParty_id());
        pst.setInt(2, electionDetails.getPosition_id());
        pst.setInt(3, electionDetails.getStudent_candidate_id());
        pst.setInt(4, electionDetails.getElection_id());
        int i = pst.executeUpdate();

        if (i == 1) {
            return true;
        }
        pst.close();
        conn.close();
        return false;
    }
}