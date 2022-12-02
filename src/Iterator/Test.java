package Iterator;

import java.util.*;
import java.io.*;
public class Test {
    public static void main(String[] args) {
//        ReadFile read = new ReadFile("C:\\Users\\CGOD\\Desktop\\University\\Second year\\First Semester\\CSC207\\StockThePast\\Stocks Data\\Amazon.csv");
//        ReadFile read = new ReadFile("C:\\Users\\CGOD\\Desktop\\University\\Second year\\First Semester\\CSC207\\StockThePast\\Stocks Data\\Apple.csv");
//        ReadFile read = new ReadFile("C:\\Users\\CGOD\\Desktop\\University\\Second year\\First Semester\\CSC207\\StockThePast\\Stocks Data\\Meta.csv");
//        ReadFile read = new ReadFile("C:\\Users\\CGOD\\Desktop\\University\\Second year\\First Semester\\CSC207\\StockThePast\\Stocks Data\\Microsoft.csv");
//        ReadFile read = new ReadFile("C:\\Users\\CGOD\\Desktop\\University\\Second year\\First Semester\\CSC207\\StockThePast\\Stocks Data\\StarBucks.csv");
//        ReadFile read = new ReadFile("C:\\Users\\CGOD\\Desktop\\University\\Second year\\First Semester\\CSC207\\StockThePast\\Stocks Data\\Tesla.csv");

        ReadFile read = new ReadFile("C:\\Users\\mingm\\Desktop\\University\\Second year\\First Semester\\CSC207\\StockThePast\\Stocks Data\\Apple.csv");
        ReadFileCollection rFile = new ReadFileCollection("C:\\Users\\mingm\\Desktop\\University\\Second year\\First Semester\\CSC207\\StockThePast\\Stocks Data\\Apple.csv");
        ReadFile temp = rFile.createIterator();
        //        "C:\\Users\\mingm\\Desktop\\University\\Second year\\First Semester\\CSC207\\StockThePast\\Stocks Data\\"

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

//        String a = "01";
//        System.out.println(Integer.parseInt(a));

    }
}

