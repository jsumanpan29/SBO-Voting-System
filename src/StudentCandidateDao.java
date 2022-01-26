
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;


public interface StudentCandidateDao {
    
    StudentCandidate findByStudentID(int id) throws SQLException;
    Set<StudentCandidate> all() throws SQLException;
    boolean insert(StudentCandidate studentcandidate) throws SQLException;
    boolean update(StudentCandidate studentcandidate) throws SQLException;
    boolean delete(int id) throws SQLException;
}

class StudentCandidateImpl implements StudentCandidateDao{
    
    private static final int MYSQL_AS_DB = 1; 
    private static final String INSERT = "INSERT INTO student_candidate VALUES (?,?)";
    private static final String ALL = "SELECT * from student_candidate WHERE record_status = 1";
    private static final String FIND_BY_ID = "SELECT * FROM student_candidate WHERE student_id =";
    private static final String DELETE = "UPDATE student_candidate SET record_status = 0 WHERE student_id = ?";
    private static final String UPDATE = "UPDATE student_candidate SET record_status = ? WHERE student_id = ?";

    @Override
    public StudentCandidate findByStudentID(int id) throws SQLException {
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
    public Set<StudentCandidate> all() throws SQLException {
        Connection conn = DaoFactory.getDB(MYSQL_AS_DB).openConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(ALL);

        Set studentusers = new HashSet();

        while (rs.next()) {
            StudentUser studentuser = extractUserFromResultSet(rs);
            studentusers.add(studentuser);
        }
        st.close();
        conn.close();
        return studentusers;
    }
     private StudentCandidate extractUserFromResultSet(ResultSet rs) throws SQLException {

        StudentCandidate studentCandidate = new StudentCandidate(rs.getInt("student_id"), rs.getBoolean("record_status"));
        return studentCandidate;
     } 
    @Override
    public boolean insert(StudentCandidate studentcandidate) throws SQLException {
        Connection conn = DaoFactory.getDB(MYSQL_AS_DB).openConnection();
        PreparedStatement pst = conn.prepareStatement(INSERT);
        pst.setInt(1, studentcandidate.getStudent_id());
        pst.setBoolean(2, true);

        int i = pst.executeUpdate();
        if (i == 1) {
            return true;
        }
        pst.close();
        conn.close();
        return false;
    }

    @Override
    public boolean update(StudentCandidate studentcandidate) throws SQLException {
       Connection conn = DaoFactory.getDB(MYSQL_AS_DB).openConnection();
        PreparedStatement pst = conn.prepareStatement(UPDATE);
        pst.setInt(1, studentcandidate.getStudent_id());
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
    
    
}