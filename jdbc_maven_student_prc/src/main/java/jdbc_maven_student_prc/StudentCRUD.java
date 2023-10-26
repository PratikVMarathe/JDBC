package jdbc_maven_student_prc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentCRUD {

	public Connection getConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root", "root");
		return connection;
	}

	public void saveStudent(Student student) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO STUDENT VALUES(?,?,?,?,?)");
		preparedStatement.setInt(1, student.getId());
		preparedStatement.setString(2, student.getName());
		preparedStatement.setInt(3, student.getId());
		preparedStatement.setString(4, student.getAddress());
		preparedStatement.setString(5, student.getFathersname());
		preparedStatement.execute();
		connection.close();
	}

	public void updateStudent(Student student) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("UPDATE STUDENT SET NAME=? WHERE ID=?");
		preparedStatement.setInt(2, student.getId());
		preparedStatement.setString(1, student.getName());
		preparedStatement.execute();
		connection.close();
	}

	public void deleteStudent(int id) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM STUDENT WHERE ID=?");
		preparedStatement.setInt(1, id);
		preparedStatement.execute();
		connection.close();
	}

	public void getAllStudent() throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM STUDENT");
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			System.out.println(resultSet.getInt(1));
			System.out.println(resultSet.getString(2));
			System.out.println(resultSet.getInt(3));
			System.out.println(resultSet.getString(4));
			System.out.println(resultSet.getString(5));
			System.out.println("=========================");
		}
		connection.close();
	}

}
