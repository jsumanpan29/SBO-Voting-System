
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;


public interface StudentVoteDao {
//    boolean findByID(int id) throws SQLException;
    Set<StudentVote> allVotesElection(int id) throws SQLException;
    boolean insert(StudentVote studentVote) throws SQLException;
    Set<StudentVote> allVotesStudent(int id) throws SQLException;
    int allVoted(int id)throws SQLException;
    int allCandidates(int id)throws SQLException;
    int allVotes_Candidate(int election_id, int student_candidate_id)throws SQLException;
    boolean hasVoted(int election_id, int student_id)throws SQLException;
//    boolean hasVoted()throws SQLException;
//    boolean update(StudentVote studentVote) throws SQLException;
////    boolean delete(int election_id) throws SQLException;
////    boolean delete_student(int election_id, int student_id) throws SQLException;
////    boolean findByStudentID(int election_id, int student_id) throws SQLException;
////    StudentVote findByStudentID_Value(int election_id, int student_id) throws SQLException;
    
}

  class StudentVoteDaoImpl implements StudentVoteDao{
  
    private static final int MYSQL_AS_DB = 1; 
    private static final String INSERT = "INSERT INTO student_vote VALUES (NULL,?, ?, ?, ?)";
    private static final String ALL = "SELECT * from student_vote where election_id =";
    private static final String ALL_VOTES_STUDENT= "SELECT * from student_vote where student_id =";
    private static final String ALL_VOTED = "SELECT DISTINCT(student_id) from student_vote where election_id =";
    private static final String ALL_CANDIDATES = "SELECT DISTINCT(student_candidate_id) from student_vote where election_id =";
    private static final String ALL_VOTES_CANDIDATE = "SELECT student_id from student_vote where election_id = ? and student_candidate_id = ?";
    private static final String HAS_VOTED = "SELECT * from student_vote where election_id = ? and student_id = ?";
//    private static final String FIND_BY_ID = "SELECT * FROM student_vote WHERE election_id =";
//    private static final String FIND_BY_STUDENTID = "SELECT * FROM student_vote WHERE election_id = ? and student_candidate_id = ?";
//    private static final String DELETE_STUDENT = "DELETE FROM student_vote WHERE election_id = ? and student_candidate_id = ?";
//    private static final String FIND_BY_POSITIONID = "SELECT * FROM student_vote WHERE election_id = ? and position_id = ?";
//    private static final String DELETE = "DELETE FROM student_vote WHERE election_id = ?";
//    private static final String UPDATE = "UPDATE student_vote SET party_id = ?, position_id = ? WHERE student_candidate_id = ? and election_id = ?";

    @Override
    public Set<StudentVote> allVotesElection(int id) throws SQLException {
        Connection conn = DaoFactory.getDB(MYSQL_AS_DB).openConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(ALL+id);

        Set studentVotes = new HashSet();

        while (rs.next()) {
            StudentVote studentVote = extractUserFromResultSet(rs);
            studentVotes.add(studentVote);
        }
        st.close();
        conn.close();
        return studentVotes;
    }

    @Override
    public boolean hasVoted(int election_id, int student_id) throws SQLException {
       Connection conn = DaoFactory.getDB(MYSQL_AS_DB).openConnection();
        PreparedStatement pst = conn.prepareStatement(HAS_VOTED);
        pst.setInt(1, election_id);
        pst.setInt(2, student_id);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            return true;
        }
        pst.close();
        conn.close();
        return false;
    }

    
    @Override
    public int allVoted(int id) throws SQLException {
        int count = 0;
        Connection conn = DaoFactory.getDB(MYSQL_AS_DB).openConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(ALL_VOTED + id);
        while (rs.next()) {
//            if(rs.next()){
                count++;
//            }
        }
        st.close();
        conn.close();
        return count;
    }

    @Override
    public int allCandidates(int id) throws SQLException {
         int count = 0;
        Connection conn = DaoFactory.getDB(MYSQL_AS_DB).openConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(ALL_CANDIDATES + id);
        while (rs.next()) {
//            if(rs.next()){
                count++;
//            }
        }
        st.close();
        conn.close();
        return count;
    }

    @Override
    public int allVotes_Candidate(int election_id, int student_candidate_id) throws SQLException {
        int count = 0;
        Connection conn = DaoFactory.getDB(MYSQL_AS_DB).openConnection();
        PreparedStatement pst = conn.prepareStatement(ALL_VOTES_CANDIDATE);
        pst.setInt(1, election_id);
        pst.setInt(2, student_candidate_id);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
//            if(rs.next()){
                count++;
//            }
        }
        pst.close();
        conn.close();
        return count;
    }

    
    
    @Override
    public Set<StudentVote> allVotesStudent(int id) throws SQLException {
        Connection conn = DaoFactory.getDB(MYSQL_AS_DB).openConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(ALL_VOTES_STUDENT+id);

        Set studentVotes = new HashSet();

        while (rs.next()) {
            StudentVote studentVote = extractUserFromResultSet(rs);
            studentVotes.add(studentVote);
        }
        st.close();
        conn.close();
        return studentVotes;
    }
  
    private StudentVote extractUserFromResultSet(ResultSet rs) throws SQLException {

      StudentVote studentVote = new StudentVote(rs.getInt("vote_id"),
                          rs.getInt("student_id"),
                          rs.getInt("election_id"),
                          rs.getInt("student_candidate_id"),
                          rs.getDate("vote_datetime"));
    return studentVote;
    }
    
    @Override
    public boolean insert(StudentVote studentVote) throws SQLException {
        java.util.Date date = new java.util.Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(date);
        Connection conn = DaoFactory.getDB(MYSQL_AS_DB).openConnection();
        PreparedStatement pst = conn.prepareStatement(INSERT);
        pst.setInt(1, studentVote.getStudent_id());
        pst.setInt(2, studentVote.getElection_id());
        pst.setInt(3, studentVote.getStudent_candidate_id());
        pst.setString(4, currentTime);

        int i = pst.executeUpdate();
        if (i == 1) {
            return true;
        }
        pst.close();
        conn.close();
        return false;
    }
  }