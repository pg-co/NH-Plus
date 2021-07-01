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
    public Integer getID(){return ID;}
}
