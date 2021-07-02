package model;

public class UserRole {
    private String role_name;
    private String object_name;
    private int read;
    private int add;
    private int delete;
    private int lock;
    private int edit;

    public UserRole (String role_name, String object_name, int read, int add, int delete, int lock, int edit){
        this.role_name = role_name;
        this.object_name = object_name;
        this.read = read;
        this.add = add;
        this.delete = delete;
        this.lock = lock;
        this.edit = edit;
    }

    public String getRole_name() {
        return role_name;
    }

    public String getObject_name() {
        return object_name;
    }

    public int getAdd() {
        return add;
    }

    public int getDelete() {
        return delete;
    }

    public int getEdit() {
        return edit;
    }

    public int getLock() {
        return lock;
    }

    public int getRead() {
        return read;
    }

}
