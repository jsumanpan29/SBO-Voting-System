
public class Party {
    
    private int party_id;
    private String party_name;
    private String party_abbreviation;
    private Boolean record_status;

    public Party() {
    }

    public Party(int party_id, String party_name, String party_abbreviation, Boolean record_status) {
        this.party_id = party_id;
        this.party_name = party_name;
        this.party_abbreviation = party_abbreviation;
        this.record_status = record_status;
    }

    public int getParty_id() {
        return party_id;
    }

    public String getParty_name() {
        return party_name;
    }

    public String getParty_abbreviation() {
        return party_abbreviation;
    }

    public Boolean getRecord_status() {
        return record_status;
    }

    public void setParty_id(int party_id) {
        this.party_id = party_id;
    }

    public void setParty_name(String party_name) {
        this.party_name = party_name;
    }

    public void setParty_abbreviation(String party_abbreviation) {
        this.party_abbreviation = party_abbreviation;
    }

    public void setRecord_status(Boolean record_status) {
        this.record_status = record_status;
    }
    
    
    
}
