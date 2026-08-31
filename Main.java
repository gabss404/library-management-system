import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            showMenu();
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    registerBook(sc, library);
                    break;
                case 2:
                    registerUser(sc, library);
                    break;
                case 3:
                    borrowBook(sc, library);
                    break;
                case 4:
                    returnBook(sc, library);
                    break;
                case 5:
                    listBooks(library);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        } while (choice != 0);

        sc.close();
    }

    private static void showMenu() {
        System.out.println("\n--- Library ---");
        System.out.println("1 - Register Book");
        System.out.println("2 - Register User");
        System.out.println("3 - Borrow Book");
        System.out.println("4 - Return Book");
        System.out.println("5 - List Books");
        System.out.println("0 - Exit");
        System.out.print("Choose an option: ");
    }

    private static void registerBook(Scanner sc, Library library) {
        System.out.print("Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Title: ");
        String title = sc.nextLine();
        System.out.print("Author: ");
        String author = sc.nextLine();
        library.registerBook(new Book(id, title, author));
        System.out.println("Book registered successfully!");
    }

    private static void registerUser(Scanner sc, Library library) {
        System.out.print("User ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Name: ");
        String name = sc.nextLine();
        library.registerUser(new User(id, name));
        System.out.println("User registered successfully!");
    }

    private static void borrowBook(Scanner sc, Library library) {
        System.out.print("Book ID: ");
        int id = sc.nextInt();
        boolean success = library.borrowBook(id);
        if (success) {
            System.out.println("Book borrowed successfully!");
        } else {
            System.out.println("Could not borrow the book.");
        }
    }

    private static void returnBook(Scanner sc, Library library) {
        System.out.print("Book ID: ");
        int id = sc.nextInt();
        boolean success = library.returnBook(id);
        if (success) {
            System.out.println("Book returned successfully!");
        } else {
            System.out.println("Could not return the book.");
        }
    }

    private static void listBooks(Library library) {
        System.out.println("\nLibrary Books:");
        for (Book book : library.listBooks()) {
            System.out.println(book);
        }
    }
}
