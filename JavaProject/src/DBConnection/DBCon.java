package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBCon {
	private static final String URL = "jdbc:mysql://localhost:3306/some_db";
	private static final String USER = "root";
	private static final String PASSWORD = "Transmutation1";
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}

}
