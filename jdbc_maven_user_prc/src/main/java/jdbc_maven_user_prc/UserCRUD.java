package jdbc_maven_user_prc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.cj.jdbc.Driver;

public class UserCRUD {

	public Connection getConnection() throws Exception {
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb", "root", "root");
//		return connection;

		Driver driver = new Driver();
		DriverManager.registerDriver(driver);

		FileInputStream fileInputStream = new FileInputStream("dbconfig.properties");
		Properties properties = new Properties();
		properties.load(fileInputStream);

		Connection connection = DriverManager.getConnection(properties.getProperty("url"),
				properties.getProperty("username"), properties.getProperty("password"));
		return connection;
	}

	public void saveUser(User user) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO USER VALUES (?,?,?,?,?)");
		preparedStatement.setInt(1, user.getUserid());
		preparedStatement.setString(2, user.getUsername());
		preparedStatement.setString(3, user.getPassword());
		preparedStatement.setLong(4, user.getPhone());
		preparedStatement.setString(5, user.getEmail());
		preparedStatement.execute();
		connection.close();
	}

	public void updateUser(User user) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("UPDATE USER SET NAME=? WHERE USERID=?");
		preparedStatement.setString(1, user.getUsername());
		preparedStatement.setInt(2, user.getUserid());
		preparedStatement.execute();
		connection.close();
	}

	public void deleteUser(int userid) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM USER WHERE USERID=?");
		preparedStatement.setInt(1, userid);
		preparedStatement.execute();
		connection.close();
	}

	public void getAllUser() throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM USER");
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			System.out.println(resultSet.getInt(1));
			System.out.println(resultSet.getString(2));
			System.out.println(resultSet.getString(3));
			System.out.println(resultSet.getLong(4));
			System.out.println(resultSet.getString(5));
			System.out.println("============================");
		}
		connection.close();
	}

	public void signinUser(User user) throws Exception {
		String query = "INSERT INTO USER VALUES (?,?,?,?,?)";

		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, user.getUserid());
		preparedStatement.setString(2, user.getUsername());
		preparedStatement.setString(3, user.getPassword());
		preparedStatement.setLong(4, user.getPhone());
		preparedStatement.setString(5, user.getEmail());
		int saved = preparedStatement.executeUpdate();
		if (saved == 1) {
			System.out.println("Saved");
		} else {
			System.out.println("Not Saved");
		}
		connection.close();
	}

	public boolean loginUser(User user) throws Exception {
		String query = "SELECT * FROM USER WHERE USERNAME=?";

		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, user.getUsername());
		String password = null;
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			password = resultSet.getString("password");
		}
		connection.close();
		if (password.equals(user.getPassword())) {
			return true;
		}
		return false;
	}

}
