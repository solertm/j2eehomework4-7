package water.ustc.action;


import Bean.UserBean;

public class LoginAction {
	 private UserBean user=new UserBean();
	 
	protected UserBean getUser() {
		return user;
	}

	protected void setUser(UserBean user) {
		this.user = user;
	}

	public String handleLogin() {
		user=new UserBean("343", null, "123");
		return user.signIn()?"success":"failure";
		
	}
}
