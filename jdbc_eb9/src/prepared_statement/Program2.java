package prepared_statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Program2 {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the id to be updated");
		int id = scanner.nextInt();
		System.out.println("Enter the name to be updated");
		String name = scanner.next();

		String className = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/persondb";
		String username = "root";
		String password = "root";
		String query = "UPDATE PERSON SET NAME=? WHERE ID=?";

		Class.forName(className);
		Connection connection = DriverManager.getConnection(url, username, password);
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, name);
		preparedStatement.setInt(2, id);
		preparedStatement.execute();
		connection.close();
	}
}
