package Iterator;

import java.util.*;
import java.io.*;


public class ReadFile {

    // This class is responsible for looping through the given files
    private String fileName;


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


//    public Map<String, ArrayList<String>> organizeFileInfo() {
//        ArrayList<String> fileInfo = this.readFileReverse();
//        Map<String, ArrayList<String>> result = new HashMap<>();
//
//        for (String line: fileInfo) {
//            ArrayList<String> temp = new ArrayList<>();
//            for (int i = 1; i < line.split(",").length; i++) {
//                temp.add(line.split(",")[i]);
//            }
//            result.put(line.split(",")[0], temp);
//        }
//        return result;
//    }


    /**
     * This method will find the information of specified date
     * @return an arraylist that contains all the information for the specified date
     */
    public ArrayList<String> dayInfo(String day) {
        //check and ask to see if we need to check the correctness of import date
        //if yes, check and ask if we do that here or front end.

        return this.organizeFileInfo().get(day);


    }

}