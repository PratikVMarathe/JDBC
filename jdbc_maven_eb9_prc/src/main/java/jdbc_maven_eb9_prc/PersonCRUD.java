package jdbc_maven_eb9_prc;

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

	public void savePerson(Person person) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO PERSON VALUES(?,?,?)");
		preparedStatement.setInt(1, person.getId());
		preparedStatement.setString(2, person.getName());
		preparedStatement.setLong(3, person.getPhone());
		preparedStatement.execute();
		connection.close();
	}
	
	public void updatePerson(Person person) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("UPDATE PERSON SET NAME=? WHERE ID=?");
		preparedStatement.setInt(2, person.getId());
		preparedStatement.setString(1, person.getName());
		preparedStatement.execute();
		connection.close();
	}
	
	public void deletePerson(int id) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM PERSON WHERE ID=?");
		preparedStatement.setInt(1, id);
		preparedStatement.execute();
		connection.close();
	}
	
	public void getAllPerson() throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM PERSON");
		ResultSet resultSet=preparedStatement.executeQuery();
		while(resultSet.next()) {
			System.out.println(resultSet.getInt(1));
			System.out.println(resultSet.getString(2));
			System.out.println(resultSet.getLong(3));
			System.out.println("==============================");
		}
		connection.close();
	}

}
