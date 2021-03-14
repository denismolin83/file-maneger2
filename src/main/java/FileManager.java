import org.apache.commons.io.FileUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileManager {

    private String currentFolder;
    private String root;

    public FileManager(String currentFolder) {
        this.currentFolder = currentFolder;
        this.root = currentFolder;
    }

    public void listOfFiles (boolean whitSize) {
        File currentFolderAsFile = new File(currentFolder);

        File[] files = currentFolderAsFile.listFiles();

        for (File file: files) {

            if (file.isDirectory()) {
                if (whitSize) {
                    System.out.println(file.getName() + "\\ " + FileUtils.sizeOfDirectory(file));
                } else {
                    System.out.println(file.getName() + "\\");
                }
            } else {
                if (whitSize) {
                    System.out.println(file.getName() + " " + file.length());
                } else {
                    System.out.println(file.getName());
                }
            }

        }
    }


    public void copyFile(String sourceFile, String destFile) {
        File source = new File(currentFolder + "\\" + sourceFile);
        File dest = new File(currentFolder + "\\" + destFile);


        try {
            FileUtils.copyFile(source, dest);
        } catch (IOException e) {
            System.err.println("Ошибка :(");
        }
    }

    public void createFile(String fileName) {
        File source = new File(currentFolder + "\\" + fileName);

        try {
            FileUtils.touch(source);
        } catch (IOException e) {
            System.err.println("Ошибка :(");
        }

    }

    public void catFile(String fileName) {
        File file = new File(currentFolder + "\\" + fileName);

        try {
        BufferedReader reader = new BufferedReader(new FileReader(file));


            String line = reader.readLine();

            while (line!=null) {
                System.out.println(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.err.println("Ошибка :(");
        }


    }

    public void changeFolder(String folderName) {
        //cd ..
        //cd /
        //cd name

        if (folderName.equals("/")) {
            this.currentFolder = root;
        } else if (folderName.equals("..")) {
            int startLastFolderPosition = this.currentFolder.lastIndexOf("\\");
            this.currentFolder = this.currentFolder.substring(0, startLastFolderPosition);
        } else {
            this.currentFolder = this.currentFolder + "\\" + folderName;
        }

    }
}
