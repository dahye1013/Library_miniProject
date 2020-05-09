package Login;

import java.util.ArrayList;
import java.util.List;

public class ManagerDTO {
    String name;
    String password;
    String nickName;
    String birth;
    String email;
    int age;
    private Sex sex;  
    private static List<ManagerDTO> list = new ArrayList<ManagerDTO>();
    
    ManagerDTO(){
        
    }
    public ManagerDTO(List<ManagerDTO> list){
         this.list = list;
    }
    


    public ManagerDTO(String name, String password, String nickName, String birth, String email) {
        list = null;
        this.name = name;
        this.age = age;
        this.email = email;
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
    
    public static List<ManagerDTO> getList() {
        return list;
    }

    public void setList(List<ManagerDTO> list) {
        this.list = list;
    }
    
    
    
   
    
}
