package jdbc_student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class StudentInsert {

	public static void main(String[] args) throws Exception {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the id to be inserted");
		int id=scanner.nextInt();
		System.out.println("Enter the name to be inserted");
		String name=scanner.next();
		System.out.println("Enter the marks to be inserted");
		int marks=scanner.nextInt();
		System.out.println("Enter the address to be inserted");
		String address=scanner.next();
		System.out.println("Enter the father's name to be inserted");
		String fathername=scanner.next();
		
		String className="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/studentdb";
		String username="root";
		String password="root";
		String query="INSERT INTO STUDENT VALUES (?,?,?,?,?)";
		
		Class.forName(className);
		Connection connection=DriverManager.getConnection(url,username,password);
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		preparedStatement.setInt(1,id);
		preparedStatement.setString(2,name);
		preparedStatement.setInt(3,marks);
		preparedStatement.setString(4,address);
		preparedStatement.setString(5,fathername);
		preparedStatement.execute();
		connection.close();
		
	}

}
