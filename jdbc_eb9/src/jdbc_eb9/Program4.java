package jdbc_eb9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Program4 {
	public static void main(String[] args) throws Exception {
		String className="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/persondb";
		String username="root";
		String password="root";
		String query="SELECT * FROM PERSON";
		
		Class.forName(className);
		Connection connection=DriverManager.getConnection(url,username,password);
		Statement statement=connection.createStatement();
		ResultSet resultset=statement.executeQuery(query);
		while(resultset.next()) {
			System.out.println(resultset.getInt(1));
			System.out.println(resultset.getString(2));
			System.out.println(resultset.getLong(3));
		}
		connection.close();
	}
}
