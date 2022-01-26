
public class StudentCandidate {
    
    private int student_id;
    private Boolean record_status;

    public StudentCandidate() {
    }

    public StudentCandidate(int student_id, Boolean record_status) {
        this.student_id = student_id;
        this.record_status = record_status;
    }

    public int getStudent_id() {
        return student_id;
    }

    public Boolean getRecord_status() {
        return record_status;
    }

    public void setRecord_status(Boolean record_status) {
        this.record_status = record_status;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    
    
    
    
}
