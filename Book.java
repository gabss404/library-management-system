public class Book {
    private String title;
    private String author;
    private int id;
    private boolean borrowed;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.borrowed = false;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getId() { return id; }
    public boolean isBorrowed() { return borrowed; }

    public boolean borrow() {
        if (borrowed) return false;
        this.borrowed = true;
        return true;
    }

    public boolean giveBack() {
        if (!borrowed) return false;
        this.borrowed = false;
        return true;
    }

    @Override
    public String toString() {
        String status = borrowed ? "Borrowed" : "Available";
        return String.format(
            "ID: %d | Title: %s | Author: %s | Status: %s",
            id, title, author, status
        );
    }
}
