package model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class User {

	private String id;
	private String name;
	private String nickname;
	private Calendar signUpDate;

	public User(String id, String name, String nickname) {
		
		this.id = id;
		this.name = name;
		this.nickname = nickname;
		signUpDate = Calendar.getInstance();

	}

	public String toString(){
		
		String msg = "";
		
		msg += "Id: " + id;
		msg += "\nName: " + name;
		msg += "\nNickname: " + nickname;
		msg += "\nSign up date: " + new SimpleDateFormat("dd-MM-yyyy").format(signUpDate.getTime());
		return msg;
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Calendar getSignUpDate() {
		return signUpDate;
	}

	public void setSignUpDate(Calendar signUpDate) {
		this.signUpDate = signUpDate;
	}

}
