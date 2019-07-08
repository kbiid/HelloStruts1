package kr.co.torpedo.hellostruts1.util;

import org.mindrot.jbcrypt.BCrypt;

public class BcryptHash {
	private String hashedMessage;
	
	public String getHashedMessage() {
		return hashedMessage;
	}

	public void hash(String message) {
		hashedMessage = BCrypt.hashpw(message, BCrypt.gensalt());
	}

	public boolean isEqual(String message) {
		if (BCrypt.checkpw(message, hashedMessage)) {
			return true;
		} else {
			return false;
		}
	}
}
