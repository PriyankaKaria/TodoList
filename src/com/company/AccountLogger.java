package com.company;

import java.util.Scanner;
public class AccountLogger {
    private AccountMaker accountMaker;
    private Scanner input = new Scanner(System.in);
    private String login, password;


    AccountLogger(AccountMaker accountMaker) {
        this.accountMaker = accountMaker;
    }


    void inputLoginAndPassword() {
        System.out.print("Enter Username:");
        login = input.next();

        System.out.print("Enter Password:");
        password = input.next();
    }

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

