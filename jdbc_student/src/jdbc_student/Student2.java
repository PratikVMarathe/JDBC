package jdbc_student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Student2 {
	public static void main(String[] args) throws Exception {
		String className="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/studentdb";
		String username="root";
		String password="root";
		String query="DELETE FROM STUDENT WHERE NAME='RAJATH'";
		
		Class.forName(className);
		Connection connection=DriverManager.getConnection(url,username,password);
		Statement statement=connection.createStatement();
		statement.execute(query);
		connection.close();
	}
}
