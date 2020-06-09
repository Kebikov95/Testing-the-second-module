package university.exceptions;

public class EmptyGroupException extends Exception {
    private int size;

    public EmptyGroupException(String message, int size) {
        super(message);
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
