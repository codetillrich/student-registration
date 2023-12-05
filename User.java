abstract class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    // This abstract method is use to view the imformation of both user admin and student
    // The admin does not have any imformation to view 
    // student need to view their data and request to update in case their information is not correct. 
    public abstract void viewPersonalData();
}

/*
1. why we need to use abstract class for user? 
The abstract class User is used in this code to create a common structure and behavior for different type of users (student and admin). 
It helps to reuse code, store shared information, and ensure that certain methods are implemented by each type of user.

2. polymorphism in this code 
The objects of different subclasses can be treated as instances of the abstract class. In the code, 
we can create a User reference and assign it an instance of either Student or Admin. 
This allows us to work with different types of users using a common interface, 
which can simplify code and promote flexibility.

 */