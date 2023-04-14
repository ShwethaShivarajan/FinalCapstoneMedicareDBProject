package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtils {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medicare", "root", "Admin@123");

		Statement stm = con.createStatement();

		stm.executeUpdate("insert into Category (name, description) values ('Antihistamines', 'This is used for treating allergic symptoms..')");

		ResultSet result = stm.executeQuery("select * from Category");
		
		while(result.next()) {
			
			System.out.println(result.getString("name"));
			System.out.println(result.getString("Description"));
			
	
		}
		
		stm.executeUpdate("delete from Category where name='Antihistamines'");
		result = stm.executeQuery("select * from Category");
	
		
		while(result.next()) {
			
			System.out.println(result.getString("name"));
			System.out.println(result.getString("Description"));
			
	
		}

	}

}
