import java.util.ArrayList;
import java.util.List;

public class BookCatalog {
    private String isbn;
    private String title;
    private String author;
    private String publisher;
    private int publicationYear;
    private String callNumber;
    private int copiesOwned;
    private int copiesAvailable;
    private List<String> keywords;

    public BookCatalog(String isbn, String title, String author, String publisher,
                       int publicationYear, String callNumber, int copiesOwned) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publicationYear = publicationYear;
        this.callNumber = callNumber;
        this.copiesOwned = Math.max(0, copiesOwned);
        this.copiesAvailable = Math.max(0, copiesOwned);
        this.keywords = new ArrayList<>();
    }

    public boolean checkout() {
        if (copiesAvailable <= 0) {
            return false;
        }
        copiesAvailable--;
        return true;
    }

    public void checkin() {
        if (copiesAvailable < copiesOwned) {
            copiesAvailable++;
        }
    }

    public void addKeyword(String keyword) {
        if (keyword != null && !keyword.isEmpty()) {
            keywords.add(keyword.toLowerCase());
        }
    }

    public boolean matchesSearch(String query) {
        String q = query.toLowerCase();
        if (title.toLowerCase().contains(q) || author.toLowerCase().contains(q) || isbn.contains(q)) {
            return true;
        }
        for (String keyword : keywords) {
            if (keyword.contains(q)) {
                return true;
            }
        }
        return false;
    }
}