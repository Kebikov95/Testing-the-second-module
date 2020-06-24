package university.exceptions;

public class MarkException extends Exception {
    private int mark;

    public MarkException(String message, int mark) {
        super(message);
        this.mark = mark;
    }

    public int getMark() {
        return mark;
    }
}
