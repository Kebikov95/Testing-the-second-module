package directory;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class DirectoryManager {
    private String path;
    private String folderName;
    private ArrayList<String> folders;
    private ArrayList<String> files;
    private BufferedWriter bufferedWriter;
    private final String bufferPath = "resources\\buffer.txt";

    public DirectoryManager(String path) throws IOException {
        this.path = path;
        this.folderName = "";
        this.folders = new ArrayList<>();
        this.files = new ArrayList<>();
        this.bufferedWriter = new BufferedWriter(new FileWriter(bufferPath));
        read();
    }

    public String getPath() {
        return path;
    }

    public String getFolderName() {
        return folderName;
    }

    public ArrayList<String> getFolders() {
        return folders;
    }

    public ArrayList<String> getFiles() {
        return files;
    }

    public BufferedWriter getBufferedWriter() {
        return bufferedWriter;
    }

    // The method for writing list of files.
    public void write(String outputPath) throws IOException {
        if (new File(path).isFile()) {
            fileWriter(outputPath);
        } else {
            folderWriter(outputPath);
            changePath(outputPath);
        }
    }

    // The method for writing directory list of files in buffer or output file.
    private void folderWriter(String outputPath) {
        try(BufferedReader br = new BufferedReader(new FileReader(bufferPath));
        BufferedWriter bw = new BufferedWriter(new FileWriter(outputPath))) {
            String line;
            while((line = br.readLine()) != null) {
                bw.write(line + '\n');
            }
            System.out.printf("File '%s' has been written in '%s'.\n", path, outputPath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // The method for writing in file.
    private void fileWriter(String outputPath) {
        try(BufferedReader br = new BufferedReader(new FileReader(path));
            BufferedWriter bw = new BufferedWriter(new FileWriter(outputPath))) {
            String line;
            while((line = br.readLine()) != null) {
                bw.write(line + '\n');
            }
            System.out.printf("File '%s' has been written in '%s'.\n", path, outputPath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // The method for reading files and folders.
    private void read() throws IOException {
        if (new File(path).isFile()) {
            fileRead();
        } else {
            String arr[] = path.split("\\\\");
            bufferedWriter.write(arr[arr.length - 1] + '\n');
            //            System.out.println(arr[arr.length - 1]);
            bufferedWriter.flush();
            foldersReader(path);
        }
    }

    // The method for reading the folder.
    private void foldersReader(String path) throws IOException {
        Spaces spacesLine = new Spaces();
        File file = new File(path);
        File[] files = file.listFiles();
        sortTypeOfFiles(files);
        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile()) {
                spacesLine.writeSpaces();
                bufferedWriter.write(spacesLine.getSpaces() + "|       " + files[i].getName() + '\n');
            } else {
                if(i != 0)
                    spacesLine.turnDownCount();
                spacesLine.writeSpaces();
                bufferedWriter.write(spacesLine.getSpaces() + "|-----" + files[i].getName() + '\n');
                foldersReader(files[i].getAbsolutePath());
            }
        }
        bufferedWriter.flush();
    }

    // The method for reading the file.
    private void fileRead() {
        try(BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            int count = 0;

            while((line = br.readLine()) != null) {
                System.out.println(line);
                if(count == 0) {
                    folderName = line;
                } else {
                    if(line.contains("|-----"))
                        folders.add(line.trim().substring(6));
                    else if(line.contains("|       "))
                        files.add(line.trim().substring(8));
                    else if(line.contains("       "))
                        files.add(line.trim());
                    else
                        if(!line.trim().equals("|")) {
                            throw new Exception("Invalid data type passed " + line);
                        }
                }
                count++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // The method used to change the path to a directory.
    public void changePath(String path) throws IOException {
        DirectoryManager directoryManager = new DirectoryManager(path);
        this.path = directoryManager.path;
        this.folderName = directoryManager.getFolderName();
        this.folders = directoryManager.getFolders();
        this.files = directoryManager.getFiles();
    }

    // The method for sorting folders and files.
    public void sortTypeOfFiles(File[] files) {
        Arrays.sort( files, new Comparator<File>() {
            public int compare( File a, File b ) {
                int fileType1 = a.isDirectory() ? 1 : 0;
                int fileType2 = b.isDirectory() ? 1 : 0;
                return fileType1 - fileType2;
            }
        });
    }

    // The method returns quantity of folders in the specified directory.
    public int getQuantityFolders() {
        return folders.size();
    }

    // The method returns quantity of files in the specified directory.
    public int getQuantityFiles() {
        return files.size();
    }

    // The method returns average value of the files in the folder of the specified directory.
    public double getAverageValueOfFilesInDirectory() {
        return (double) getQuantityFiles() / getQuantityFolders();
    }

    // The method returns average value of the length of files in the specified directory.
    public double getAverageValueOfFilesWordsLength() {
        int sum = 0;
        for (String line : files) {
            sum += line.length();
        }
        return (double) sum / files.size();
    }
}
