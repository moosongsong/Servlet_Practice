package kr.co.moosong.model;

public class Member {
	private String email;
	private String nick;
	private String password;
	private String regdate;
	private String removeAt;
	
	public Member() {
		;
	}

	public Member(String email, String nick, String password, String regdate, String removeAt) {
		this.email = email;
		this.nick = nick;
		this.password = password;
		this.regdate = regdate;
		this.removeAt = removeAt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getRemoveAt() {
		return removeAt;
	}

	public void setRemoveAt(String removeAt) {
		this.removeAt = removeAt;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((nick == null) ? 0 : nick.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((regdate == null) ? 0 : regdate.hashCode());
		result = prime * result + ((removeAt == null) ? 0 : removeAt.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (nick == null) {
			if (other.nick != null)
				return false;
		} else if (!nick.equals(other.nick))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (regdate == null) {
			if (other.regdate != null)
				return false;
		} else if (!regdate.equals(other.regdate))
			return false;
		if (removeAt == null) {
			if (other.removeAt != null)
				return false;
		} else if (!removeAt.equals(other.removeAt))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Member [email=" + email + ", nick=" + nick + ", password=" + password + ", regdate=" + regdate
				+ ", removeAt=" + removeAt + "]";
	}
	
	
}
