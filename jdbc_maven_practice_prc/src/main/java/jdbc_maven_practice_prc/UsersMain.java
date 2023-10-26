package jdbc_maven_practice_prc;

import java.util.Scanner;

public class UsersMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int choice, choice1;
		boolean key = true;
		Users users = new Users();
		UsersCRUD crud = new UsersCRUD();
		do {
			System.out.println("Enter the choice \n 1.Signup user \n 2.Login user \n 3.Exit");
			choice = scanner.nextInt();
			switch (choice) {
			case 1: {
				System.out.println("Enter the id");
				int id = scanner.nextInt();
				System.out.println("Enter the name");
				String name = scanner.next();
				System.out.println("Enter the email");
				String email = scanner.next();
				System.out.println("Enter the password");
				String password = scanner.next();
				System.out.println("Enter the address");
				String address = scanner.next();

				users.setId(id);
				users.setName(name);
				users.setEmail(email);
				users.setPassword(password);
				users.setAddress(address);

				try {
					crud.signupUsers(users);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				break;
			case 2: {
				System.out.println("Enter the email");
				String email = scanner.next();
				System.out.println("Enter the password");
				String password = scanner.next();

				users.setEmail(email);
				users.setPassword(password);

				try {
					boolean result = crud.loginUsers(users);
					if (result == true) {
						System.out.println("Logged In Successful");
						boolean key1 = true;
						do {
							crud.displayPasswords(email);
							System.out.println("Enter the choice \n Press 'Y' for continue \n Press Anything for exit");
							choice1 = scanner.next().charAt(0);
							switch (choice1) {
							case 'Y': {
								System.out.println("Enter the Facebook password");
								String facebook = scanner.next();
								System.out.println("Enter the Whatsapp password");
								String whatsapp = scanner.next();
								System.out.println("Enter the Instagram password");
								String instagram = scanner.next();
								System.out.println("Enter the Snapchat password");
								String snapchat = scanner.next();
								System.out.println("Enter the Twitter password");
								String twitter = scanner.next();

								users.setFacebook(facebook);
								users.setWhatsapp(whatsapp);
								users.setInstagram(instagram);
								users.setSnapchat(snapchat);
								users.setTwitter(twitter);

								crud.savePasswords(users);
							}
								break;
							default:
								key1 = false;
							}
						} while (key1);
					} else {
						System.out.println("Invalid Password");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				break;
			case 3: {
				key = false;
			}
				break;
			}
		} while (key);

	}

}
