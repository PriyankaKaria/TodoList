package com.company;

 import com.company.utils.ioutils.FileOprations;

 import java.text.ParseException;
 import java.text.SimpleDateFormat;
 import java.util.*;

//creates a task
public class Tasker {
    private Scanner input = new Scanner(System.in);
    private HashMap<String, ArrayList<ActionItem>>  projectsSpecificTasks = new HashMap<String, ArrayList<ActionItem>>();

    void createTask(ActionItem task, String project) {
        ArrayList<ActionItem>  listOfTasks = new ArrayList<ActionItem>() ;
        if (this.projectsSpecificTasks.keySet().contains(project)){
            System.out.println("Existing Project Found " );
            listOfTasks = this.projectsSpecificTasks.get(project);
        }
        else {
            System.out.println("New Project Created " );
        }

        listOfTasks.add(task);
        projectsSpecificTasks.put(project,listOfTasks);
    }
// this code is for editing the task
    public void editTask( String taskIndexString, String project) {

        int taskIndex = Integer.parseInt(taskIndexString);
        taskIndex=taskIndex-1;
        System.out.println("Projects :"+this.projectsSpecificTasks);
        ArrayList<ActionItem>  listOfTasks =this.projectsSpecificTasks.get(project);
        System.out.println("listOfTasks "+listOfTasks);
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
          ActionItem newActionItem =  listOfTasks.get(taskIndex);

            System.out.println("Write down  New Name for Action Iem.");
            String taskName =   input.nextLine();

            System.out.println("Enter new value for Task Priority in numeric format. 1 for highest and bigger number for lowest");
            String taskPriority =input.nextLine();
            int priority= Integer.parseInt(taskPriority);

             System.out.println("Enter  new value to be updated for Status");
            String status=input.nextLine();

            System.out.println("Enter  new value for Deadline in yyyy.MM.dd HH:mm:ss Format");
            String date=input.nextLine();
            Date taskDedaline = format.parse(date);

            System.out.println("Enter the time when you want to be reminded in yyyy.MM.dd HH:mm:ss Format");
            String taskReminder = input.nextLine();
            Date reminderTime = format.parse(taskReminder);


        newActionItem.setTaskName(taskName);
        newActionItem.setTaskPriority(priority);
        newActionItem.setdeadLine(taskDedaline);
        newActionItem.setReminderOn(reminderTime);
        newActionItem.setTaskStatus(status);
        listOfTasks.remove(taskIndex);
        listOfTasks.add(taskIndex,newActionItem);
        System.out.println("Task Modified");
    } catch (Exception e) {
    e.printStackTrace();
    }

        this.projectsSpecificTasks.put(project,listOfTasks);

    }
    //this code for deleting  the task
    void deleteTask( int taskIndex, String project) {
        System.out.println("Projects :"+this.projectsSpecificTasks);
        ArrayList<ActionItem>  listOfTasks =this.projectsSpecificTasks.get(project);
        System.out.println("listOfTasks "+listOfTasks);
        listOfTasks.remove(taskIndex);
        this.projectsSpecificTasks.put(project,listOfTasks);
    }
    // this code is for showing all the tasks
    void showAllTasks() {
        Set<String> projects = this.projectsSpecificTasks.keySet();
        System.out.println("Sr No. \t Project Name \t\t Task Name \tPriority \t Reminder \t\tDeadline");
        int index =0;
        for (String project : projects) {
            ArrayList<ActionItem>   listOfTasks=  this.projectsSpecificTasks.get(project);
            for (ActionItem item : listOfTasks) {
                index ++;
                System.out.println(index+"\t\t "+project+"\t "+item);
            }
        }

    }

    // generate stream for backup
    public void generateStreamForBackup(String fileName){
        ArrayList<String> listOfTasks = new ArrayList<String> ();
        Set<String> projects=this.projectsSpecificTasks.keySet();
        for (String project : projects) {
            ArrayList<ActionItem>   currentProjectTasks=  this.projectsSpecificTasks.get(project);
            for (ActionItem item : currentProjectTasks) {
                listOfTasks.add(project+","+item.toCSVRow());
            }
        }
        FileOprations.writeCsvFile(listOfTasks,fileName);
    }

    // restore the data
    public void restoreTasksforUser( String FileName){
        FileOprations ioClient = new FileOprations();
        SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

        ArrayList<String> existingtasks = FileOprations.readCsvFile(FileName);
         for (String existingTask : existingtasks ) {

             String[] tokens = existingTask.split(",");
             if (tokens.length == 5){
                 try {
                 String projectName= tokens[0];
                 String taskName=tokens[1];
                 int priority = Integer.parseInt(tokens[2]);
                 String Status = tokens[3];
                 Date deadline = format.parse(tokens[4]);
                 Date reminder = format.parse(tokens[5]);
                 this.createTask(new ActionItem(taskName,priority,Status,deadline,reminder),projectName);
                 } catch (ParseException e) {
                     e.printStackTrace();
                 }

             }
         }
    }
// this is for testing
 private boolean isNotEmpty(String input) {
        if ( !input.equals( null) && !input.equals("") && ! (input == null)){
            return true;
        }else {
            return false;
        }
 }

    public HashMap<String, ArrayList<ActionItem>> getProjectsSpecificTasks()
    {
        return projectsSpecificTasks;
    }

}
