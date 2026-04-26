public abstract class BookCatalog {
    private final String isbn;          // read-only
    private String title;               // read/write
    private String author;              // read/write
    private int copiesAvailable;        // read/write

    public BookCatalog(String isbn, String title, String author, int copiesAvailable) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.copiesAvailable = copiesAvailable;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getCopiesAvailable() {
        return copiesAvailable;
    }

    public void setCopiesAvailable(int copiesAvailable) {
        this.copiesAvailable = copiesAvailable;
    }

    public abstract boolean checkout();

    public abstract void checkin();

    public abstract boolean matchesQuery(String query);
}