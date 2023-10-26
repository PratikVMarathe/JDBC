package jdbc_eb9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class EmployeeInsert {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the id to be inserted");
		int id = scanner.nextInt();
		System.out.println("Enter the name to be inserted");
		String name = scanner.next();
		System.out.println("Enter the phone to be inserted");
		long phone = scanner.nextLong();
		System.out.println("Enter the company to be inserted");
		String company = scanner.next();
		System.out.println("Enter the address to be inserted");
		String address = scanner.next();

		String className = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/employeedb";
		String username = "root";
		String password = "root";
		String query = "INSERT INTO EMPLOYEE VALUES (?,?,?,?,?)";

		Class.forName(className);
		Connection connection = DriverManager.getConnection(url, username, password);
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, id);
		preparedStatement.setString(2, name);
		preparedStatement.setLong(3, phone);
		preparedStatement.setString(4, company);
		preparedStatement.setString(5, address);
		preparedStatement.execute();
		connection.close();

	}
}
