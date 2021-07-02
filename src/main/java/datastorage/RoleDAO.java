package datastorage;

import java.sql.SQLException;

public interface RoleDAO<T> {

    T readRole(String role, String obj) throws SQLException;
}
