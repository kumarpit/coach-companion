package squanalyze2;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnection {
	public static Connection dbConnector (){
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/squash_academy","root","");
		}catch(Exception e) {
			System.out.println(e);
		}
		return conn;
	}
}





