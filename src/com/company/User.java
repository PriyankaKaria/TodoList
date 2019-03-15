package com.company;


import java.util.ArrayList;
import java.util.HashMap;
// this class is for getting the data of user
public class User {
    private Tasker tasker;
    private String login;
    private String password;
//login and password
    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User(Tasker tasks) {
        this.tasker = tasks;
    }
    //calling various methods to perform the tasks
    public void addNewTask(ActionItem task,String project) {
        tasker.createTask(task,project);
    }

    public void deleteTask(String taskIndex,String project)
    {
         int index = Integer.parseInt(taskIndex);
        tasker.deleteTask(index,project);
    }

    void editTask(String taskIndex, String projectName) {
        tasker.editTask(taskIndex,projectName);
    }
    void restoreExistingTasks (String FileName) {
        System.out.println("Restoring :"+FileName);
        tasker.restoreTasksforUser(FileName);
    }
    void showAllTasks() {
        tasker.showAllTasks();
    }

    String getPassword() {
        return password;
    }

    public void backup(String fileName){
        tasker.generateStreamForBackup(fileName);
    }

    /**
     * this is just for testing
     * @return
     */
    public HashMap<String, ArrayList<ActionItem>> getHashMap()
    {
        return tasker.getProjectsSpecificTasks();
    }
}
