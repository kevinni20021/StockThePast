package Iterator;


/**
 * An interface responsible for the class ReadFile
 */
public interface Iterator {
    /**
     * This method is responsible for checking if there is still information next day from the file
     * @return true if there is a next day, false otherwise
     */
    boolean hasNextDay();


    /**
     * This method is responsible for iterating to the next day when this function is called
     */
    void getNextDay();
}