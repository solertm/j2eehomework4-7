package sc.ustc.dao;

import java.sql.Connection;
import java.sql.ResultSet;

import Bean.UserBean;
import until.Conversation;

public class UserDAO extends BaseDAO{

	@Override
	public Object query(String sql) {
		// TODO Auto-generated method stub
//		UserBean user=null;
//		try {
//		Connection con=openDBConnection();
//		final String sql1="select * from tbl_user where userId=?";
//		System.out.println("select * from tbl_user where userId="+sql);
//		java.sql.PreparedStatement ps=con.prepareStatement(sql1);
//		ps.setString(1, sql);
//		ResultSet rs=ps.executeQuery();
//		System.out.println("执行过后");
//		while(rs.next()) {
//
//			user=this.rs2Bean(rs);
//			System.out.println(user);
//		}
//		rs.close();
//		ps.close();
//		}catch(Exception e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				closeDBConnection();
//			}catch(Exception e) {
//				e.printStackTrace();
//			}
//		}
//		return user;
		UserBean user=null;
		
		try {
			UserBean user1;
			System.out.println("hahahha");
			user1=(UserBean)Conversation.getObject(new UserBean(sql));
//			System.out.println(user1);
			return user1;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public boolean insert(Object sql) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Object sql) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Object sql) {
		// TODO Auto-generated method stub
		return false;
	}

//	public UserDAO() {
//		setDrivername("org.gjt.mm.mysql.Driver");
//		setUrl("jdbc:mysql://localhost:3306/usesc?useUnicode=true&characterEncoding=gb2312");
//		setUsername("root");
//		setUserPassword("");
//	}
//	public UserDAO(String drivername,String url,String username,String userPassword) {
//		setDrivername(drivername);
//		setUrl(url);
//		setUsername(username);
//		setUserPassword(userPassword);
//	}
	private UserBean rs2Bean(ResultSet rs) throws Exception{
		UserBean user=new UserBean();
		user.setUserId(rs.getString("userId"));
		user.setUserName(rs.getString("userName"));
		user.setUserPass(rs.getString("userPass"));
		return user;
	}
}
