import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

// 1. Create and populate the file with random integers.
// Sort the contents of the file in ascending order.
public class RandomNumberRunner {
    public static void main(String[] args) {
        // Write random numbers in 'random.bin'.
        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream("resources\\random.bin"))) {
            System.out.println("Write numbers:");
            for (int i = 0; i < 10; i++) {
                int number = getRandomNumber();
                dos.writeInt(number);
                System.out.print(number + "\t");
            }
            dos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Read random numbers from file random.bin.
        ArrayList<Integer> numbers = new ArrayList<>();
        try(DataInputStream dis = new DataInputStream(new FileInputStream("resources\\random.bin"))) {
            while(dis.available() != 0) {
                numbers.add(dis.readInt());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Sort and output numbers to the console.
        System.out.println("\nRead numbers:\n" + numbers);
        numbers.sort(Comparator.naturalOrder());
        System.out.println("Sort numbers:\n" + numbers);

        // Write sort numbers in 'random_sort.bin'.
        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream("resources\\random_sort.bin"))) {
            for (int number : numbers) {
                dos.writeInt(number);
            }
            dos.flush();
            System.out.println("Sort numbers have been written in 'random_sort.bin'.");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method for generating numbers from 0 to 99.
    static int getRandomNumber() {
        int maxValue = 100;
        return ((int)(Math.random() * maxValue));
    }
}
