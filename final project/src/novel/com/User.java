package novel.com;
public class User {
    private String name;
    private String email;
    private String password;

    public User(String name, String password, String email){
        this.email=email;
        this.name=name;
        this.password=password;

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }



    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}
