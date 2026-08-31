import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<User> users;

    public Library() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public void registerBook(Book book) {
        books.add(book);
    }

    public void registerUser(User user) {
        users.add(user);
    }

    private Book findBookById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    public boolean borrowBook(int bookId) {
        Book book = findBookById(bookId);
        if (book == null || book.isBorrowed()) {
            return false;
        }
        book.borrow();
        return true;
    }

    public boolean returnBook(int bookId) {
        Book book = findBookById(bookId);
        if (book == null || !book.isBorrowed()) {
            return false;
        }
        book.giveBack();
        return true;
    }

    public ArrayList<Book> listBooks() {
        return books;
    }
}
