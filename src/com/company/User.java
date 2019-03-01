package com.company;



public class User {
    private Tasker tasker;
    private String login;
    private String password;

    User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    User(Tasker tasks) {
        this.tasker = tasks;
    }

    void addNewTask(ActionItem task,String project) {
        tasker.createTask(task,project);
    }

    void deleteTask(String taskIndex,String project) {
    int index = Integer.parseInt(taskIndex);
        tasker.deleteTask(index,project);
    }

    void showAllTasks() {
        tasker.showAllTasks();
    }

    String getPassword() {
        return password;
    }

}
