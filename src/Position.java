
public class Position {
    private int position_id;
    private String position_name;
    private int position_level;
    private int position_slot;
    private Boolean record_status;

    public Position() {
    }

    public Position(int position_id, String position_name, int position_level, int position_slot, Boolean record_status) {
        this.position_id = position_id;
        this.position_name = position_name;
        this.position_level = position_level;
        this.position_slot = position_slot;
        this.record_status = record_status;
    }

    public int getPosition_id() {
        return position_id;
    }

    public String getPosition_name() {
        return position_name;
    }

    public int getPosition_level() {
        return position_level;
    }

    public int getPosition_slot() {
        return position_slot;
    }

    public Boolean getRecord_status() {
        return record_status;
    }

    public void setPosition_id(int position_id) {
        this.position_id = position_id;
    }

    public void setPosition_name(String position_name) {
        this.position_name = position_name;
    }

    public void setPosition_level(int position_level) {
        this.position_level = position_level;
    }

    public void setPosition_slot(int position_slot) {
        this.position_slot = position_slot;
    }

    public void setRecord_status(Boolean record_status) {
        this.record_status = record_status;
    }
    
    
}
