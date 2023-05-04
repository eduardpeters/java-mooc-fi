package application;

import java.sql.SQLException;
import java.util.Scanner;

public class UserInterface {

    private Scanner scanner;
    private TodoDao database;

    public UserInterface(Scanner scanner, TodoDao database) {
        this.scanner = scanner;
        this.database = database;
    }

    public void start() throws SQLException {
        while (true) {
            System.out.println("");
            System.out.println("Enter command:");
            System.out.println("1) list");
            System.out.println("2) add");
            System.out.println("3) mark as done");
            System.out.println("4) remove");
            System.out.println("x) quit");

            System.out.print("> ");
            String command = this.scanner.nextLine();
            if (command.equals("x")) {
                break;
            }

            int selection;
            try {
                selection = Integer.valueOf(command);
            } catch (Exception e) {
                selection = -1;
            }
            // implement the functionality here
            switch (selection) {
                case 1:
                    listTodos();
                    break;
                case 2:
                    addTodo();
                    break;
                case 3:
                    markDone();
                    break;
                case 4:
                    removeTodo();
                    break;
                default:
                    break;
            }
        }

        System.out.println("Thank you!");
    }
    
    private void listTodos() throws SQLException {
        System.out.println("Listing the database contents");
        for (Todo toDo : database.list()) {
            System.out.println(toDo);
        }
    }
    
    private void addTodo() throws SQLException {
        System.out.println("Adding a new todo");
        
        System.out.println("Enter name");
        String name = scanner.nextLine();
        System.out.println("Enter description");
        String description = scanner.nextLine();
        
        database.add(new Todo(name, description, false));
    }
    
    private void markDone() throws SQLException {
        System.out.println("Which todo should be marked as done (give the id)?");
        
        int id = Integer.valueOf(scanner.nextLine());
        database.markAsDone(id);
    }
    
     private void removeTodo() throws SQLException {
        System.out.println("Which todo should be removed (give the id)?");
        
        int id = Integer.valueOf(scanner.nextLine());
        database.remove(id);
    }

}
