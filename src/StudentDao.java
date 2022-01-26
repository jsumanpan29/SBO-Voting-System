
import java.util.Set;
import java.sql.*;
import java.util.HashSet;

public interface StudentDao {
    
    Student findByID(int id) throws SQLException;
    Set<Student> all() throws SQLException;
    boolean insert(Student student) throws SQLException;
    boolean update(Student student) throws SQLException;
    boolean delete(int id) throws SQLException;
    boolean hasVerified(int id) throws SQLException;
    Student findByStudentno(int studentno) throws SQLException;
    boolean isStudentnoUsed(int studentno) throws SQLException;
//    int hasVoted(int id) throws SQLException;
}

class StudentDaoImpl implements StudentDao{

    private static final int MYSQL_AS_DB = 1; 
    private static final String INSERT = "INSERT INTO student VALUES (NULL, ?, ?, ?, ?, ?, ?, ?)";
    private static final String ALL = "SELECT * from student WHERE record_status = 1 ORDER BY student_id ASC";
    private static final String FIND_BY_ID = "SELECT * FROM student WHERE student_id =";
    private static final String FIND_BY_STUDENTNO = "SELECT * FROM student WHERE studentno =";
    private static final String DELETE = "UPDATE student SET record_status = 0 WHERE student_id = ?";
    private static final String UPDATE = "UPDATE student SET firstname = ?, middlename = ?, lastname = ?, studentno = ?, yearlvl = ?, has_verified = ? WHERE student_id = ?";
    private static final String HAS_VERIFIED = "SELECT has_verified FROM student WHERE student_id =";
    
//    private static final String HAS_VOTED = "SELECT has_voted FROM student WHERE student_id =";

    @Override
    public Student findByID(int id) throws SQLException {
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

    @Override
    public Student findByStudentno(int studentno) throws SQLException {
        Connection conn = DaoFactory.getDB(MYSQL_AS_DB).openConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(FIND_BY_STUDENTNO + studentno);
        if (rs.next()) {
            return extractUserFromResultSet(rs);
        }
        st.close();
        conn.close();
        return null;
    }

    @Override
    public boolean isStudentnoUsed(int studentno) throws SQLException {
        Connection conn = DaoFactory.getDB(MYSQL_AS_DB).openConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(FIND_BY_STUDENTNO + studentno);
        if (rs.next()) {
            if(extractUserFromResultSet(rs)!=null){
                return true;
            }else{
                return false;
            }
        }
        st.close();
        conn.close();
        return false;
    }
    
    
    
      private Student extractUserFromResultSet(ResultSet rs) throws SQLException {

        Student student = new Student(rs.getInt("student_id"), 
                            rs.getString("firstname"), 
                            rs.getString("middlename"), 
                            rs.getString("lastname"),
                            rs.getInt("studentno"),
                            rs.getInt("yearlvl"),
                            rs.getBoolean("has_verified"), 
                            rs.getBoolean("record_status"));
        return student;

    }

    @Override
    public boolean hasVerified(int id) throws SQLException {
        Connection conn = DaoFactory.getDB(MYSQL_AS_DB).openConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(HAS_VERIFIED + id);
        if (rs.next()) {
            Student student = extractUserFromResultSet(rs);
            return student.getHas_verified();
        }
        st.close();
        conn.close();
        return false;
    }

//    @Override
//    public int hasVoted(int id) throws SQLException {
//        Connection conn = DaoFactory.getDB(MYSQL_AS_DB).openConnection();
//        Statement st = conn.createStatement();
//        ResultSet rs = st.executeQuery(HAS_VOTED + id);
//        if (rs.next()) {
//            Student student = extractUserFromResultSet(rs);
//            return student.getVote_id();
//        }
//        st.close();
//        conn.close();
//        return 0;
//    }

    @Override
    public boolean insert(Student student) throws SQLException {
        Connection conn = DaoFactory.getDB(MYSQL_AS_DB).openConnection();
        PreparedStatement pst = conn.prepareStatement(INSERT);
        pst.setString(1, student.getFirstname());
        pst.setString(2, student.getMiddlename());
        pst.setString(3, student.getLastname());
        pst.setInt(4, student.getStudentno());
        pst.setInt(5, student.getYearlvl());
        pst.setBoolean(6, student.getHas_verified());
        pst.setBoolean(7, true);

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
    public Set<Student> all() throws SQLException {
        Connection conn = DaoFactory.getDB(MYSQL_AS_DB).openConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(ALL);

        Set students = new HashSet();

        while (rs.next()) {
            Student student = extractUserFromResultSet(rs);
            students.add(student);
        }
        st.close();
        conn.close();
        return students;
    }

    @Override
    public boolean update(Student student) throws SQLException {
      Connection conn = DaoFactory.getDB(MYSQL_AS_DB).openConnection();
        PreparedStatement pst = conn.prepareStatement(UPDATE);
        pst.setString(1, student.getFirstname());
        pst.setString(2, student.getMiddlename());
        pst.setString(3, student.getLastname());
        pst.setInt(4, student.getStudentno());
        pst.setInt(5, student.getYearlvl());
        pst.setBoolean(6, student.getHas_verified());
        pst.setInt(7, student.getStudent_id());
        int i = pst.executeUpdate();

        if (i == 1) {
            return true;
        }
        pst.close();
        conn.close();
        return false;
    }
    
    

}