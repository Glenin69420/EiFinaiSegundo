package Logico;

import java.io.Serializable;
import java.util.ArrayList;

public class Control implements Serializable{

	private static final long serialVersionUID = 1L;
	private ArrayList<Trabajadora> misUsers;
	private static Control control;
	private static Trabajadora loginUser;

	
	private Control() {
		misUsers = new ArrayList<>();
	}
	
	public static Control getInstance(){
		if(control == null){
			control = new Control();
		}
		return control;
	}

	public ArrayList<Trabajadora> getMisUsers() {
		return misUsers;
	}

	public void setMisUsers(ArrayList<Trabajadora> misUsers) {
		this.misUsers = misUsers;
	}

	public static Control getControl() {
		return control;
	}

	public static void setControl(Control control) {
		Control.control = control;
	}

	public static Trabajadora getLoginUser() {
		return loginUser;
	}

	public static void setLoginUser(Trabajadora loginUser) {
		Control.loginUser = loginUser;
	}

	public void regUser(Trabajadora user) {
		misUsers.add(user);
		
	}

	/*public static boolean isFirstTime() {
		return firstTime;
	}

	public static void setFirstTime(boolean firstTime) {
		Control.firstTime = firstTime;
	}*/
	

	/*public boolean confirmLogin(String text, String text2) {
		boolean login = false;
		for (Trabajadora user : misUsers) {
			if(user.getUserName().equals(text) && user.getPass().equals(text2)){
				loginUser = user;
				login = true;
			}
		}
		return login;
	}*/
	
}
