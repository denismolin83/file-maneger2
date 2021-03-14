import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        FileManager fileManager = new FileManager("D:\\java\\file-maneger2\\root");

        String input = scanner.nextLine();

        while (!input.equals(Commands.EXIT)) {
            String[] token = input.split(" ");
            String command = token[0];

            switch (command) {
                case Commands.LIST_OF_FILES:
                    fileManager.listOfFiles(false);
                    break;
                case Commands.LIST_OF_FILES_WITH_SIZE:
                    fileManager.listOfFiles(true);
                    break;
                case Commands.COPY_FILE:
                    String sourceFile = token[1];
                    String destFile = token[2];
                    fileManager.copyFile(sourceFile, destFile);
                    break;
                case Commands.CREATE_FILE: {
                    String fileName = token[1];
                    fileManager.createFile(fileName);
                    break;
                }
                case Commands.FILE_CONTENT:
                    String fileName = token[1];
                    fileManager.catFile(fileName);
                    break;
                case Commands.CHANGE_DIRECTORY:
                    String folderName = token[1];
                    fileManager.changeFolder(folderName);
                    break;
            }

            input = scanner.nextLine();
        }

    }
}
