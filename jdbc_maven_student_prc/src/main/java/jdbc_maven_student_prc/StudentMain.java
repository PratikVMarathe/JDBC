package jdbc_maven_student_prc;

import java.util.Scanner;

public class StudentMain {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
//		System.out.println("Enter the id");
//		int id=scanner.nextInt();
//		System.out.println("Enter the name");
//		String name=scanner.next();
//		System.out.println("Enter the marks");
//		int marks=scanner.nextInt();
//		System.out.println("Enter the address");
//		String address=scanner.next();
//		System.out.println("Enter the father's name");
//		String fathersname=scanner.next();
		
//		Student student=new Student();
//		student.setId(id);
//		student.setName(name);
//		student.setMarks(marks);
//		student.setAddress(address);
//		student.setFathersname(fathersname);
		
		StudentCRUD crud=new StudentCRUD();
		
//		try {
//			crud.saveStudent(student);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		try {
//			crud.updateStudent(student);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		try {
//			crud.deleteStudent(id);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		try {
			crud.getAllStudent();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
