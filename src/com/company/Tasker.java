package com.company;

        import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.Set;


public class Tasker {

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

    void deleteTask( int taskIndex, String project) {
        System.out.println("Projects :"+this.projectsSpecificTasks);
        ArrayList<ActionItem>  listOfTasks =this.projectsSpecificTasks.get(project);
        System.out.println("listOfTasks "+listOfTasks);
        listOfTasks.remove(taskIndex);
        this.projectsSpecificTasks.put(project,listOfTasks);
    }

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


}
