package jdbc_maven_eb9_prc;

import java.util.Scanner;

public class PersonMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
//		System.out.println("Enter the id");
//		int id = scanner.nextInt();
//		System.out.println("Enter the name");
//		String name = scanner.next();
//		System.out.println("Enter the phone");
//		long phone = scanner.nextLong();

//		Person person = new Person();
//		person.setId(id);
//		person.setName(name);
//		person.setPhone(phone);

		PersonCRUD crud = new PersonCRUD();

//		try {
//			crud.savePerson(person);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		try {
//			crud.updatePerson(person);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		try {
//			crud.deletePerson(id);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		try {
			crud.getAllPerson();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
