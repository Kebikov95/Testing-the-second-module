import directory.DirectoryManager;

import java.io.IOException;

/*
*   A program that receives a directory path as an argument,
* which writes the directory structure to a text file.
*   If, as a parameter, the program does not pass the path to the directory,
* but the path to the txt file as described above,
* read the file and display the following data in the console:
    - The number of folders;
    - Number of files;
    - The average number of files in a folder;
    - The average length of the file name.
*/
public class Main {
    public static void main(String[] args) {
        String pathToFolder = "C:\\DRIVERS";
        DirectoryManager manager = null;
        try {
            manager = new DirectoryManager(pathToFolder);
            manager.write("resources\\fileConsist.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Folder name: " + manager.getFolderName());
        System.out.println("Folders size: " + manager.getQuantityFolders());
        System.out.println("Files size: " + manager.getQuantityFiles());
        System.out.printf("Average value of files in folders: %.2f\n", manager.getAverageValueOfFilesInDirectory());
        System.out.printf("Average value of words files length in directory: %.2f\n", manager.getAverageValueOfFilesWordsLength());
        System.out.println("\n");

        String pathToFile = "resources\\file.txt";
        try {
            manager = new DirectoryManager(pathToFile);
            manager.write("resources\\fileConsist.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Folder name: " + manager.getPath());
        System.out.println("Folders size: " + manager.getQuantityFolders());
        System.out.println("Files size: " + manager.getQuantityFiles());
        System.out.printf("Average value of files in folders: %.2f\n", manager.getAverageValueOfFilesInDirectory());
        System.out.printf("Average value of words files length in directory: %.2f\n", manager.getAverageValueOfFilesWordsLength());
    }
}
