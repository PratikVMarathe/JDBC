package jdbc_student;

import java.sql.*;

public class Student1 {
	public static void main(String[] args) throws Exception {
		String className="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/studentdb";
		String username="root";
		String password="root";
		String query="UPDATE STUDENT SET NAME='RACHU' WHERE ID=2";
		
		Class.forName(className);
		Connection connection=DriverManager.getConnection(url,username,password);
		Statement statement=connection.createStatement();
		statement.execute(query);
		connection.close();
	}
}