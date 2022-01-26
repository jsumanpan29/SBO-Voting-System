
public class Student {
    
    private int student_id;
    private String firstname;
    private String middlename;
    private String lastname;
    private int studentno;
    private int yearlvl;
    private Boolean has_verified;
    private Boolean record_status;
    
    public Student() {
    }

    public Student(int student_id, String firstname, String middlename, String lastname, int studentno, int yearlvl, Boolean has_verified, Boolean record_status) {
        this.student_id = student_id;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.studentno = studentno;
        this.yearlvl = yearlvl;
        this.has_verified = has_verified;
        this.record_status = record_status;
    }

    public int getStudent_id() {
        return student_id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public int getStudentno() {
        return studentno;
    }

    public int getYearlvl() {
        return yearlvl;
    }

    public Boolean getHas_verified() {
        return has_verified;
    }

    public Boolean getRecord_status() {
        return record_status;
    }


    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setStudentno(int studentno) {
        this.studentno = studentno;
    }

    public void setYearlvl(int yearlvl) {
        this.yearlvl = yearlvl;
    }

    public void setHas_verified(Boolean has_verified) {
        this.has_verified = has_verified;
    }

    public void setRecord_status(Boolean record_status) {
        this.record_status = record_status;
    }

    
    
}
