import java.io.*;
import java.util.Scanner;

public class FileHandlingUtility {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("FILE HANDLING UTILITY");
        System.out.println("1. Read a file");
        System.out.println("2. Write to a file");
        System.out.println("3. Append to a file");
        System.out.println("4. Exit");
        
        boolean running = true;
        
        while (running) {
            System.out.print("\nEnter your choice (1-4): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    readFile(scanner);
                    break;
                case 2:
                    writeFile(scanner);
                    break;
                case 3:
                    appendFile(scanner);
                    break;
                case 4:
                    running = false;
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        
        scanner.close();
    }
    
    /**
     * Reads and displays the contents of a file
     * @param scanner Scanner object for user input
     */
    private static void readFile(Scanner scanner) {
        System.out.print("Enter the file path to read: ");
        String filePath = scanner.nextLine();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            System.out.println("\nFile contents:");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
    
    /**
     * Writes content to a file (overwrites existing content)
     * @param scanner Scanner object for user input
     */
    private static void writeFile(Scanner scanner) {
        System.out.print("Enter the file path to write: ");
        String filePath = scanner.nextLine();
        
        System.out.println("Enter the content to write (type 'END' on a new line to finish):");
        StringBuilder content = new StringBuilder();
        String line;
        while (!(line = scanner.nextLine()).equalsIgnoreCase("END")) {
            content.append(line).append("\n");
        }
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content.toString());
            System.out.println("Content successfully written to file.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
    
    /**
     * Appends content to an existing file
     * @param scanner Scanner object for user input
     */
    private static void appendFile(Scanner scanner) {
        System.out.print("Enter the file path to append: ");
        String filePath = scanner.nextLine();
        
        System.out.println("Enter the content to append (type 'END' on a new line to finish):");
        StringBuilder content = new StringBuilder();
        String line;
        while (!(line = scanner.nextLine()).equalsIgnoreCase("END")) {
            content.append(line).append("\n");
        }
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(content.toString());
            System.out.println("Content successfully appended to file.");
        } catch (IOException e) {
            System.out.println("Error appending to file: " + e.getMessage());
        }
    }
}
