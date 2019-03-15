package com.company.utils.ioutils;

import com.company.ActionItem;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class FileOprations {


    private static final String TASK_DB_HEADER="";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final String COMMA_DELIMITER = ",";

    public static void writeCsvFile(ArrayList<String> tasks, String fileName) {

              //Create a new list of student objects
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(new File(fileName));

               for (String task : tasks) {
                fileWriter.append(task);
                System.out.println("Saving Details of task "+task);
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
            System.out.println("CSV file was created successfully !!!");
        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            //e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (Exception e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                //e.printStackTrace();
            }

        }
    }

    public static ArrayList<String> readCsvFile(String fileName) {
        ArrayList<String>  taskList= new ArrayList<String>();

        try {
            String line = "";
            BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
            fileReader.readLine();
            while ((line = fileReader.readLine()) != null) {
                taskList.add(line);
                }

        } catch (FileNotFoundException e) {
          System.out.println("No Database found for user :"+fileName);
        } catch (EOFException e) {
            System.out.println("The databse is empty");
        }
        catch (IOException e) {
            e.printStackTrace();
            System.out.println("No Database found for user :"+fileName + "Create New Database");
        }


        return taskList;
    }

}
