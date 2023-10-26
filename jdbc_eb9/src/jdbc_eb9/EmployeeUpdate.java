package jdbc_eb9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class EmployeeUpdate {
	public static void main(String[] args) throws Exception {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the id to be updated");
		int id=scanner.nextInt();
		System.out.println("Enter the phone to be inserted");
		long phone=scanner.nextLong();
		
		String className="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/employeedb";
		String username="root";
		String password="root";
		String query="UPDATE EMPLOYEE SET PHONE=? WHERE ID=?";
		
		Class.forName(className);
		Connection connection=DriverManager.getConnection(url,username,password);
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		preparedStatement.setLong(1,phone);
		preparedStatement.setInt(2,id);
		preparedStatement.execute();
		connection.close();
		
	}
}
