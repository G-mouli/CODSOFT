import java.util.*;

public class StudentManagementApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManagementSystem sms = new StudentManagementSystem();
        int choice;

        do {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Remove Student");
            System.out.println("4. Search Student");
            System.out.println("5. Display All Students");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Roll No: ");
                    int roll = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Grade: ");
                    String grade = sc.nextLine();
                    System.out.print("Enter Department: ");
                    String dept = sc.nextLine();
                    if (name.isEmpty() || grade.isEmpty() || dept.isEmpty()) {
                        System.out.println("Fields cannot be empty.");
                    } else {
                        sms.addStudent(new Student(name, roll, grade, dept));
                    }
                    break;

                case 2:
                    System.out.print("Enter Roll No to Edit: ");
                    int rEdit = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter New Name: ");
                    String nName = sc.nextLine();
                    System.out.print("Enter New Grade: ");
                    String nGrade = sc.nextLine();
                    System.out.print("Enter New Department: ");
                    String nDept = sc.nextLine();
                    sms.editStudent(rEdit, nName, nGrade, nDept);
                    break;

                case 3:
                    System.out.print("Enter Roll No to Remove: ");
                    int rRemove = sc.nextInt();
                    sms.removeStudent(rRemove);
                    break;

                case 4:
                    System.out.print("Enter Roll No to Search: ");
                    int rSearch = sc.nextInt();
                    Student found = sms.searchStudent(rSearch);
                    System.out.println(found != null ? found : "Student not found.");
                    break;

                case 5:
                    sms.displayAllStudents();
                    break;

                case 6:
                    System.out.println("Exiting program.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 6);

        sc.close();
    }
}
