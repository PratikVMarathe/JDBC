package prepared_statement2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PersonCRUD {
	public Connection getConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/persondb", "root", "root");
		return connection;
	}

	public void savePerson(int id, String name, long phone) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO PERSON VALUES (?,?,?)");
		preparedStatement.setInt(1, id);
		preparedStatement.setString(2, name);
		preparedStatement.setLong(3, phone);
		preparedStatement.execute();
		preparedStatement.close();
		connection.close();
	}

	public void updatePerson(int id, String name) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("UPDATE PERSON SET NAME=? WHERE ID=?");
		preparedStatement.setInt(2, id);
		preparedStatement.setString(1, name);
		preparedStatement.execute();
		preparedStatement.close();
		connection.close();
	}

	public void deletePerson(int id) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM PERSON WHERE ID=?");
		preparedStatement.setInt(1, id);
		preparedStatement.execute();
		preparedStatement.close();
		connection.close();
	}
	
	public void getAllPerson() throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM PERSON");
		ResultSet resultSet=preparedStatement.executeQuery();
		while(resultSet.next()) {
			System.out.println(resultSet.getInt("id"));
			System.out.println(resultSet.getString(2));
			System.out.println(resultSet.getLong("phone"));
		}
		preparedStatement.close();
		connection.close();
	}
	
}
