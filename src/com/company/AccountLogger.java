package com.company;
//This class is used for login purpose of the user
import java.util.Scanner;
public class AccountLogger {
    private AccountMaker accountMaker;
    private Scanner input = new Scanner(System.in);
    private String login, password;

    // making account login
    AccountLogger(AccountMaker accountMaker) {
        this.accountMaker = accountMaker;
    }


    public String getUserLogin() {
            return this.login;
    }

    public void inputLoginAndPassword() {

        System.out.print("Enter Username:");
        login = input.next();

        System.out.print("Enter Password:");
        password = input.next();
    }
    // checking password to assure its the same and correct
    boolean isLoginDataIncorrect() {
        User user = accountMaker.getLoginDetails().get(login);
        try {
            if (user.getPassword().equals(password)) {
                System.out.println("You've logged in.");
                return false;
            } else {
                System.out.println("Wrong Username or Password");
            }
        } catch (NullPointerException e) {
            System.out.println("Wrong Username or Password");
        }
        return true;
    }
}

