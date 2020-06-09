package university.exceptions;

public class EmptyUniversityException extends Exception {
    private int size;

    public EmptyUniversityException(String message, int size) {
        super(message);
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
