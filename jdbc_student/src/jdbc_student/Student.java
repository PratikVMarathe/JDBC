package jdbc_student;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;

public class Student {

	public static void main(String[] args) throws Exception {
		//1.Load or Register Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//2.Establish Connection
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","root","root");
		
		//3.Create Statement
		Statement statement=connection.createStatement();
		
		//4.Execute Statement
		statement.execute("INSERT INTO STUDENT VALUES (1,'RAJ',92,'BANGLORE','NAGESH')");
		
		//5.Close
		connection.close();
	}

}
