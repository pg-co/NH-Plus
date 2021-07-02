package datastorage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class RoleDAOimp<T> implements RoleDAO<T> {
    protected Connection conn;

    public RoleDAOimp(Connection conn){this.conn = conn;}

    @Override
    public T readRole(String role, String obj) throws SQLException {
        T object = null;
        Statement st = conn.createStatement();
        String test = getReadByIDStatementString(role, obj);
        System.out.println(test);
        ResultSet result = st.executeQuery(test);
        if (result.next()) {
            object = getInstanceFromResultSet(result);
        }
        return object;
    }


    protected  abstract String getReadByIDStatementString(String role, String obj) throws SQLException;
    protected abstract T getInstanceFromResultSet(ResultSet set) throws SQLException;
}
