package web;

//”√ªß
public class User {
    private String userName;
    private String time;
    
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
    @Override
	public String toString() {
		return "User [userName=" + userName + ", time=" + time + "]";
	}
	public User(String userName, String time) {
		super();
		this.userName = userName;
		this.time = time;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public User(){
        super();
    }
	
}
