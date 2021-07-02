package datastorage;

import model.UserRole;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserRolesDAO extends RoleDAOimp<UserRole> {
    public UserRolesDAO(Connection conn) {
        super(conn);
    }

    @Override
    protected String getReadByIDStatementString(String role, String obj) throws SQLException {
        return "SELECT * FROM user_roles WHERE role_name = '"+role+"' AND object_name = '"+obj+"'";
    }

    @Override
    protected UserRole getInstanceFromResultSet(ResultSet res) throws SQLException {
        UserRole role = null;
        role = new UserRole(res.getString(1), res.getString(2),
                res.getInt(3), res.getInt(4), res.getInt(5),
                res.getInt(6), res.getInt(7));
        return role;
    }


}
