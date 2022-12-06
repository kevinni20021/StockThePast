package Iterator;


/**
 * An interface responsible for the class ReadFileCollection
 */
public interface IterableCollection {
    /**
     * This method is responsible for creating an instance of ReadFile
     * @return an instance of an iterator ReadFile
     */
    ReadFile createIterator();
}