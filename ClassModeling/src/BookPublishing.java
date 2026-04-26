public class BookPublishing {
    private String workingTitle;
    private String author;
    private String genre;
    private int wordCount;
    private int chapterCount;
    private int draftVersion;
    private boolean submittedToPublisher;
    private StringBuilder manuscript;

    public BookPublishing(String workingTitle, String author, String genre) {
        this.workingTitle = workingTitle;
        this.author = author;
        this.genre = genre;
        this.wordCount = 0;
        this.chapterCount = 0;
        this.draftVersion = 1;
        this.submittedToPublisher = false;
        this.manuscript = new StringBuilder();
    }

    public void addChapter(String chapterText, int words) {
        manuscript.append(chapterText).append("\n\n");
        chapterCount++;
        wordCount += Math.max(0, words);
    }

    public void reviseDraft(String updatedText, int newWordCount) {
        manuscript = new StringBuilder(updatedText);
        wordCount = Math.max(0, newWordCount);
        draftVersion++;
        submittedToPublisher = false;
    }

    public void submitToPublisher() {
        submittedToPublisher = true;
    }

    public int estimateReadingTimeMinutes() {
        int wordsPerMinute = 250;
        return Math.max(1, (int) Math.ceil(wordCount / (double) wordsPerMinute));
    }
}