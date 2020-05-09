package Login;

import java.util.ArrayList;
import java.util.List;

enum Sex {
    MALE, FEMALE
}

public class MemberDTO {

    String name;
    String password;
    String nickName;
    String birth;
    String email;
    int age;
    private Sex sex;
    int status = 0;
    // 정상 0 , 연체자 1
    
    private static List<MemberDTO> list = new ArrayList<MemberDTO>();
    MemberDTO(){
        
    }

    public MemberDTO(List<MemberDTO> list) {
        this.list = list;
    }

    MemberDTO(String name, String password, String nickName, String birth, String email) {
        this.name = name;
        this.email = email;
        this.birth = birth;
        this.password = password;
        this.nickName = nickName;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    public static List<MemberDTO> getList() {
        return list;
    }

    public void setList(List<MemberDTO> list) {
        this.list = list;
    }


}
