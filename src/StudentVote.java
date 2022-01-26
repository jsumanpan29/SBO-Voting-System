
import java.util.Date;


public class StudentVote {
    private int vote_id;
    private int student_id;
    private int election_id;
    private int student_candidate_id;
    private Date vote_datetime;

    public StudentVote() {
    }

    public StudentVote(int vote_id, int student_id, int election_id, int student_candidate_id, Date vote_datetime) {
        this.vote_id = vote_id;
        this.student_id = student_id;
        this.election_id = election_id;
        this.student_candidate_id = student_candidate_id;
        this.vote_datetime = vote_datetime;
    }

    public int getVote_id() {
        return vote_id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public int getElection_id() {
        return election_id;
    }

    public int getStudent_candidate_id() {
        return student_candidate_id;
    }

    public Date getVote_datetime() {
        return vote_datetime;
    }

    public void setVote_id(int vote_id) {
        this.vote_id = vote_id;
    }

    public void setElection_id(int election_id) {
        this.election_id = election_id;
    }

    public void setStudent_candidate_id(int student_candidate_id) {
        this.student_candidate_id = student_candidate_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public void setVote_datetime(Date vote_datetime) {
        this.vote_datetime = vote_datetime;
    }
    
    
    
}
