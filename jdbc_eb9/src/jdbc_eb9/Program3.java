package jdbc_eb9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Program3 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String className="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/persondb";
		String username="root";
		String password="root";
		String query="DELETE FROM PERSON WHERE NAME='RACHANA'";
		
		Class.forName(className);
		Connection connection=DriverManager.getConnection(url,username,password);
		Statement statement=connection.createStatement();
		statement.execute(query);
		connection.close();
	}
}
