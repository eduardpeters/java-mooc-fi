
import java.util.ArrayList;
import java.util.Scanner;

public class mainProgram {
    
    public static void main(String[] args) {
        // NB! Do not create other scanner objects than the one below
        // if and when you create other classes, pass the scanner to them
        // as a parameter

        Scanner scan = new Scanner(System.in);
        BirdDatabase birdDB = new BirdDatabase();
        
        while (true) {
            System.out.print("? ");
            String command = scan.nextLine();
            
            if (command.equals("Quit")) {
                break;
            }
            
            if (command.equals("Add")) {
                System.out.print("Name: ");
                String commonName = scan.nextLine();
                System.out.print("Name in Latin: ");
                String latinName = scan.nextLine();
                
                birdDB.addEntry(new Bird(commonName, latinName));
            } else if (command.equals("Observation")) {
                System.out.print("Bird? ");
                String commonName = scan.nextLine();
                
                if (!birdDB.addObservation(commonName)) {
                    System.out.println("Not a bird!");
                }
            } else if (command.equals("All")) {
                for (BirdEntry entry : birdDB.get()) {
                    System.out.println(entry);
                }
            } else if (command.equals("One")) {
                System.out.print("Bird? ");
                String commonName = scan.nextLine();
                
                System.out.println(birdDB.get(commonName));
            }
            
        }
    }
    
}
