
public class ElectionStatus {
    private int election_status_id;
    private String election_status_description;

    public ElectionStatus() {
    }

    public ElectionStatus(int election_status_id, String election_status_description) {
        this.election_status_id = election_status_id;
        this.election_status_description = election_status_description;
    }

    public int getElection_status_id() {
        return election_status_id;
    }

    public String getElection_status_description() {
        return election_status_description;
    }

    public void setElection_status_description(String election_status_description) {
        this.election_status_description = election_status_description;
    }

    public void setElection_status_id(int election_status_id) {
        this.election_status_id = election_status_id;
    }
    
    
}
