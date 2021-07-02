package model;


public class User extends Person {
    private int ID;
    private String username;
    private String password;
    private String rolename;

    public User( Integer ID, String firstname, String surname, String username, String password, String rolename) {
        super(firstname, surname);
        this.ID = ID;
        this.password = password;
        this.rolename = rolename;
        this.username = username;
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    public String getRolename() {
        return rolename;
    }

    public void SetUsername(String username){this.username = username;}

    public void SetPassword(String password){this.password = password;}

    public void SetRole(String role){this.username = role;}

    public void setID(int ID) {
        this.ID = ID;
    }

    public Integer getID(){return ID;}
}
