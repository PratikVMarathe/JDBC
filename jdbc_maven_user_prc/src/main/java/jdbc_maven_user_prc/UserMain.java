package jdbc_maven_user_prc;

import java.util.Scanner;

public class UserMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
//		System.out.println("Enter the user id");
//		int userid=scanner.nextInt();
		System.out.println("Enter the username");
		String username = scanner.next();
		System.out.println("Enter the password");
		String password = scanner.next();
//		System.out.println("Enter the phone");
//		long phone=scanner.nextLong();
//		System.out.println("Enter the email");
//		String email=scanner.next();

		User user = new User();
//		user.setUserid(userid);
		user.setUsername(username);
		user.setPassword(password);
//		user.setPhone(phone);
//		user.setEmail(email);

		UserCRUD crud = new UserCRUD();

//		try {
//			crud.saveUser(user);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

//		try {
//			crud.updateUser(user);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

//		try {
//			crud.deleteUser(username);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

//		try {
//			crud.getAllUser();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

//		try {
//			crud.signinUser(user);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		try {
			boolean result = crud.loginUser(user);
			if (result == true) {
				System.out.println("Logged In Successful");
			} else {
				System.out.println("Invalid Password");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
