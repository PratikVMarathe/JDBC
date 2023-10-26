package jdbc_eb9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Employee1 {
	public static void main(String[] args) throws Exception {
		String className="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/employeedb";
		String username="root";
		String password="root";
		String query="UPDATE EMPLOYEE SET NAME='PRAJNA' WHERE ID=2";
		
		Class.forName(className);
		Connection connection=DriverManager.getConnection(url,username,password);
		Statement statement=connection.createStatement();
		statement.execute(query);
		connection.close();
	}
}
