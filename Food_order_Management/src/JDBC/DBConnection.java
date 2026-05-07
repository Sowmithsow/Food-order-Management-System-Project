package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		
		String url="jdbc:mysql://localhost:3306/orders";
		
		String user="root";
		
		String password="Sowmithran@24";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		return DriverManager.getConnection(url,user,password);
		
	}

}
