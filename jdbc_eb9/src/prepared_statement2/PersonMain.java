package prepared_statement2;

import java.util.Scanner;

public class PersonMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int choice;
		boolean exit=true;
		PersonCRUD crud=new PersonCRUD();
		do {
			System.out.println("Enter the choice \n 1.Save Person \n 2.Update Person \n 3.Delete Person \n 4.Get All Person");
			choice=scanner.nextInt();
			switch (choice) {
			case 1:{
				System.out.println("Enter the id to be inserted");
				int id=scanner.nextInt();
				System.out.println("Enter the name to be inserted");
				String name=scanner.next();
				System.out.println("Enter the phone to be inserted");
				long phone=scanner.nextLong();
				
				try {
					crud.savePerson(id,name,phone);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
			case 2:{
				System.out.println("Enter the id to be updated");
				int id=scanner.nextInt();
				System.out.println("Enter the name to be updated");
				String name=scanner.next();
				
				try {
					crud.updatePerson(id,name);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
			case 3:{
				System.out.println("Enter the id to be deleted");
				int id=scanner.nextInt();
				
				try {
					crud.deletePerson(id);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
			case 4:{
				try {
					crud.getAllPerson();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
			default:
				exit=false;
			}
		}while(exit);
	}

}
