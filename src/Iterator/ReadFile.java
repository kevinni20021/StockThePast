package Iterator;


import java.util.*;
import java.io.*;


public class ReadFile implements Iterator{

    // This class is responsible for looping through the given files
    private String fileName;

    private int curDay = 20;
    private int curMonth = 11;
    private int curYear = 2017;


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
    public ArrayList<String> dayInfo(String day) {
        //check and ask to see if we need to check the correctness of import date
        //if yes, check and ask if we do that here or front end.

        return this.organizeFileInfo().get(day);


    }

    @Override
    public boolean hasNexyDay() {
        return curYear != 2022 || curMonth != 11 || curDay != 18;
    }
    @Override
    public void getNextDay() {
        // 2017 11 20
        if (curMonth == 2) {
            // no Feb 29 in our data
            if (curDay <= 27 && curDay >= 1) {
                curDay++;
            } else {
                curDay = 1;
                curMonth++;
            }
        } else if (curMonth == 1 || curMonth == 3 || curMonth == 5 || curMonth == 7 || curMonth == 8 || curMonth == 10 || curMonth == 12) {
            if (curMonth == 12 && curDay == 31) {
                curMonth = 1;
                curDay = 1;
                curYear++;
            }
            if (curDay <= 30 && curDay >= 1) {
                curDay++;
            } else {
                curDay = 1;
                curMonth++;
            }
        } else {
            if (curDay <= 29 && curDay >= 1) {
                curDay++;
            } else {
                curDay = 1;
                curMonth++;
            }
        }
    }
}