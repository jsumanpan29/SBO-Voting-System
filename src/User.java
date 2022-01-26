public class User{

    private int userID;
    private String userName;
    private String passWord;
    private Boolean isAdmin;
    private Boolean recordStatus;
    private Boolean isLoggedIn;
    private int student_id;
    
    public User() {
    }

    public User(Integer userID, String userName, String passWord, Boolean isAdmin, Boolean isLoggedIn, Boolean recordStatus, int student_id) {
        this.userID = userID;
        this.userName = userName;
        this.passWord = passWord;
        this.isAdmin = isAdmin;
        this.isLoggedIn = isLoggedIn;
        this.recordStatus = recordStatus;
        this.student_id = student_id;
    }
    
    

    public Integer getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

     public String getPassWord() {
        return passWord;
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public Boolean getRecordStatus() {
        return recordStatus;
    }

    public Boolean getIsLoggedIn() {
        return isLoggedIn;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public void setRecordStatus(Boolean recordStatus) {
        this.recordStatus = recordStatus;
    }

    public void setIsLoggedIn(Boolean isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }
    
    
  
}