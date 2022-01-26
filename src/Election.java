
import java.util.Date;


public class Election {
    
    private int election_id;
    private String election_name;
    private Date election_record_startdate;
    private Date election_record_enddate;
    private int election_status_id;
    private Boolean record_status;

    public Election() {
    }

    public Election(int election_id, String election_name, Date election_record_startdate, Date election_record_enddate, int election_status_id, Boolean record_status) {
        this.election_id = election_id;
        this.election_name = election_name;
        this.election_record_startdate = election_record_startdate;
        this.election_record_enddate = election_record_enddate;
        this.election_status_id = election_status_id;
        this.record_status = record_status;
    }

    public int getElection_id() {
        return election_id;
    }

    public String getElection_name() {
        return election_name;
    }

    public Date getElection_record_startdate() {
        return election_record_startdate;
    }

    public Date getElection_record_enddate() {
        return election_record_enddate;
    }

    public int getElection_status_id() {
        return election_status_id;
    }

    public Boolean getRecord_status() {
        return record_status;
    }

    public void setElection_id(int election_id) {
        this.election_id = election_id;
    }

    public void setElection_name(String election_name) {
        this.election_name = election_name;
    }

    public void setElection_record_startdate(Date election_record_startdate) {
        this.election_record_startdate = election_record_startdate;
    }

    public void setElection_record_enddate(Date election_record_enddate) {
        this.election_record_enddate = election_record_enddate;
    }

    public void setElection_status_id(int election_status_id) {
        this.election_status_id = election_status_id;
    }

    public void setRecord_status(Boolean record_status) {
        this.record_status = record_status;
    }
    
    
    
    
}
