class Student extends User {
    private String studentID;
    private String studentPassword;
    private String studentName;
    private String dateOfBirth;
    private String placeOfBirth;
    private String major;
    private String grade;

    public Student(String studentID, String studentPassword, String studentName, String dateOfBirth, String placeOfBirth, String major, String grade) {
        super(studentID, studentPassword);
        this.studentID = studentID;
        this.studentPassword = studentPassword;
        this.studentName = studentName;
        this.dateOfBirth = dateOfBirth;
        this.placeOfBirth = placeOfBirth;
        this.major = major;
        this.grade = grade;
    }



    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (!super.equals(obj)) {
            return false;
        }
        Student student = (Student) obj;
        return studentID.equals(student.studentID) && studentPassword.equals(student.studentPassword) && studentName.equals(student.studentName) &&
                dateOfBirth.equals(student.dateOfBirth) && placeOfBirth.equals(student.placeOfBirth) &&
                major.equals(student.major) && grade.equals(student.grade);
    }

    @Override
    public String toString() {
        return String.format("ID: %s\nPassword: %s\nName: %s\nDOB: %s\nPlace of Birth: %s\nMajor: %s\nGrade: %s",
                studentID, studentPassword, studentName, dateOfBirth, placeOfBirth, major, grade);
    }
    // Getter methods for student attributes
    
    public String getStudentID() {
        return studentID;
    }

    public String getStudentPassword() {
        return studentPassword;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public String getMajor() {
        return major;
    }

    public String getGrade() {
        return grade;
    }

    // Setter methods for student attributes
    
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public void setStudentPassword(String password){
        this.studentPassword = password;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
