package Login;

enum Sex{
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
    
    MemberDTO(String name, String password, String nickName, String birth, String email){
        this.name = name;
        this.age = age;
        this.email = email;
    }
 
    public void setSex(Sex sex) {
        this.sex = sex;
    }
    public Sex getSex() {
        return sex;
    }
    
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getEmail() {
        return email;
    }
}
