package Login;

import java.util.ArrayList;
import java.util.List;

public class ManagerDTO {
	String id;
	String password;
	String name;
	String birth;
	String email;
	int age;
	String status;// 역할?
	String sex;

	ManagerDTO(String id, String password, String name, String birth, String email, String sex) {
		this.id = id;
		this.email = email;
		this.birth = birth;
		this.password = password;
		this.name = name;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

}
