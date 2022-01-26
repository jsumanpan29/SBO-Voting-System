//
//import java.util.Set;
//import java.sql.*;
//import java.util.HashSet;
//
//public interface StudentUserDao {
//    
//    StudentUser findByID(int id) throws SQLException;
//    Set<StudentUser> all() throws SQLException;
//    boolean insert(StudentUser studentuser) throws SQLException;
//    boolean update(StudentUser studentuser) throws SQLException;
//    boolean delete(int id) throws SQLException;
//}
//
//class StudentUserDaoImpl implements StudentUserDao{
//    
//    private static final int MYSQL_AS_DB = 1; 
//    private static final String INSERT = "INSERT INTO student_user VALUES (?,?)";
//    private static final String ALL = "SELECT * from student_user";
//    private static final String FIND_BY_ID = "SELECT * FROM student_user WHERE user_id =";
//    private static final String DELETE = "UPDATE student_user SET user_id = NULL WHERE student_id = ?";
//    private static final String UPDATE = "UPDATE student_user SET user_id = ? WHERE student_id = ?";
//
//    @Override
//    public StudentUser findByID(int id) throws SQLException {
//          Connection conn = DaoFactory.getDB(MYSQL_AS_DB).openConnection();
//        Statement st = conn.createStatement();
//        ResultSet rs = st.executeQuery(FIND_BY_ID + id);
//        if (rs.next()) {
//            return extractUserFromResultSet(rs);
//        }
//        st.close();
//        conn.close();
//        return null;
//    }
//    
//    private StudentUser extractUserFromResultSet(ResultSet rs) throws SQLException {
//
//        StudentUser studentuser = new StudentUser(rs.getInt("student_id"), 
//                            rs.getInt("user_id"));
//        return studentuser;
//
//    }
//
//    @Override
//    public Set<StudentUser> all() throws SQLException {
//        Connection conn = DaoFactory.getDB(MYSQL_AS_DB).openConnection();
//        Statement st = conn.createStatement();
//        ResultSet rs = st.executeQuery(ALL);
//
//        Set studentusers = new HashSet();
//
//        while (rs.next()) {
//            StudentUser studentuser = extractUserFromResultSet(rs);
//            studentusers.add(studentuser);
//        }
//        st.close();
//        conn.close();
//        return null;
//    }
//
//    @Override
//    public boolean insert(StudentUser studentuser) throws SQLException {
//        Connection conn = DaoFactory.getDB(MYSQL_AS_DB).openConnection();
//        PreparedStatement pst = conn.prepareStatement(INSERT);
//        pst.setInt(1, studentuser.getStudent_id());
//        pst.setInt(2, studentuser.getUser_id());
//
//        int i = pst.executeUpdate();
//        if (i == 1) {
//            return true;
//        }
//        pst.close();
//        conn.close();
//        return false;
//    }
//
//    @Override
//    public boolean update(StudentUser studentuser) throws SQLException {
//        Connection conn = DaoFactory.getDB(MYSQL_AS_DB).openConnection();
//        PreparedStatement pst = conn.prepareStatement(UPDATE);
//         pst.setInt(1, studentuser.getUser_id());
//        pst.setInt(2, studentuser.getStudent_id());
//        int i = pst.executeUpdate();
//
//        if (i == 1) {
//            return true;
//        }
//        pst.close();
//        conn.close();
//        return false;
//    }
//    
//    @Override
//    public boolean delete(int id) throws SQLException {
//        Connection conn = DaoFactory.getDB(MYSQL_AS_DB).openConnection();
//        PreparedStatement pst = conn.prepareStatement(DELETE);
//        pst.setInt(1, id);
//        int i = pst.executeUpdate();
//
//        if (i == 1) {
//            return true;
//        }
//        pst.close();
//        conn.close();
//        return false;
//    }
//
//    
//
//}