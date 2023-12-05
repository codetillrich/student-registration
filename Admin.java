import java.util.ArrayList; // Store the data of student in array
import java.util.List; // Store order collection 

class Admin extends User {
    private List<Student> registeredStudents;

    public Admin(String username, String password) {
        super(username, password);
        registeredStudents = new ArrayList<>();
    }

    public void registerStudent(String username, String password) {
        Student student = new Student(username, password);
        registeredStudents.add(student);
        System.out.println("Student registered: " + student.getUsername());
    }

    public List<Student> getRegisteredStudents() {
        return registeredStudents;
    }

    // The first insert function of the admin that allow the admin to insert the personal data of the student
    public void insertData(Student student) {
        System.out.println("Inserting data for student: " + student.getUsername());
    }

    // The function that allow the admin to update student data
    public void updateData(Student student) {
        System.out.println("Updating data for student: " + student.getUsername());
    }

    // Admin delete data of student function
    public void deleteData(Student student) {
        System.out.println("Deleting data for student: " + student.getUsername());
    }

    public void showData(Student student) {
        System.out.println("Showing data for student: " + student.getUsername());
    }

    // Admin create transcrpit for student 
    public void createTranscript(Student student) {
        System.out.println("Creating transcript for student: " + student.getUsername());
    }


    // The method that allow the admin to view their data but as an admin, their don't have any data to view
    @Override
    public void viewPersonalData() {
        // Admin doesn't have personal data to view
        System.out.println("Admin doesn't have personal data.");
    }
}