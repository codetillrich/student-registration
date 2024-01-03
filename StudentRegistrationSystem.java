
import java.util.Map;
import java.util.Scanner;

public class StudentRegistrationSystem {

    public static void main(String[] args) {
        // Creating a map to store admin accounts
        Map<String, String> adminAccounts = FileUtils.readAdminCredentials();
        // Creating a map to store student accounts
        Map<String, Student> studentAccounts = FileUtils.readStudentData();

        // Prompting the user to select admin or student
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Student Registration System ---");
        System.out.println("1. Admin");
        System.out.println("2. Student");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                // Admin login
                System.out.println("--- Admin Login ---");
                System.out.print("Enter admin username: ");
                String adminUsername = scanner.nextLine();
                System.out.print("Enter admin password: ");
                String adminPassword = scanner.nextLine();

                // Checking if the admin credentials are valid
                adminAccounts = FileUtils.readAdminCredentials();
                if (adminAccounts.containsKey(adminUsername) && adminAccounts.get(adminUsername).equals(adminPassword)) {
                    System.out.println("Admin login successful!");

                    boolean adminRunning = true;
                    while (adminRunning) {
                        System.out.println("\n--- Admin Actions ---");
                        System.out.println("1. Create Student Account");
                        System.out.println("2. View Student Account");
                        System.out.println("3. Update Student Account");
                        System.out.println("4. Delete Student Account");
                        System.out.println("5. Logout");
                        System.out.print("Enter your choice: ");
                        int adminChoice = scanner.nextInt();
                        scanner.nextLine();

                        switch (adminChoice) {
                            case 1:
                                // Creating a new student account
                                createStudentAccount(scanner, studentAccounts);
                                break;
                            case 2: 
                                viewStudentData(scanner, studentAccounts);
                                break;
                            case 3: 
                                updateStudentData(scanner, studentAccounts);
                                break;
                            case 4: 
                                deleteStudentAccount(scanner, studentAccounts);
                                break;
                            case 5:
                                adminRunning = false;
                                System.out.println("Admin logged out.");
                                break;
                            default:
                                System.out.println("Invalid choice.");
                                break;
                        }
                    }
                } else {
                    System.out.println("Invalid admin username or password.");
                }
                break;
            case 2:
                // Student login
                System.out.println("--- Student Login ---");
                System.out.print("Enter student ID: ");
                String studentLoginID = scanner.nextLine();
                System.out.print("Enter student password: ");
                String studentLoginPassword = scanner.nextLine();

                // Check if the student credentials are valid
                Student student = studentAccounts.get(studentLoginID);
                if (student != null && student.login(studentLoginID, studentLoginPassword)) {
                    System.out.println("Student login successful!");

                    boolean studentRunning = true;
                    while (studentRunning) {
                        System.out.println("\n--- Student Actions ---");
                        System.out.println("1. View Profile");
                        System.out.println("2. Logout");
                        System.out.print("Enter your choice: ");
                        int studentChoice = scanner.nextInt();
                        scanner.nextLine();

                        switch (studentChoice) {
                            case 1:
                                // View student profile
                                System.out.println(student);
                                break;
                            case 2:
                                studentRunning = false;
                                System.out.println("Student logged out.");
                                break;
                            default:
                                System.out.println("Invalid choice.");
                                break;
                        }
                    }
                } else {
                    System.out.println("Invalid student ID or password.");
                }
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }


    


    private static void createStudentAccount(Scanner scanner, Map<String, Student> studentAccounts) {
        System.out.print("Enter student ID: ");
        String studentID = scanner.nextLine();
        // Check if the student ID already exists
        if (studentAccounts.containsKey(studentID)) {
            System.out.println("Student ID already exists. Please choose a different ID.");
            return;
        }
        System.out.print("Enter student password: ");
        String studentPassword = scanner.nextLine();
        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();
        System.out.print("Enter date of birth: ");
        String dateOfBirth = scanner.nextLine();
        System.out.print("Enter place of birth: ");
        String placeOfBirth = scanner.nextLine();
        System.out.print("Enter major: ");
        String major = scanner.nextLine();
        System.out.print("Enter grade: ");
        String grade = scanner.nextLine();
        scanner.nextLine();  // Consume the newline character
    
        // Create a Student instance
        Student newStudent = new Student(studentID, studentPassword, studentName, dateOfBirth, placeOfBirth, major, grade);
    
        // Read existing student data
        Map<String, Student> existingStudents = FileUtils.readStudentData();
    
        // Add the new student to the existing data
        existingStudents.put(studentID, newStudent);
    
        // Write all student data back to the file
        FileUtils.writeStudentData(existingStudents);
    
        System.out.println("Student account created successfully!");
    }  
    
    private static void viewStudentData(Scanner scanner, Map<String, Student> studentAccounts) {
        // Use forEach and a lambda expression to iterate over the student accounts and display data
            studentAccounts.forEach((studentID, student) ->
                    System.out.println("Student ID: " + studentID + ", Name: " + student.getStudentName()
                            + ", Major: " + student.getMajor() + ", Grade: " + student.getGrade()));
       
    }
    

    private static void updateStudentData(Scanner scanner, Map<String, Student> studentAccounts) {
        System.out.print("Enter student ID to update: ");
        String studentIDToUpdate = scanner.nextLine();
    
        if (studentAccounts.containsKey(studentIDToUpdate)) {
            System.out.println("--- Update Student Data ---");
            System.out.println("Enter new data for the student with ID " + studentIDToUpdate + ":");
    
            // Get the existing student
            Student existingStudent = studentAccounts.get(studentIDToUpdate);
    
            // Gather updated information
            System.out.print("Enter new student password: ");
            String newStudentPassword = scanner.nextLine();
            System.out.print("Enter new student name: ");
            String newStudentName = scanner.nextLine();
            System.out.print("Enter new date of birth: ");
            String newDateOfBirth = scanner.nextLine();
            System.out.print("Enter new place of birth: ");
            String newPlaceOfBirth = scanner.nextLine();
            System.out.print("Enter new major: ");
            String newMajor = scanner.nextLine();
            System.out.print("Enter new grade: ");
            String newGrade = scanner.nextLine();
            scanner.nextLine();  // Consume the newline character
    
            // Update the existing student data
            existingStudent.setStudentPassword(newStudentPassword);
            existingStudent.setStudentName(newStudentName);
            existingStudent.setDateOfBirth(newDateOfBirth);
            existingStudent.setPlaceOfBirth(newPlaceOfBirth);
            existingStudent.setMajor(newMajor);
            existingStudent.setGrade(newGrade);
    
            // Update the map with the modified student data
            studentAccounts.put(studentIDToUpdate, existingStudent);
    
            // Write all student data back to the file
            FileUtils.writeStudentData(studentAccounts);
    
            System.out.println("Student account updated successfully!");
        } else {
            System.out.println("Student account with ID " + studentIDToUpdate + " not found.");
        }
    }    

    private static void deleteStudentAccount(Scanner scanner, Map<String, Student> studentAccounts) {
        System.out.print("Enter student ID to delete: ");
        String studentIDToDelete = scanner.nextLine();
    
        if (studentAccounts.containsKey(studentIDToDelete)) {
            studentAccounts.remove(studentIDToDelete);
            FileUtils.writeStudentData(studentAccounts);
            System.out.println("Student account deleted successfully!");
        } else {
            System.out.println("Student account with ID " + studentIDToDelete + " not found.");
        }
    }  
}
