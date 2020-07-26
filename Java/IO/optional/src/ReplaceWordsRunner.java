import java.io.*;

// 2. Read the text of the Java program and replace all the words public
// in the declaration of class attributes and methods with the word private.
public class ReplaceWordsRunner {
    public static void main(String[] args) {
        // Reading file 'Car.java', replace 'private' to 'public', writing in file 'CarReplacer.txt'.
        System.out.println("Replace 'private' to 'public' in class Car:");
        try(BufferedReader br = new BufferedReader(new FileReader("src\\Car.java"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("resources\\CarReplacer.txt"))) {
            String line;
            while((line = br.readLine()) != null) {
                String replaceLine = replaceWords(line, "private", "public");
                bw.write(replaceLine + '\n');
                System.out.println(replaceLine);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String replaceWords(String line, String firstWord, String secondWord) {
        String[] words = line.split(" ");
        for (int i = 0; i < words.length; i++) {
            if(words[i].equals(firstWord)) {
                words[i] = secondWord;
            }
        }
        return String.join(" ", words);
    }
}
