# Student Registration System

The Student Registration System is a console-based application designed to manage and interact with administrator and student accounts. The system facilitates actions such as creating, viewing, updating, and deleting student accounts, as well as providing a login mechanism for both administrators and students.

## Main Features:

**Administrator Actions:** 
  * Admin Login: 
    * Administrators can log in using their credentials stored in the "adminCredentials.txt" file. 
    * Upon successful login, admins gain access to a set of administrative actions. 
  * Create Student Account: 
    * Admins can create a new student account by providing necessary details such as student ID, password, name, date of           birth, place of birth, major, and grade. 
    * The new student account is added to the system, and the data is stored in the "studentData.txt" file. 
  * View Student Account: 
    * Admins can view a list of all student accounts, displaying their student ID, name, major, and grade.
  * Update Student Account:
    * Admins can update the information of an existing student account by providing the student ID and entering the updated        details.
  * Delete Student Account:
    * Admins can delete a student account by providing the student ID. The corresponding student data is removed, and the          "studentData.txt" file is updated.
  * Logout:
    * Admins can log out of the system, ending the administrative session.
**Student Actions:**
  * Student Login:
    * Students can log in using their student ID and password.
    * Upon successful login, students gain access to a set of student actions.
  * View Profile:
    * Students can view their profile, displaying their student ID, password, name, date of birth, place of birth, major,          and grade.
  * Logout:
    * Students can log out of the system, ending the student session.
## Utility Classes:
  * User Class:
    * An abstract class representing a user with common attributes (username and password) and methods for login, access level identification, and string representation.
  * Admin Class:
    * A subclass of the User class representing administrators. It includes methods for managing student data, deleting      student accounts, viewing student data, and checking admin status.
  * Student Class:
    * A subclass of the User class representing students. It includes attributes for student-specific information and methods for accessing and updating student data.
  * FileUtils Class:
    * A utility class providing methods for reading and writing administrator credentials and student data to files ("adminCredentials.txt" and "studentData.txt").
  * StudentUtils Class:
    * A utility class with a method for viewing student data on a map.
  * LoginManager Class:
    * A utility class providing methods for handling admin and student login operations.
  * ReadFile Class:
    * A utility class with a method for reading and printing the contents of text files.
**Running the System:**
* The main class, StudentRegistrationSystem, orchestrates the entire system. It initializes maps for admin and student accounts, prompts the user to choose between admin and student login, and executes the corresponding actions based on user input.
* The system uses simple console-based interactions, making it accessible for users to perform necessary actions within the Student Registration System.
**Note:**
* Ensure that all required files ("adminCredentials.txt" and "studentData.txt") exist and contain the necessary data before running the system.

