package kr.co.torpedo.hellostruts1.domain;

import java.security.NoSuchAlgorithmException;

import org.apache.struts.action.ActionForm;
import org.mindrot.jbcrypt.BCrypt;

public class Admin extends ActionForm{
	private static final long serialVersionUID = 6698000733793955767L;
	private String id;
	private String passwd;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String pwd) {
		this.passwd = pwd;
	}

	public boolean checkAdminInfo(String id, String passwd) throws NoSuchAlgorithmException {
		if (!this.id.equals(id) || !BCrypt.checkpw(this.passwd, passwd)) {
			return false;
		}
		return true;
	}
}