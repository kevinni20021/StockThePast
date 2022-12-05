package Iterator;

public class ReadFileCollection implements IterableCollection {
    private String fileName;
    public ReadFileCollection (String fileName) {
        this.fileName = fileName;
    }
    @Override
    public ReadFile createIterator() {
        return new ReadFile(fileName);
    }
}