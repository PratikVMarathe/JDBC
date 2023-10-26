package prepared_statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentCRUD {
	
	public Connection getConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","root","root");
		return connection;
	}
	
	public void saveStudent(int id,String name,int marks,String address,String fathername) throws Exception {
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO STUDENT VALUES (?,?,?,?,?)");
		preparedStatement.setInt(1,id);
		preparedStatement.setString(2,name);
		preparedStatement.setInt(3,marks);
		preparedStatement.setString(4,address);
		preparedStatement.setString(5,fathername);
		preparedStatement.execute();
		preparedStatement.close();
		connection.close();
	}
	
	public void updateStudent(int id,String name) throws Exception {
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("UPDATE STUDENT SET NAME=? WHERE ID=?");
		preparedStatement.setInt(2,id);
		preparedStatement.setString(1,name);
		preparedStatement.execute();
		preparedStatement.close();
		connection.close();
	}
	
	public void deleteStudent(int id) throws Exception {
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("DELETE FROM STUDENT WHERE ID=?");
		preparedStatement.setInt(1,id);
		preparedStatement.execute();
		preparedStatement.close();
		connection.close();
	}
	
	public void getAllStudent() throws Exception {
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM STUDENT");
		ResultSet resultSet=preparedStatement.executeQuery();
		while(resultSet.next()) {
			System.out.println(resultSet.getInt(1));
			System.out.println(resultSet.getString(2));
			System.out.println(resultSet.getInt(3));
			System.out.println(resultSet.getString(4));
			System.out.println(resultSet.getString(5));
		}
		preparedStatement.close();
		connection.close();
	}
	
}
