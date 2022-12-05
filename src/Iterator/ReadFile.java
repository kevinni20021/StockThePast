package Iterator;


import java.util.*;
import java.io.*;


public class ReadFile implements Iterator {

    // This class is responsible for looping through the given files
    private String fileName;

    public int curDay = 20;
    public int curMonth = 11;
    public int curYear = 2017;
    private int counter = 0;


    public ReadFile(String fileName) {
        this.fileName = fileName;
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
        return curMonth + "/" + curDay + "/" + curYear;
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

    @Override
    public boolean hasNextDay() {
        return curYear != 2022 || curMonth != 11 || curDay != 18;
    }
    @Override
    public void getNextDay() {
        ArrayList<String> fileInfo = this.readFileReverse();
        this.counter++;
        String[] date = fileInfo.get(this.counter).substring(0, 10).split("/");
        curYear = Integer.parseInt(date[2]);
        curMonth = Integer.parseInt(date[0]);
        curDay = Integer.parseInt(date[1]);
        //System.out.println(curMonth + "/" + curDay + "/" + curYear);
//        // 2017 11 20
//        if (curMonth == 2) {
//            // no Feb 29 in our data
//            if (curDay <= 27 && curDay >= 1) {
//                curDay++;
//            } else {
//                curDay = 1;
//                curMonth++;
//            }
//        } else if (curMonth == 1 || curMonth == 3 || curMonth == 5 || curMonth == 7 || curMonth == 8 || curMonth == 10 || curMonth == 12) {
//            if (curMonth == 12 && curDay == 31) {
//                curMonth = 1;
//                curDay = 1;
//                curYear++;
//            }
//            if (curDay <= 30 && curDay >= 1) {
//                curDay++;
//            } else {
//                curDay = 1;
//                curMonth++;
//            }
//        } else {
//            if (curDay <= 29 && curDay >= 1) {
//                curDay++;
//            } else {
//                curDay = 1;
//                curMonth++;
//            }
//        }
    }
}