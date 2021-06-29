
package datastorage;

import model.User;

import java.sql.Connection;

public class UserDAO extends DAOimp<User> {
    public UserDAO (Connection conn){
        super(conn);
    }
    @Override
    protected String getCreateStatementString(User user)
    {
        return String.format("INSERT INTO User (FIRSTNAME, SURNAME, USERNAME, PASSWORD, ROLE) VALUES ('%s', '%s', '%s', '%s', '%s')",
         user.getFirstName(),user.getSurname(),user.getUsername(),user.getPassword(),user.getRolename());

    }
}