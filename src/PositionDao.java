
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;


public interface PositionDao {
    Position findByID(int id) throws SQLException;
    Set<Position> all() throws SQLException;
    Set<Position> all_byLevel() throws SQLException;
    boolean insert(Position position) throws SQLException;
    boolean update(Position position) throws SQLException;
    boolean delete(int id) throws SQLException;
//    Position findByStudentno(int studentno) throws SQLException;
    boolean IsPositionNameUsed(String position_name) throws SQLException;
    boolean IsPositionLevelUsed(int position_level) throws SQLException;
}
class PositionDaoImpl implements PositionDao{
    private static final int MYSQL_AS_DB = 1; 
    private static final String INSERT = "INSERT INTO position VALUES (NULL, ?, ?, ?, ?)";
    private static final String ALL = "SELECT * from position WHERE record_status = 1";
    private static final String ALL_BYLEVEL = "SELECT * from position WHERE record_status = 1 ORDER BY position_level ASC";
    private static final String FIND_BY_ID = "SELECT * FROM position WHERE position_id =";
    private static final String DELETE = "UPDATE position SET record_status = 0 WHERE position_id = ?";
    private static final String UPDATE = "UPDATE position SET position_name = ?,  position_level = ?,  position_slot = ? WHERE position_id = ?";
    private static final String FIND_BY_POSITIONNAME = "SELECT * FROM position WHERE record_status = 1 and position_name =";
    private static final String FIND_BY_POSITIONLEVEL= "SELECT * FROM position WHERE record_status = 1 and position_level =";

    @Override
    public Position findByID(int id) throws SQLException {
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
    private Position extractUserFromResultSet(ResultSet rs) throws SQLException {

    Position position = new Position(rs.getInt("position_id"), 
                          rs.getString("position_name"), 
                          rs.getInt("position_level"), 
                          rs.getInt("position_slot"), 
                          rs.getBoolean("record_status"));
    return position;
    }

    @Override
    public Set<Position> all() throws SQLException {
        Connection conn = DaoFactory.getDB(MYSQL_AS_DB).openConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(ALL);

        Set positions = new HashSet();

        while (rs.next()) {
            Position position = extractUserFromResultSet(rs);
            positions.add(position);
        }
        st.close();
        conn.close();
        return positions;
    }
    
    @Override
    public Set<Position> all_byLevel() throws SQLException {
        Connection conn = DaoFactory.getDB(MYSQL_AS_DB).openConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(ALL_BYLEVEL);

        Set positions = new HashSet();

        while (rs.next()) {
            Position position = extractUserFromResultSet(rs);
            positions.add(position);
        }
        st.close();
        conn.close();
        return positions;
    }

    @Override
    public boolean insert(Position position) throws SQLException {
       Connection conn = DaoFactory.getDB(MYSQL_AS_DB).openConnection();
        PreparedStatement pst = conn.prepareStatement(INSERT);
        pst.setString(1, position.getPosition_name());
        pst.setInt(2, position.getPosition_level());
        pst.setInt(3, position.getPosition_slot());
        pst.setBoolean(4, true);

        int i = pst.executeUpdate();
        if (i == 1) {
            return true;
        }
        pst.close();
        conn.close();
        return false;
    }

    @Override
    public boolean update(Position position) throws SQLException {
        Connection conn = DaoFactory.getDB(MYSQL_AS_DB).openConnection();
        PreparedStatement pst = conn.prepareStatement(UPDATE);
        pst.setString(1, position.getPosition_name());
        pst.setInt(2, position.getPosition_level());
        pst.setInt(3, position.getPosition_slot());
        pst.setInt(4, position.getPosition_id());
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
    public boolean IsPositionNameUsed(String position_name) throws SQLException {
        Connection conn = DaoFactory.getDB(MYSQL_AS_DB).openConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(FIND_BY_POSITIONNAME + "'" +position_name+ "'");
        if (rs.next()) {
            return true;
        }
        st.close();
        conn.close();
        return false;
    }

    @Override
    public boolean IsPositionLevelUsed(int position_level) throws SQLException {
        Connection conn = DaoFactory.getDB(MYSQL_AS_DB).openConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(FIND_BY_POSITIONLEVEL + position_level);
        if (rs.next()) {
            return true;
        }
        st.close();
        conn.close();
        return false;
    }

    

}
