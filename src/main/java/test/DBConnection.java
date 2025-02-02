package test;

import java.sql.*;
import static test.DBInfo.*;
public class DBConnection {
	
	//creating private connection object
	private static Connection con= null;
	
	//private constructor
	private DBConnection() {}
	
	//static block
	static {
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			con = DriverManager.getConnection(dbUrl, uName, pWord);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//method for accessing Connection
	public static Connection getCon() {
		
		return con;
	}
}
