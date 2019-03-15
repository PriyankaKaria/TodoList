package com.company;
// this class make a account for user
import java.util.HashMap;
import java.util.Scanner;

public class AccountMaker {

    private HashMap<String, User> loginDetails = new HashMap<>();
    private String login, password;
    private Scanner input = new Scanner(System.in);

    //taking username and password from user
    void inputLoginAndPassword() {
        System.out.print("Enter Username:");
        login = input.next();

        System.out.print("Enter Password:");
        password = input.next();
    }

    void createAccount() throws InterruptedException {
        User newUser = new User(login, password);
        loginDetails.put(login, newUser);
        System.out.println("Account has been created successfully");
        Thread.sleep(2000);
    }

    //this is for testing
    HashMap<String, User> getLoginDetails() {
        return loginDetails;
    }

}

