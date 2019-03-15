package com.company;

import com.company.ToDoEngine;
// this class is to run the whole program
// calling display methods of Mainmenu and user main

public class Main {

    public static void main(String[] args) {
        // write your code here

        ToDoEngine engine = new ToDoEngine();  // creating object
        engine.displayMainMenu(); //calling method
        engine.displayUserMenu();

    }
}
