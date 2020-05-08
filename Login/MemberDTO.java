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
    
    public MemberDTO(){
        
    }

    MemberDTO(String name, String password, String nickName, String birth, String email){
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



}
