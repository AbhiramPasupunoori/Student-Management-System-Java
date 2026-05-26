import java.util.Scanner;

public class Main {

    public static void main(String[]args) {

        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        while (true) {

            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Students");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // Consume newline
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();
                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    sc.nextLine(); // Consume newline
                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();
                    manager.addStudent(new Student(id, name, email, age, course));
                    break;
                case 2:
                    manager.viewStudents();
                    break;
                case 3:
                    System.out.print("Enter ID to search: ");
                    int searchId = sc.nextInt();
                    Student s = manager.searchStudent(searchId);
                    if (s != null) {
                        System.out.println(s);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter ID to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine(); // Consume newline
                    System.out.print("Enter new Name: ");
                    String newName = sc.nextLine();
                    System.out.print("Enter new Email: ");
                    String newEmail = sc.nextLine();
                    System.out.print("Enter new Age: ");
                    int newAge = sc.nextInt();
                    sc.nextLine(); // Consume newline
                    System.out.print("Enter new Course: ");
                    String newCourse = sc.nextLine();

                    if (manager.updateStudent(
                                updateId,
                                newName,
                                newEmail,
                                newAge,
                                newCourse)) {
                        System.out.println("Student updated.");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                    case 5:
                        System.out.println("Enter Student ID: ");
                        int deleteId = sc.nextInt();

                        if (manager.deleteStudent(deleteId)) {
                            System.out.println("Student deleted.");
                        } else {
                            System.out.println("Student not found.");
                        }
                        break;

                        case 6:
                            System.out.println("Exiting...");
                            sc.close();
                            System.exit(0);

                            default:
                                System.out.println("Invalid choice. Please try again.");
                    }
        }
    }
    
}
