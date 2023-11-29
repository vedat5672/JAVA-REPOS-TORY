package Project.dataccess.concrete.context;

import java.sql.Connection;
import java.sql.SQLException;

public interface IConnect {
	Connection getConnection() throws SQLException;
	void showErrorMessage(SQLException ex);
}
