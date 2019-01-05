package water.ustc.action;

import java.util.Random;

import javaBean.UserBean;

public class LoginAction {
	 private UserBean user=new UserBean();
	 
		public Object getuser() {
			return user;
		}

		public void setuser(Object user) {
			this.user = (UserBean)user;
		}

		public String handleLogin() {
			if(user.signIn()) {
				return "success";
			}
			else return "failure";
			
		}

		@Override
		public String toString() {
			return "LoginAction [user=" + user + "]";
		}
		
}
