package DVD;

import java.time.LocalDate;
import java.util.*;
import java.io.*;

public class DVDdaoFileImpl implements DVDdao {
    private Map<String, DVD> dvds = new HashMap<>();
    private static final String DVD_FILE = "dvds.txt";
    private static final String DELIMITER = "::";

    // Converts a DVD object → one line of text for the file
    // e.g. "The Matrix::1999::8.7::Wachowski::Warner Bros::Great film"
    private String marshallDVD(DVD dvd) {
        return dvd.getTitle() + DELIMITER
                + dvd.getReleaseDate().toString() + DELIMITER
                + dvd.getRating() + DELIMITER
                + dvd.getDirector() + DELIMITER
                + dvd.getStudio() + DELIMITER
                + dvd.getUserNote();
    }

    // Converts one line of text from the file → a DVD object
    // Splits the line on DELIMITER and maps each token to a field
    private DVD unmarshallDVD(String line) {
        String[] tokens = line.split(DELIMITER);
        return new DVD(
                tokens[0],                      // title
                LocalDate.parse(tokens[1]),                      // releaseDate
                Double.parseDouble(tokens[2]),  // rating
                tokens[3],                      // director
                tokens[4],                      // studio
                tokens[5]                       // userNote
        );
    }

    // Reads dvds.txt line by line, converts each line to a DVD, loads into the map
    private void loadLibrary() throws DVDDaoException {
        Scanner scanner;
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(DVD_FILE)));
        } catch (FileNotFoundException e) {
            // File doesn't exist yet — just start with an empty library
            return;
        }
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (!line.trim().isEmpty()) {
                DVD dvd = unmarshallDVD(line);
                dvds.put(dvd.getTitle(), dvd);
            }
        }
        scanner.close();
    }

    // Loops through the in-memory map and writes every DVD to dvds.txt
    private void saveLibrary() throws DVDDaoException {
        PrintWriter out;
        try {
            out = new PrintWriter(new FileWriter(DVD_FILE));
        } catch (IOException e) {
            throw new DVDDaoException("Could not save DVD library.", e);
        }
        for (DVD dvd : dvds.values()) {
            out.println(marshallDVD(dvd));
            out.flush();
        }
        out.close();
    }

    @Override
    public DVD addDVD(DVD dvd) throws DVDDaoException {
        loadLibrary();
        DVD previous = dvds.put(dvd.getTitle(), dvd);
        saveLibrary();
        return previous; // returns the old DVD if one existed with same title, otherwise null
    }

    @Override
    public DVD getDVD(String title) throws DVDDaoException {
        loadLibrary();
        return dvds.get(title);
    }

    @Override
    public DVD updateDVD(DVD dvd) throws DVDDaoException {
        loadLibrary();
        DVD updated = dvds.put(dvd.getTitle(), dvd);
        saveLibrary();
        return updated;
    }

    @Override
    public void deleteDVD(String title) throws DVDDaoException {
        loadLibrary();
        dvds.remove(title);
        saveLibrary();
    }

    @Override
    public List<DVD> getDVDs() throws DVDDaoException {
        loadLibrary();
        return new ArrayList<>(dvds.values());
    }
}