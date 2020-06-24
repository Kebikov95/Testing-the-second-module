import java.io.*;

// 4. Read the text of the Java program and in each word longer than two characters,
// replace all lowercase characters with uppercase.
public class ReplaceSymbolsRunner {
    public static void main(String[] args) {
        // Reading file Car.java, replace all lowercase characters with uppercase in words where length
        // more than two, write lines in file 'CarUpperCase.txt'.
        try(BufferedReader br = new BufferedReader(new FileReader("src\\Car.java"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("resources\\CarUpperCase.txt"))) {
            String line;
            while((line = br.readLine()) != null){
                String[] array = line.split(" ");
                for (int i = 0; i < array.length; i++) {
                    if(array[i].length() > 2) array[i] = array[i].toUpperCase();
                }
                line = String.join(" ", array);
                bw.write(line + "\n");
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
