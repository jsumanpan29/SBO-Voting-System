
import java.util.Set;
import java.sql.*;
import java.util.HashSet;

public interface UserDao {
    
    User findByID(int id) throws SQLException;
    Set<User> all() throws SQLException;
    User findByLogin(String username, String pass) throws SQLException;
    boolean insert(User user) throws SQLException;
    boolean update(User user) throws SQLException;
    boolean updateRecords(User user) throws SQLException;
    boolean delete(int id) throws SQLException;
    boolean logInStatusUpdateTrue(int id) throws SQLException;
    boolean logInStatusUpdateFalse(int id) throws SQLException;
    boolean isUsernameUsed(String username) throws SQLException;
    User findByUsername(String username) throws SQLException;
    User findByStudentID(int student_id) throws SQLException;
    User findByStudentIDInactive(int student_id) throws SQLException;
}   

class UserDaoImpl implements UserDao{
    
    private static final int MYSQL_AS_DB = 1; 
    private static final String INSERT = "INSERT INTO user VALUES (NULL, ?, ?, ?, ?, ?, ?)";
    private static final String ALL = "SELECT * from user";
    private static final String FIND_BY_ID = "SELECT * FROM user WHERE user_id =";
    private static final String FIND_BY_STUDENT_ID_ACTIVE = "SELECT * FROM user WHERE record_status = 1 and student_id =";
    private static final String FIND_BY_STUDENT_ID_INACTIVE = "SELECT * FROM user WHERE record_status = 0 and student_id =";
    private static final String FIND_IF_USER_EXISTS = "SELECT * FROM user WHERE username = ";
    private static final String FIND_BY_LOGIN = "SELECT * FROM user WHERE username = ? and password = ? and record_status = 1";
    private static final String FIND_BY_USERNAME = "SELECT * FROM user where username =";
    private static final String DELETE = "UPDATE user SET record_status = 0 WHERE user_id = ?";
    private static final String UPDATE = "UPDATE user SET username = ?, password = ?, student_id = ? WHERE user_id = ?";
    private static final String UPDATE_RECORDS = "UPDATE user SET username = ?, password = ?, student_id = ?, record_status = 1 WHERE user_id = ?";
    private static final String UPDATE_LOGIN_STATUS_TRUE = "UPDATE user SET is_logged_in = 1 WHERE user_id = ?";
    private static final String UPDATE_LOGIN_STATUS_FALSE = "UPDATE user SET is_logged_in = 0 WHERE user_id = ?";
    
    @Override
    public User findByID(int id) throws SQLException {
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
    
    private User extractUserFromResultSet(ResultSet rs) throws SQLException {

        User user = new User(rs.getInt("user_id"), 
                            rs.getString("username"), 
                            rs.getString("password"), 
                            rs.getBoolean("is_admin"), 
                            rs.getBoolean("is_logged_in"), 
                           rs.getBoolean("record_status"),
                           rs.getInt("student_id"));
        return user;

    }

    @Override
    public Set<User> all() throws SQLException {
        Connection conn = DaoFactory.getDB(MYSQL_AS_DB).openConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(ALL);

        Set users = new HashSet();

        while (rs.next()) {
            User user = extractUserFromResultSet(rs);
            users.add(user);
        }
        st.close();
        conn.close();
        return users;
    }

    @Override
    public User findByLogin(String username, String password) throws SQLException {
        Connection conn = DaoFactory.getDB(MYSQL_AS_DB).openConnection();
        PreparedStatement pst = conn.prepareStatement(FIND_BY_LOGIN);
        pst.setString(1, username);
        pst.setString(2, password);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            return extractUserFromResultSet(rs);
        }
        pst.close();
        conn.close();
        return null;
    }

    @Override
    public boolean insert(User user) throws SQLException {
        Connection conn = DaoFactory.getDB(MYSQL_AS_DB).openConnection();
        PreparedStatement pst = conn.prepareStatement(INSERT);
        pst.setString(1, user.getUserName());
        pst.setString(2, user.getPassWord());
        pst.setBoolean(3, false);
        pst.setBoolean(4, false);
        pst.setBoolean(5, true);
        pst.setInt(6, user.getStudent_id());

        int i = pst.executeUpdate();
        if (i == 1) {
            return true;
        }
        pst.close();
        conn.close();
        return false;
    }

    @Override
    public boolean update(User user) throws SQLException {
        Connection conn = DaoFactory.getDB(MYSQL_AS_DB).openConnection();
        PreparedStatement pst = conn.prepareStatement(UPDATE);
         pst.setString(1, user.getUserName());
        pst.setString(2, user.getPassWord());
        pst.setInt(3, user.getStudent_id());
        pst.setInt(4, user.getUserID());
        int i = pst.executeUpdate();

        if (i == 1) {
            return true;
        }
        pst.close();
        conn.close();
        return false;
    }
    
    @Override
    public boolean updateRecords(User user) throws SQLException {
        Connection conn = DaoFactory.getDB(MYSQL_AS_DB).openConnection();
        PreparedStatement pst = conn.prepareStatement(UPDATE_RECORDS);
         pst.setString(1, user.getUserName());
        pst.setString(2, user.getPassWord());
        pst.setInt(3, user.getStudent_id());
        pst.setInt(4, user.getUserID());
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
    public boolean logInStatusUpdateTrue(int id) throws SQLException {
        Connection conn = DaoFactory.getDB(MYSQL_AS_DB).openConnection();
        PreparedStatement pst = conn.prepareStatement(UPDATE_LOGIN_STATUS_TRUE);
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
    public boolean logInStatusUpdateFalse(int id) throws SQLException {
        Connection conn = DaoFactory.getDB(MYSQL_AS_DB).openConnection();
        PreparedStatement pst = conn.prepareStatement(UPDATE_LOGIN_STATUS_FALSE);
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
    public boolean isUsernameUsed(String username) throws SQLException {
//   
        Connection conn = DaoFactory.getDB(MYSQL_AS_DB).openConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(FIND_IF_USER_EXISTS + "'" + username + "'");
        if (rs.next()) {
            return true;
        }
        st.close();
        conn.close();
        return false;
    }

    @Override
    public User findByUsername(String username) throws SQLException {
        Connection conn = DaoFactory.getDB(MYSQL_AS_DB).openConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(FIND_BY_USERNAME + "'" + username + "'");
        if (rs.next()) {
            return extractUserFromResultSet(rs);
        }
        st.close();
        conn.close();
        return null;
    }

    @Override
    public User findByStudentID(int student_id) throws SQLException {
        Connection conn = DaoFactory.getDB(MYSQL_AS_DB).openConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(FIND_BY_STUDENT_ID_ACTIVE + student_id);
        if (rs.next()) {
            return extractUserFromResultSet(rs);
        }
        st.close();
        conn.close();
        return null;
    }
    
    @Override
    public User findByStudentIDInactive(int student_id) throws SQLException {
        Connection conn = DaoFactory.getDB(MYSQL_AS_DB).openConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(FIND_BY_STUDENT_ID_INACTIVE + student_id);
        if (rs.next()) {
            return extractUserFromResultSet(rs);
        }
        st.close();
        conn.close();
        return null;
    }
    
    
    

}