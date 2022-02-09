package school;

import java.sql.Connection;
import java.sql.DriverManager;



public class DBUser3 {
	 public static DBUser3 getInstance() {
		 return new DBUser3();
	 }
	 public Connection getConnection() {
		
	     Connection con = null;
	     try {
	        con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "user3", "1235");
	        
	     } catch (Exception e) {
	        e.printStackTrace();
	     }
	     return con;
	 }
}
