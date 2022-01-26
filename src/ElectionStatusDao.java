
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;
public interface ElectionStatusDao {
    ElectionStatus findByID(int id) throws SQLException;
    Set<ElectionStatus> all() throws SQLException;
    boolean insert(ElectionStatus electionStatus) throws SQLException;
    boolean update(ElectionStatus electionStatus) throws SQLException;
    boolean delete(int id) throws SQLException;
}

class ElectionStatusDaoImpl implements ElectionStatusDao{

    private static final int MYSQL_AS_DB = 1; 
//    private static final String INSERT = "INSERT INTO election VALUES (NULL, ?, NULL, NULL, ?, ?)";
    private static final String ALL = "SELECT * from election_status ORDER BY election_status_id ASC";
    private static final String FIND_BY_ID = "SELECT * FROM election_status WHERE election_status_id =";
//    private static final String DELETE = "UPDATE election SET record_status = 0 WHERE election_id = ?";
//    private static final String UPDATE = "UPDATE election SET election_name = ?,  election_status_id = ? WHERE election_id = ?";

    @Override
    public ElectionStatus findByID(int id) throws SQLException {
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

    private ElectionStatus extractUserFromResultSet(ResultSet rs) throws SQLException {

      ElectionStatus electionStatus = new ElectionStatus(rs.getInt("election_status_id"), 
                          rs.getString("election_status_description"));
    return electionStatus;
    }
    
    @Override
    public Set<ElectionStatus> all() throws SQLException {
        Connection conn = DaoFactory.getDB(MYSQL_AS_DB).openConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(ALL);

        Set electionStats = new HashSet();

        while (rs.next()) {
            ElectionStatus electionStatus = extractUserFromResultSet(rs);
            electionStats.add(electionStatus);
        }
        st.close();
        conn.close();
        return electionStats;
    }

    @Override
    public boolean insert(ElectionStatus electionStatus) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(ElectionStatus electionStatus) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}