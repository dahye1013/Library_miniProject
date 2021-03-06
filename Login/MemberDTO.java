package Login;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;



public class MemberDTO {

    String id;
    String password;
    String name;
    String birth;
    String email;
    int age; 
    int sex; //남자 0 여자 1
    int status ; //멤버0 메니저1
    int state; // 정상 0 연체자 1
    int seq; //0514추가 
    String[] borrow = new String[3]; //빌린책 리스트
    public MemberDTO(){//0514수정
    	
    }
    public String[] getBorrow() {
        return borrow;
    }
    public void setBorrow(String[] borrow) {
        this.borrow = borrow;
    }
    
    MemberDTO(String id, String password, String name, String birth,
    		String email, int sex, int status) {
        this.id = id;
        this.email = email;
        this.birth = birth;
        this.password = password;
        this.name = name;
        this.sex = sex;
        this.status = status;
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
	public int getAge() { //0514 수정
    	int birth = Integer.parseInt(this.birth.substring(0, 4));
    	int year = cal.get(Calendar.YEAR);
    	this.age = year-birth;
    	return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}


    //--------0514추가-----------------
    public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	Calendar cal = Calendar.getInstance();
	//-----------------------------

}
