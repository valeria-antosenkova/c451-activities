package DVD;

import java.util.List;

public interface DVDdao {
    DVD addDVD(DVD dvd) throws DVDDaoException;

    DVD getDVD(String title) throws DVDDaoException;

    DVD updateDVD(DVD dvd) throws DVDDaoException;

    void deleteDVD(String title) throws DVDDaoException;

    List<DVD> getDVDs() throws DVDDaoException;



}
