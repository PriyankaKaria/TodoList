package com.company;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

public class UserTest
{
    private User userToBEChanged;
    private User emptyUser;
    private User userWitElements;




    @Before
    public void setUp() throws Exception
    {
        userToBEChanged = new User("nour", "");
        emptyUser = new User("nour", "");
        userWitElements = new User("nour", "");
        //TODO add more element with no null value
        userWitElements.addNewTask(new ActionItem(null, 3, null, null, null), "");
        //user.addNewTask(null, "sdf");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addNewTask()
    {
        ActionItem expectedItem11 =  new ActionItem("name", 3, "asd", null, null);
        userToBEChanged.addNewTask(expectedItem11, "pro");

        HashMap<String, ArrayList<ActionItem>> map = userToBEChanged.getHashMap();
        map.containsKey("pro");
        ActionItem actualItem1 = map.get("pro").get(0);

        assertEquals(expectedItem11, actualItem1);

        assertEquals(1, map.size());
        assertEquals(1, map.get("pro").size());

        //TODO add more element and do defferent test things

        //assertEquals("pro", );

    }

    @Test
    public void deleteTask()
    {
        ActionItem action1 = null;
        /*TODO
        1- write the index
        call delete
        get the hash map
        make sure that the action item you deleted doesn't exist
        */
        userWitElements.deleteTask("2", "");
        HashMap<String, ArrayList<ActionItem>> map = userToBEChanged.getHashMap();
        // e.x. check that size doesn't
        // assertEquals(false, map.get("pro").contains(action1));


    }

    @Test
    public void editTask() {
    }

    @Test
    public void restoreExistingTasks() {
    }

    @Test
    public void showAllTasks() {
    }

    @Test
    public void getPassword() {
    }

    @Test
    public void backup() {
    }

    @Test
    public void getHashMap() {
    }
}