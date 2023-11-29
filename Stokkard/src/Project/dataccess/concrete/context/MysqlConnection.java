package Project.dataccess.concrete.context;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class MysqlConnection implements IConnect {
	static String username="root";
	static String password="vedat5672";
	static String dbUrl="jdbc:mysql://localhost:3306/stokcard?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	public Connection getConnection() throws SQLException {
		System.out.println("saglandı bağlantı");
		return DriverManager.getConnection(dbUrl, username, password);
	}
	public void showErrorMessage(SQLException ex)
	{
		System.out.println("Error Message :"+ex.getMessage());
		System.out.println("Error code :"+ex.getErrorCode());
	}
}
