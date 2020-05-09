package Login;

import java.util.ArrayList;
import java.util.List;

public class ManagerDTO {
	String id;
	String password;
	String nickName;
	String birth;
	String email;
	int age;
	private Sex sex;

	ManagerDTO(String id, String password, String nickName, String birth, String email, Sex sex) {
		this.id = id;
		this.email = email;
		this.birth = birth;
		this.password = password;
		this.nickName = nickName;
		this.sex = sex;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

}
