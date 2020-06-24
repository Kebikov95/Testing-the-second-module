import java.io.*;

// 3. Read the text of the Java program and write the characters of each line in another file in the reverse order.
public class ReverseLineRunner {
    public static void main(String[] args) {
        // Reading file 'Car.java', reverse reading line, writing in file 'CarReverse.txt'.
        try(BufferedReader br = new BufferedReader(new FileReader("src\\Car.java"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("resources\\CarReverse.txt"))) {
            String line;
            while((line = br.readLine()) != null) {
                StringBuilder sb = new StringBuilder(line);
                String reverseLine  = sb.reverse().toString();
                bw.write(reverseLine + '\n');
                System.out.println(reverseLine);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
