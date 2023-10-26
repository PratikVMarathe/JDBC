package jdbc_student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class StudentDelete {
	public static void main(String[] args) throws Exception {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the id to be deleted");
		int id=scanner.nextInt();
		
		String className="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/studentdb";
		String username="root";
		String password="root";
		String query="DELETE FROM STUDENT WHERE ID=?";
		
		Class.forName(className);
		Connection connection=DriverManager.getConnection(url,username,password);
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		preparedStatement.setInt(1,id);
		preparedStatement.execute();
		connection.close();
		
	}
}
