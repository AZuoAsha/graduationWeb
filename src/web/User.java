package web;

//”√ªß55
public class User {
    private String userName;
    private String time;
    private long id;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public User(String userName, String time, long id) {
		super();
		this.userName = userName;
		this.time = time;
		this.id = id;
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", time=" + time + ", id=" + id + "]";
	}
	
}
