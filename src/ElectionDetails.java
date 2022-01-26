
public class ElectionDetails {
    
    private int election_id;
    private int student_candidate_id;
    private int party_id;
    private int position_id;

    public ElectionDetails() {
    }

    public ElectionDetails(int election_id, int student_candidate_id, int party_id, int position_id) {
        this.election_id = election_id;
        this.student_candidate_id = student_candidate_id;
        this.party_id = party_id;
        this.position_id = position_id;
    }

    public int getElection_id() {
        return election_id;
    }

    public int getStudent_candidate_id() {
        return student_candidate_id;
    }

    public int getParty_id() {
        return party_id;
    }

    public int getPosition_id() {
        return position_id;
    }

    public void setElection_id(int election_id) {
        this.election_id = election_id;
    }

    public void setStudent_candidate_id(int student_candidate_id) {
        this.student_candidate_id = student_candidate_id;
    }

    public void setParty_id(int party_id) {
        this.party_id = party_id;
    }

    public void setPosition_id(int position_id) {
        this.position_id = position_id;
    }
    
    
}
