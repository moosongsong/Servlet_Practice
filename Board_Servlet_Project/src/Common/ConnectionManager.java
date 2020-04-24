package Common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionManager {
	final static String url = "jdbc:mariadb://localhost:3306/servlet";
	final static String user = "servlet";
	final static String password = "1234";
//	private static final String URL = "";
	private static Connection connection;

	public static Connection getConnection() throws SQLException {
		if(connection == null) {
			connection = DriverManager.getConnection(url, user, password);
		}
		return connection;
	}

	public static void close(ResultSet rs) {
		try {
			rs.close();
		} catch (Exception e) {
			;
		}
	}
	
	public static void close(Statement stmt) {
		try {
			stmt.close();
		} catch (Exception e) {
			;
		}
	}
	
	public static void close(Statement stmt, ResultSet rs) {
		close(rs);
		close(stmt);
	}
	
}
