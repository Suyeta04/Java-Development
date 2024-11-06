import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class NoteTakingApp
 {
    private static Map<String, String> notes = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) 
    {
        boolean running = true;
        while (running) 
        {
            System.out.println("1. Create a new note");
            System.out.println("2. View existing notes");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            switch (choice) 
            {
                case 1:
                    createNote();
                    break;
                case 2:
                    viewNotes();
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        System.out.println("Thank you for using the note-taking app!");
    }
    private static void createNote() 
    {
        System.out.print("Enter the title of the note: ");
        String title = scanner.nextLine();
        System.out.print("Enter the content of the note: ");
        String content = scanner.nextLine();
        notes.put(title, content);
        System.out.println("Note created successfully!");
    }
    private static void viewNotes() 
    {
        if (notes.isEmpty()) 
        {
            System.out.println("No notes available.");
        } else 
        {
            System.out.println("Existing notes:");
            for (Map.Entry<String, String> entry : notes.entrySet()) {
                System.out.println("Title: " + entry.getKey());
                System.out.println("Content: " + entry.getValue());
                System.out.println("----------------------");
            }
        }
    }
}