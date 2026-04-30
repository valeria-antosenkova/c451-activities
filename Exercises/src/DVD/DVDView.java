package DVD;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class DVDView {
    private final Scanner scanner = new Scanner(System.in);

    // ========================
    //  MENU
    // ========================

    public int printMenuAndGetSelection() {
        System.out.println("=== DVD Library ===");
        System.out.println("1. Add a DVD");
        System.out.println("2. List all DVDs");
        System.out.println("3. View a DVD");
        System.out.println("4. Update a DVD");
        System.out.println("5. Delete a DVD");
        System.out.println("6. Exit");
        return readInt("Please select: ", 1, 6);
    }

    // ========================
    //  INPUT COLLECTION
    // ========================

    public DVD getNewDVDInfo() {
        String title      = readString("Title: ");
        LocalDate released = LocalDate.parse(readLocalDate("Release Date (YYYY-MM-DD): "));        double rating     = readDouble("Rating (0.0 - 10.0): ", 0.0, 10.0);
        String director   = readString("Director: ");
        String studio     = readString("Studio: ");
        String note       = readString("Your note: ");
        return new DVD(title, released, rating, director, studio, note);
    }

    public String getTitleChoice() {
        return readString("Enter DVD title: ");
    }

    // ========================
    //  DISPLAY
    // ========================

    public void displayDVD(DVD dvd) {
        if (dvd == null) {
            System.out.println("DVD not found.");
        } else {
            System.out.println("--- DVD Details ---");
            System.out.println("Title:        " + dvd.getTitle());
            System.out.println("Released:     " + dvd.getReleaseDate());
            System.out.println("Rating:       " + dvd.getRating());
            System.out.println("Director:     " + dvd.getDirector());
            System.out.println("Studio:       " + dvd.getStudio());
            System.out.println("Your note:    " + dvd.getUserNote());
        }
        readString("\nPress Enter to continue.");
    }

    public void displayDVDList(List<DVD> dvds) {
        System.out.println("--- All DVDs ---");
        if (dvds.isEmpty()) {
            System.out.println("No DVDs in library.");
        } else {
            for (DVD dvd : dvds) {
                System.out.printf("%-35s | %s | Rating: %.1f%n",
                        dvd.getTitle(), dvd.getReleaseDate(), dvd.getRating());
            }
        }
        readString("\nPress Enter to continue.");
    }

    public void displayAddSuccessBanner()    { System.out.println("DVD successfully added."); }
    public void displayUpdateSuccessBanner() { System.out.println("DVD successfully updated."); }
    public void displayDeleteSuccessBanner() { System.out.println("DVD successfully deleted."); }
    public void displayErrorMessage(String msg) {
        System.out.println("=== ERROR ===");
        System.out.println(msg);
    }
    public void displayExitBanner() { System.out.println("Goodbye!"); }

    // ========================
    //  HELPERS
    // ========================

    private String readString(String prompt) {
        System.out.print(prompt);
        System.out.flush();
        return scanner.nextLine();
    }

    private String readLocalDate(String prompt) {
        System.out.print(prompt);
        System.out.flush();
        return scanner.nextLine();
    }

    private int readInt(String prompt, int min, int max) {
        while (true) {
            try {
                int val = Integer.parseInt(readString(prompt));
                if (val >= min && val <= max) return val;
                System.out.println("Please enter a number between " + min + " and " + max + ".");
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Try again.");
            }
        }
    }

    private double readDouble(String prompt, double min, double max) {
        while (true) {
            try {
                double val = Double.parseDouble(readString(prompt));
                if (val >= min && val <= max) return val;
                System.out.println("Please enter a value between " + min + " and " + max + ".");
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Try again.");
            }
        }
    }
}

