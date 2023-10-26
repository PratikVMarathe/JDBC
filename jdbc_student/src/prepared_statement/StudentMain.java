package prepared_statement;

import java.util.Scanner;

public class StudentMain {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int choice;
		boolean exit=true;
		StudentCRUD crud=new StudentCRUD();
		do {
			System.out.println("Enter the choice \n 1.Insert Student \n 2.Update Student \n 3.Delete Student \n 4.Get All Student");
			choice=scanner.nextInt();
			switch (choice) {
			case 1:{
				System.out.println("Enter the id to be inserted");
				
			}
				
				break;

			default:
				break;
			}
		} while (exit);

	}

}
