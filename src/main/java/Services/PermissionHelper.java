package Services;

import datastorage.DAOFactory;
import datastorage.UserRolesDAO;
import model.UserRole;

import java.sql.Connection;
import java.sql.SQLException;

public class PermissionHelper {
    private UserRolesDAO dao = DAOFactory.getDAOFactory().createUserRoleDAO();

    public int checkAccessLevel (String role, String wantToAccess, String mode) throws SQLException {

        UserRole tmp = this.dao.readRole(role, wantToAccess);
        System.out.println(tmp);
        switch(mode){
            case "add": {
                return tmp.getAdd();
            }
            case "read": {
                return tmp.getRead();
            }
            case "delete": {
                return tmp.getDelete();
            }
            case "lock": {
                return tmp.getLock();
            }
            case "edit": {
                return tmp.getEdit();
            }
            default: {
                return 0;
            }
        }
    }
}
