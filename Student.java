class Student extends User {
    public Student(String username, String password) {
        super(username, password);
    }


    // The method that allow student to view their personal data
    @Override
    public void viewPersonalData() {
        System.out.println("Viewing personal data for student: " + getUsername());
    }
}