import java.io.*;
import java.util.Scanner;
public class Main {

        private static final String FILE_NAME = "notes.txt";
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            while(true){
                System.out.println("\n1.Add notes");
                System.out.println("2.Read notes");
                System.out.println("3.Exit");
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        addNote(sc);
                        break;
                    case 2:
                        readNote();
                        break;
                    case 3:
                        System.out.println("Exit Bye!");
                        break;
                    default:
                        System.out.println("Wrong choice!");
                }
            }
        }

private static void addNote(Scanner sc) {
    System.out.print("Enter note: ");
    String note = sc.nextLine();
    sc.nextLine();
    try(BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true))){
        bw.write(note);
        bw.newLine();
        System.out.println("Note added successfully!");
    } catch (IOException e) {
        System.out.println("Error writing to file!");
    }
}
private  static void readNote() {
    File file = new File(FILE_NAME);
    if (!file.exists()) {
        System.out.println("File does not exist!");
        return;
    }
    try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
        String line;
        System.out.println("......notes..... ");
        while ((line = br.readLine()) != null) {
            System.out.println(line);}
        }catch(IOException e){
            System.out.println("Error reading file!");
        }
    }
}