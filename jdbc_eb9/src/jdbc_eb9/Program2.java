package jdbc_eb9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Program2 {
	public static void main(String[] args) throws Exception {
		String className="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/persondb";
		String username="root";
		String password="root";
		String query="UPDATE PERSON SET NAME='RAJ' WHERE ID=1";
		
		Class.forName(className);
		Connection connection=DriverManager.getConnection(url,username,password);
		Statement statement=connection.createStatement();
		statement.execute(query);
		connection.close();
	}
}
