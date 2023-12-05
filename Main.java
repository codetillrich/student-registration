public class Main {
    public static void main(String[] args) {
        // Create an instance of Admin
        Admin admin = new Admin("admin123", "adminPassword");

        // Register a student
        admin.registerStudent("student1", "studentPassword");

        // Create an instance of Student
        Student student = new Student("student1", "studentPassword");

        // Student logs in and views personal data
        if (student.getUsername().equals("student1") && student.getPassword().equals("studentPassword")) {
            student.viewPersonalData();
        }

        // Admin logs in and performs actions
        if (admin.getUsername().equals("admin123") && admin.getPassword().equals("adminPassword")) {
            for (Student s : admin.getRegisteredStudents()) {
                // Perform admin actions on student data
                admin.insertData(s);
                admin.updateData(s);
                admin.deleteData(s);
                admin.showData(s);
                admin.createTranscript(s);
            }
        }
    }
}