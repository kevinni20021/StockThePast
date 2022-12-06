package Iterator;


import java.util.*;
import java.io.*;


public class ReadFile implements Iterator{

    // This class is responsible for looping through the given files
    private String fileName;

    public int curDay = 20;
    public int curMonth = 11;
    public int curYear = 2017;
    private int counter = 0;

    private ArrayList<String> fileInfo;


    /**
     * This constructor is responsible for getting the file name when this class is called
     * As well as saving the file information into the variable fileInfo
     * @param fileName the name of the file that the user wants to iterate through
     */
    public ReadFile(String fileName) {
        this.fileName = fileName;
        this.fileInfo = this.readFileReverse();
    }


    /**
     * This method will read the given file line by line
     * @return an arraylist containing each line
     */
    public ArrayList<String> readFile() {
        ArrayList<String> fileInfo = new ArrayList<>();
        try {
            BufferedReader f = new BufferedReader(new FileReader(this.fileName));
            String tempLine = f.readLine();
            while (tempLine != null) {
                fileInfo.add(tempLine);
                tempLine = f.readLine();
            }
            f.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileInfo;
    }


    /**
     * This method will reverse the order of the list containing the file info
     * @return an arraylist containing each line in reverse order
     */
    public ArrayList<String> readFileReverse() {
        ArrayList<String> fileInfo = this.readFile();
        ArrayList<String> result = new ArrayList<>();
        for (int i = fileInfo.size() - 1; i >= 0; i--) {
            result.add(fileInfo.get(i));
        }
        return result;
    }

    /**
     * Returns the current day as a String
     * @return current date
     */
    public String getCurrDay() {
        String temp = curMonth + "/" + curDay + "/" + curYear;;
        if (curMonth < 10) {
            temp = "0" + temp;
        }
        if (curDay < 10) {
            temp = temp.substring(0, 3) + "0" + temp.substring(3);
        }
        return temp;
    }

    /**
     * This method will organize the file information into a map
     * @return a map where the keys is date, and the value is a list of the parameters
     */
    public Map<String, ArrayList<String>> organizeFileInfo() {
        ArrayList<String> fileInfo = this.readFileReverse();
        Map<String, ArrayList<String>> result = new HashMap<>();
        for (String line: fileInfo) {
            ArrayList<String> temp = new ArrayList<>(Arrays.asList(line.split(",")).subList(1, line.split(",").length));
            result.put(line.split(",")[0], temp);
        }
        return result;


    }


    /**
     * This method will find the information of specified date
     * @return an arraylist that contains all the information for the specified date
     */
    public Map<String, String> dayInfo(int day, int month, int year) {
        //check and ask to see if we need to check the correctness of import date
        //if yes, check and ask if we do that here or front end.
        String temp = month + "/" + day + "/" + year;;
        if (month < 10) {
            temp = "0" + temp;
        }
        if (day < 10) {
            temp = temp.substring(0, 3) + "0" + temp.substring(3);
        }
        Map<String, String> values = new HashMap<>();
        //Date,Close/Last,Volume,Open,High,Low
        values.put("Close/Last", this.organizeFileInfo().get(temp).get(0));
        values.put("Volume", this.organizeFileInfo().get(temp).get(1));
        values.put("Open", this.organizeFileInfo().get(temp).get(2));
        values.put("High", this.organizeFileInfo().get(temp).get(3));
        values.put("Low", this.organizeFileInfo().get(temp).get(4));
        return values;
    }


    /**
     * This method does the same thing as the previous function, but it takes in a string as the parameter
     * @return an arraylist that contains all the information for the specified date
     */
    public Map<String, String> dayInfo(String date) {
        Map<String, String> values = new HashMap<>();
        //Date,Close/Last,Volume,Open,High,Low
        values.put("Close/Last", this.organizeFileInfo().get(date).get(0));
        values.put("Volume", this.organizeFileInfo().get(date).get(1));
        values.put("Open", this.organizeFileInfo().get(date).get(2));
        values.put("High", this.organizeFileInfo().get(date).get(3));
        values.put("Low", this.organizeFileInfo().get(date).get(4));
        return values;
    }


    /**
     * This method is responsible for checking if there is still information next day from the file
     * @return true if there is a next day, false otherwise
     */
    @Override
    public boolean hasNexyDay() {
        return curYear != 2022 || curMonth != 11 || curDay != 18;
    }


    /**
     * This method is responsible for iterating to the next day when this function is called
     */
    @Override
    public void getNextDay() {
        this.counter++;
        String[] date = this.fileInfo.get(this.counter).substring(0, 10).split("/");
        curYear = Integer.parseInt(date[2]);
        curMonth = Integer.parseInt(date[0]);
        curDay = Integer.parseInt(date[1]);
    }


    /**
     * This function is responsible for moving the current date back by one day
     */
    public void getLastDay() {
        if (curDay == 20 && curMonth == 11 && curYear == 2017) {
            System.out.println("Today is the first day!");
        } else {
            this.counter--;
            String[] date = this.fileInfo.get(this.counter).substring(0, 10).split("/");
            curYear = Integer.parseInt(date[2]);
            curMonth = Integer.parseInt(date[0]);
            curDay = Integer.parseInt(date[1]);
        }

    }
}