package com.company;
// this class is to add actionitem deatails
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

public class ActionItem {
    private Date reminderOn;
    private Date deadLine;
    private String taskName;
    private String taskStatus;
    private int taskPriority;
    private boolean isClosed;


    public ActionItem(String taskName, int taskPriority, String Status ,Date reminderOn, Date deadLine) {
        this.taskName = taskName;
        this.taskPriority = taskPriority;
        this.reminderOn = reminderOn;
        this.deadLine = deadLine;
        this.taskStatus=Status;
    }


    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    @Override
    public String toString() {
        return "\t\t" + taskName +
                "\t"+ taskPriority +
                "\t"+ taskStatus +
                "\t\t"+ reminderOn +
                "\t\t" + deadLine ;
    }


    @Override
    public boolean equals(Object o)
    {
        if (! (o instanceof ActionItem) )
            return false;
        else
        {
            ActionItem otherItem = (ActionItem) o;
            if (this.taskName.equals(otherItem.getTaskName()) && this.taskStatus.equals(otherItem.taskStatus)
                    && (this.isClosed == otherItem.isClosed()) && this.taskPriority == otherItem.taskPriority
                    && this.reminderOn.equals(otherItem.getReminderOn()) && this.deadLine.equals(otherItem.getdeadLine()))
                return true;
            else
                return false;
        }

        }

    // calling each method for getting the details of action item/ task
    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public int getTaskPriority() {
        return taskPriority;
    }

    public void setTaskPriority(int taskPriority) {
        this.taskPriority = taskPriority;
    }

    public Date getReminderOn() {
        return reminderOn;
    }

    public void setReminderOn(Date reminderOn) {
        this.reminderOn = reminderOn;
    }

    public Date getdeadLine() {
        return deadLine;
    }

    public void setdeadLine(Date deadLine) {
        this.deadLine = deadLine;
    }

    public String toCSVRow(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        return this.taskName+","+this.taskPriority+","+this.taskStatus+","+dateFormat.format(this.reminderOn)+","+dateFormat.format(this.deadLine);
    }
    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed(boolean closed) {
        isClosed = closed;
    }
}
