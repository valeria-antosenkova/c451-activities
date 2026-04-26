public abstract class BookPublishing {
    private final String workingTitle;  // read-only
    private final String author;        // read-only
    private int wordCount;              // read/write
    private int draftVersion;           // read/write

    public BookPublishing(String workingTitle, String author, int wordCount, int draftVersion) {
        this.workingTitle = workingTitle;
        this.author = author;
        this.wordCount = wordCount;
        this.draftVersion = draftVersion;
    }

    public String getWorkingTitle() {
        return workingTitle;
    }

    public String getAuthor() {
        return author;
    }

    public int getWordCount() {
        return wordCount;
    }

    public void setWordCount(int wordCount) {
        this.wordCount = wordCount;
    }

    public int getDraftVersion() {
        return draftVersion;
    }

    public void setDraftVersion(int draftVersion) {
        this.draftVersion = draftVersion;
    }

    public abstract void addChapter(String title);

    public abstract void reviseDraft();

    public abstract void submitForReview();
}