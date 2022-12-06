package Iterator;


/**
 * A class responsible for creating the iteration
 */
public class ReadFileCollection implements IterableCollection{
    private String fileName;


    /**
     * this constructor is responsible for getting the file name when this class is called
     * @param fileName the file name that the user wants to read
     */
    public ReadFileCollection (String fileName) {
        this.fileName = fileName;
    }


    /**
     * This method is responsible for creating an instance of ReadFile
     * @return an instance of an iterator ReadFile
     */
    @Override
    public ReadFile createIterator() {
        return new ReadFile(fileName);
    }
}