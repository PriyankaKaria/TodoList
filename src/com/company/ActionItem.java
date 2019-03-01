package com.company;

import java.util.Date;

public class ActionItem {
    private Date reminderOn;
    private Date deadLine;
    private String taskName;
    private int taskPriority;
    private enum taskStatus {
        NEW,ONHOLD,CLOSED,OPEN,WAITING,PENDING;
    };

    @Override
    public String toString() {
        return "\t\t" + taskName +
                "\t"+ taskPriority +
                "\t\t"+ reminderOn +
                "\t\t" + deadLine ;
    }

    public ActionItem(String taskName, int taskPriority, Date reminderOn, Date deadLine) {
        this.taskName = taskName;
        this.taskPriority = taskPriority;
        this.reminderOn = reminderOn;
        this.deadLine = deadLine;
    }


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


}
