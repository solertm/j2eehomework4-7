package items;

public class databasesource {
	private String Drivername;
	private String Url;
	private String Username;
	private String UserPassword;
	public String getDrivername() {
		return Drivername;
	}
	public void setDrivername(String drivername) {
		Drivername = drivername;
	}
	public String getUrl() {
		return Url;
	}
	public void setUrl(String url) {
		Url = url;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getUserPassword() {
		return UserPassword;
	}
	public void setUserPassword(String userPassword) {
		UserPassword = userPassword;
	}
	public databasesource(String drivername, String url, String username, String userPassword) {
//		super();
		Drivername = drivername;
		Url = url;
		Username = username;
		UserPassword = userPassword;
	}
	public databasesource() {
		
	}
	@Override
	public String toString() {
		return "databasesource [Drivername=" + Drivername + ", Url=" + Url + ", Username=" + Username
				+ ", UserPassword=" + UserPassword + "]";
	}
	
}
