package school;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnect {
 public static DbConnect getInstance() {
	 return new DbConnect();
 }
 public Connection getConnection() {
     Connection con = null;
      
 try {
        con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "user1", "12");
        
     } catch (Exception e) {
        e.printStackTrace();
     }
     return con;
 }
}
