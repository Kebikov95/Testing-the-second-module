package directory;

public class Spaces {
    static int count = 0;

    public Spaces() {
        count++;
    }

    public void writeSpaces() {
        for (int i = 0; i < count; i++) {
            System.out.print('\t');
        }
    }

    public String getSpaces() {
        String result = "";
        for (int i = 0; i < count; i++) {
            result += '\t';
        }
        return result;
    }

    public void addCount() {
        count++;
    }

    public void turnDownCount() {
        count--;
    }

    public void setCounterZero() {
        count = 0;
    }
}
