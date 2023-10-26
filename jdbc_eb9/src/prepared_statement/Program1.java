package prepared_statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Program1 {

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the id");
		int id = scanner.nextInt();
		System.out.println("Enter the name");
		String name = scanner.next();
		System.out.println("Enter the phone");
		long phone = scanner.nextLong();

		String className = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/persondb";
		String username = "root";
		String password = "root";
		String query = "INSERT INTO PERSON VALUES (?,?,?)";

		Class.forName(className);
		Connection connection = DriverManager.getConnection(url, username, password);
		PreparedStatement preparedstatement = connection.prepareStatement(query);
		preparedstatement.setInt(1, id);
		preparedstatement.setString(2, name);
		preparedstatement.setLong(3, phone);
		preparedstatement.execute();
		connection.close();
	}

}
