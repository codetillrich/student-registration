public class Student_Information {
    private String name;
    private String email;
    private int id;
    private String major;
    private char grade;

    //method for name
    public String getName()
    {
        return this.name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    
    //method for email
    public String getEmail()
    {
        return this.email;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }

    //method for id
    public int getId()
    {
        return this.id;
    }
    public void setId(int id)
    {
        this.id = id;
    }

    //method for major
    public String getMajor()
    {
        return this.major;
    }
    public void setMajor(String major)
    {
        this.major = major;
    }

    //method for grade
    public char getGrade()
    {
        return this.grade;
    }
    public void setGrade(char grade)
    {
        this.grade = grade;
    }
}
