package jdbc_maven_practice_prc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import com.mysql.cj.jdbc.Driver;

public class UsersCRUD {
	public Connection getConnection() throws Exception {
		// Load the Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/persondb", "root", "root");
		return connection;

		// Register the Driver
//		Driver driver = new Driver();
//		DriverManager.registerDriver(driver);
//
//		FileInputStream fileInputStream = new FileInputStream("dbconfig.properties");
//		Properties properties = new Properties();
//		properties.load(fileInputStream);
//
//		Connection connection = DriverManager.getConnection(properties.getProperty("url"),
//				properties.getProperty("username"), properties.getProperty("password"));
//		return connection;
	}

	public void signupUsers(Users users) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("INSERT INTO USERS(ID,NAME,EMAIL,PASSWORD,ADDRESS) VALUES (?,?,?,?,?)");
		preparedStatement.setInt(1, users.getId());
		preparedStatement.setString(2, users.getName());
		preparedStatement.setString(3, users.getEmail());
		preparedStatement.setString(4, users.getPassword());
		preparedStatement.setString(5, users.getAddress());
		int saved = preparedStatement.executeUpdate();
		if (saved == 1) {
			System.out.println("Saved successfully");
		} else {
			System.out.println("Not saved");
		}
		connection.close();
	}

	public boolean loginUsers(Users users) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM USERS WHERE EMAIL=?");
		preparedStatement.setString(1, users.getEmail());
		String password = null;
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			password = resultSet.getString("password");
		}
		connection.close();
		if (password.equals(users.getPassword())) {
			return true;
		}
		return false;
	}

	public void displayPasswords(String email) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("SELECT FACEBOOK,WHATSAPP,INSTAGRAM,SNAPCHAT,TWITTER FROM USERS WHERE EMAIL=?");
		preparedStatement.setString(1, email);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			System.out.println("The Saved Passwords are: ");
			resultSet.getString("facebook");
			resultSet.getString("whatsapp");
			resultSet.getString("instagram");
			resultSet.getString("snapchat");
			resultSet.getString("twitter");
			System.out.println("===============================");
		}
		connection.close();
	}

	public void savePasswords(Users users) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(
				"UPDATE USERS SET FACEBOOK=?, WHATSAPP=?, INSTAGRAM=?, SNAPCHAT=?,TWITTER=? WHERE EMAIL=?");
		preparedStatement.setString(1, users.getFacebook());
		preparedStatement.setString(2, users.getWhatsapp());
		preparedStatement.setString(3, users.getInstagram());
		preparedStatement.setString(4, users.getSnapchat());
		preparedStatement.setString(5, users.getTwitter());
		preparedStatement.setString(6, users.getEmail());
		int saved = preparedStatement.executeUpdate();
		if (saved == 1) {
			System.out.println("Passwords saved successfully");
		} else {
			System.out.println("Passwords not saved");
		}
		connection.close();
	}
}
