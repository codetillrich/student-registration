import java.util.Map;

class Admin extends User {

    public Admin(String username, String password) {
        super(username, password);
    }

    // Original method
    public void insertStudentData(Student student, String studentName, String studentID,
                                  String dateOfBirth, String placeOfBirth, String major, String grade) {
        if (isAdmin()) {
            student.setStudentName(studentName);
            student.setStudentID(studentID);
            student.setDateOfBirth(dateOfBirth);
            student.setPlaceOfBirth(placeOfBirth);
            student.setMajor(major);
            student.setGrade(grade);
        } else {
            System.out.println("Permission denied. Only Admins can insert student data.");
        }
    }

    // Overloaded method with minimal parameters
    public void insertStudentData(Student student, String studentName, String studentID) {
        insertStudentData(student, studentName, studentID, "", "", "", "");
    }

    // Overloaded method with default values for student
    public void insertStudentData(Student student) {
        insertStudentData(student, "Default Name", "Default ID", "Default DOB", "Default Place of Birth", "Default Major", "Default Grade");
    }

    // Overloaded method for updating student data with minimal parameters
    public void updateStudentData(Student student, String studentName, String studentID) {
        updateStudentData(student, studentName, studentID, "", "", "", "");
    }

    // Overloaded method for updating student data with default values
    public void updateStudentData(Student student) {
        updateStudentData(student, "Updated Default Name", "Updated Default ID", "Updated Default DOB", "Updated Default Place of Birth", "Updated Default Major", "Updated Default Grade");
    }

    // Original method
    void deleteStudentAccount(Map<String, Student> studentAccounts, String studentID) {
        if (isAdmin()) {
            if (studentAccounts.containsKey(studentID)) {
                Student deletedStudent = studentAccounts.remove(studentID);
                System.out.println("Student account deleted successfully: " + deletedStudent.getStudentName());
                // Write the updated student data back to the file
                FileUtils.writeStudentData(studentAccounts);
            } else {
                System.out.println("Student account with ID " + studentID + " not found.");
            }
        } else {
            System.out.println("Permission denied. Only Admins can delete student accounts.");
        }
    }

    void viewStudentData(Map<String, Student> studentAccounts) {
        if (isAdmin()) {
            for (Map.Entry<String, Student> entry : studentAccounts.entrySet()) {
                String studentID = entry.getKey();
                Student student = entry.getValue();
                System.out.println("Student ID: " + studentID + ", Name: " + student.getStudentName()
                        + ", Major: " + student.getMajor() + ", Grade: " + student.getGrade());
            }
        } else {
            System.out.println("Permission denied. Only Admins can view student data.");
        }
    }

    void updateStudentData(Student student, String studentName, String studentID,
                           String dateOfBirth, String placeOfBirth, String major, String grade) {
        if (isAdmin()) {
            student.setStudentName(studentName);
            student.setStudentID(studentID);
            student.setDateOfBirth(dateOfBirth);
            student.setPlaceOfBirth(placeOfBirth);
            student.setMajor(major);
            student.setGrade(grade);
        } else {
            System.out.println("Permission denied. Only Admins can insert student data.");
        }
    }

    boolean isAdmin() {
        return true; // For simplicity, assuming all instances of Admin are indeed admins
    }
}
