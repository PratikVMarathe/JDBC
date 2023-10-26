package jdbc_maven_user_prc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.mysql.cj.jdbc.Driver;

public class BatchExecution {

	public static void main(String[] args) throws Exception {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);

		FileInputStream fileInputStream = new FileInputStream("dbconfig.properties");
		Properties properties = new Properties();
		properties.load(fileInputStream);

		Connection connection = DriverManager.getConnection(properties.getProperty("url"),
				properties.getProperty("username"), properties.getProperty("password"));

		User user1=new User();
		user1.setUserid(3);
		user1.setUsername("Apoorva");
		user1.setPassword("1234");
		user1.setPhone(7884549);
		user1.setEmail("ashish@love.com");
		
		User user2=new User();
		user2.setUserid(4);
		user2.setUsername("Akshatah");
		user2.setPassword("1234");
		user2.setPhone(7884549);
		user2.setEmail("mahesh@love.com");
		
		User user3=new User();
		user3.setUserid(5);
		user3.setUsername("Bharath");
		user3.setPassword("1234");
		user3.setPhone(7884549);
		user3.setEmail("pinky@love.com");
		
		List<User> list=new ArrayList<>();
		list.add(user1);
		list.add(user2);
		list.add(user3);
		
		PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO USER VALUES(?,?,?,?,?)");
		for(User u:list) {
			preparedStatement.setInt(1,u.getUserid());
			preparedStatement.setString(2,u.getUsername());
			preparedStatement.setString(3,u.getPassword());
			preparedStatement.setLong(4,u.getPhone());
			preparedStatement.setString(5,u.getEmail());
			preparedStatement.addBatch();
			System.out.println("Saved in Batch: "+u.getUsername());
		}
		preparedStatement.executeBatch();
		System.out.println("Saved in Database");
		connection.close();
	}

}
