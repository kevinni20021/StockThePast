package Iterator;

import java.util.*;
import java.io.*;
public class Test {
    public static void main(String[] args) {
        String name = "Apple";
        //ReadFile read = new ReadFile("./Stocks Data/" + name + ".csv");
        ReadFileCollection rFile = new ReadFileCollection("./Stocks Data/" + name + ".csv");
        ReadFile temp = rFile.createIterator();


//        for (String line: read.readFileReverse()) {
//            System.out.println(line);
//        }
//        for (Map.Entry<String,ArrayList<String>> entry : read.organizeFileInfo().entrySet()) {
//            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
//        }
//        for (Map.Entry<String,ArrayList<String>> entry : temp.organizeFileInfo().entrySet()) {
//            System.out.println("Key = " + entry.getKey() + ", Value for that key = " + temp.dayInfo(temp.curDay, temp.curMonth, temp.curYear));
//        }

        while (temp.hasNexyDay()) {
            System.out.println(temp.curMonth + "/" + temp.curDay + "/" + temp.curYear);
            System.out.println("Value for that key = " + temp.dayInfo(temp.curDay, temp.curMonth, temp.curYear));
            temp.getNextDay();
        }
        System.out.println(temp.curMonth + "/" + temp.curDay + "/" + temp.curYear);
        System.out.println("Value for that key = " + temp.dayInfo(temp.curDay, temp.curMonth, temp.curYear));
//        temp.getLastDay();
//        System.out.println(temp.curMonth + "/" + temp.curDay + "/" + temp.curYear);
//        System.out.println("Value for that key = " + temp.dayInfo(temp.curDay, temp.curMonth, temp.curYear));

    }
}

