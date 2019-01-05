package until;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;

import org.apache.commons.dbcp.BasicDataSource;

import Bean.UserBean;
import sc.ustc.controller.SimpleController;

public class Conversation {
	private static String path="or_mapping.xml";
	private static BasicDataSource ds=new BasicDataSource();
	private static Connection conn=null;
	private static String table;
	
	private  static Connection initConversation()throws Exception {
		if(conn==null) {
			URL path = Conversation.class.getClassLoader().getResource("or_mapping.xml");
			Configuration configuration=new Configuration(path);
			table=configuration.getBean().getTable();
		ds.setDriverClassName(configuration.getDatasource().getDrivername());
		ds.setUrl(configuration.getDatasource().getUrl());
		ds.setUsername(configuration.getDatasource().getUsername());
		ds.setPassword(configuration.getDatasource().getUserPassword());
		conn=ds.getConnection();
		System.out.println("数据库已连接");
		return conn;
		}
		else return conn;
	}
	public static Object getObject(UserBean user)throws Exception {
		UserBean user1=null;
		try {
		Connection con= initConversation();
		final String sql1="select * from tbl_user where userId=?";
		System.out.println(table);
		System.out.println("select * from tbl_user where userId="+user.getUserId());
		java.sql.PreparedStatement ps=con.prepareStatement(sql1);
		ps.setString(1, user.getUserId());
		ResultSet rs=ps.executeQuery();
		System.out.println("执行过后");
		while(rs.next()) {

			user=rs2Bean(rs);
			System.out.println(user);
		}
		rs.close();
		ps.close();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return user;
	}
	private  static UserBean rs2Bean(ResultSet rs) throws Exception{
		UserBean user=new UserBean();
		user.setUserId(rs.getString("userId"));
		user.setUserName(rs.getString("userName"));
		user.setUserPass(rs.getString("userPass"));
		return user;
	}
}
