package model;


public class User extends Person {
    private int ID;
    private String Username;
    private String Password;
    private String Rolename;

    public User( Integer ID,String Firstname, String Surname, String Username, String Password, String Rolename) {
        super(Firstname, Surname);
        this.ID = ID;
        this.Password = Password;
        this.Rolename = Rolename;
        this.Username = Username;
    }
    public String getUsername(){
        return Username;
    }
    public String getPassword(){
        return Password;
    }
    public String getRolename() {
        return Rolename;
    }
    public void SetUsername(String Username){this.Username = Username;}
    public void SetPassword(String Password){this.Password = Password;}
    public void SetRole(String Role){this.Username = Role;}

    public void setID(int ID) {
        this.ID = ID;
    }

    public Integer getID(){return ID;}
}
