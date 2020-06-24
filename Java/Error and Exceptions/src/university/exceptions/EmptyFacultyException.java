package university.exceptions;

public class EmptyFacultyException extends Exception {
    private int size;

    public EmptyFacultyException(String message, int size) {
        super(message);
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
