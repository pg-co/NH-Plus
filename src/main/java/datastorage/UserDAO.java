
package datastorage;

import model.Patient;
import model.User;
import utils.DateConverter;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

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
    @Override
    protected String getReadByIDStatementString(long key) {
        return String.format("SELECT * FROM User WHERE ID = %d", key);
    }
    @Override
    protected User getInstanceFromResultSet(ResultSet result) throws SQLException {
        User u = null;
        LocalDate date = DateConverter.convertStringToLocalDate(result.getString(4));
        u = new User(result.getInt(1), result.getString(2),
                result.getString(3), result.getString(4),
                result.getString(5),result.getString(6));
        return u;
    }
    @Override
    protected String getReadAllStatementString() {
        return "SELECT * FROM USER";
    }
    @Override
    protected ArrayList<User> getListFromResultSet(ResultSet result) throws SQLException {
        ArrayList<User> list = new ArrayList<User>();
        User u = null;
        while (result.next()) {
            LocalDate date = DateConverter.convertStringToLocalDate(result.getString(4));
            u = new User(result.getInt(1), result.getString(2),
                    result.getString(3), result.getString(4),
                    result.getString(5),result.getString(6));
            list.add(u);
        }
        return list;
    }
    @Override
    protected String getUpdateStatementString(User user) {
        return String.format("UPDATE USER SET FIRSTNAME = '%s', SURNAME = '%s', USERNAME = '%s', PASSWORD = '%s', " +
                        "ROLE = '%s' WHERE ID = %d", user.getFirstName(), user.getSurname(), user.getUsername(),
                user.getPassword(), user.getRolename(), user.getID());
    }
    @Override
    protected String getDeleteStatementString(long key) {
        return String.format("Delete FROM USER WHERE ID=%d", key);
    }
}