package sc.ustc.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

public abstract class BaseDAO {
	protected String drivername;
	protected String url;
	protected String username;
	protected String userPassword;
	private BasicDataSource ds=new BasicDataSource();
	private Connection conn=null;
	
	protected String getDrivername() {
		return drivername;
	}
	protected void setDrivername(String drivername) {
		this.drivername = drivername;
	}
	protected String getUrl() {
		return url;
	}
	protected void setUrl(String url) {
		this.url = url;
	}
	protected String getUsername() {
		return username;
	}
	protected void setUsername(String username) {
		this.username = username;
	}
	protected String getUserPassword() {
		return userPassword;
	}
	protected void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	public Connection openDBConnection() throws SQLException {
		 if(conn==null) {
		 ds.setDriverClassName(drivername);
		 ds.setUrl(url);
		 ds.setUsername(username);
		 ds.setPassword(userPassword);
//		 Connection conn=null;
		 conn=ds.getConnection();
		 System.out.println("数据库已连接");
		 return conn;
		 }else return conn;
	}
	public boolean closeDBConnection() throws SQLException {
		if(conn.isClosed()) {
			System.out.println("数据库已关闭");
			return true;
		}
		else conn.close();
		System.out.println("数据库已关闭");
		return true;	
	}
	
	public abstract Object query(String sql) ;
	public abstract boolean insert(String sql);
	public abstract boolean update(String sql);
	public abstract boolean delete(String sql);	
		
	
}
