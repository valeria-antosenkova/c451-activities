package DVD;

import java.util.List;

public class DVDController {
    private final DVDdao dao;
    private final DVDView view;

    public DVDController(DVDdao dao, DVDView view) {
        this.dao = dao;
        this.view = view;
    }

    public void run() {
        boolean keepGoing = true;
        while (keepGoing) {
            int selection = view.printMenuAndGetSelection();
            switch (selection) {
                case 1: addDVD();    break;
                case 2: listDVDs();  break;
                case 3: viewDVD();   break;
                case 4: updateDVD(); break;
                case 5: deleteDVD(); break;
                case 6: keepGoing = false; break;
            }
        }
        view.displayExitBanner();
    }

    private void addDVD() {
        DVD dvd = view.getNewDVDInfo();
        try {
            dao.addDVD(dvd);
            view.displayAddSuccessBanner();
        } catch (DVDDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private void listDVDs() {
        try {
            List<DVD> dvds = dao.getDVDs();
            view.displayDVDList(dvds);
        } catch (DVDDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private void viewDVD() {
        String title = view.getTitleChoice();
        try {
            DVD dvd = dao.getDVD(title);
            view.displayDVD(dvd);
        } catch (DVDDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private void updateDVD() {
        DVD dvd = view.getNewDVDInfo();
        try {
            dao.updateDVD(dvd);
            view.displayUpdateSuccessBanner();
        } catch (DVDDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private void deleteDVD() {
        String title = view.getTitleChoice();
        try {
            dao.deleteDVD(title);
            view.displayDeleteSuccessBanner();
        } catch (DVDDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }
}

