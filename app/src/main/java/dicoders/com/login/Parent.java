package dicoders.com.login;

public class Parent {
    private String name;
    private String email;
    private String phoneNumber;
    private String passwsord;

    public Parent(String name, String email, String phoneNumber, String passwsord){
        this.setName(name);
        this.setEmail(email);
        this.setPhoneNumber(phoneNumber);
        this.setPasswsord(passwsord);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPasswsord() {
        return passwsord;
    }

    public void setPasswsord(String passwsord) {
        this.passwsord = passwsord;
    }
}
