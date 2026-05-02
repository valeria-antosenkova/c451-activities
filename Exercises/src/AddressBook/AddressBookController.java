package AddressBook;

import java.util.List;

public class AddressBookController {
    private final AddressBookDao dao;
    private final AddressBookView view;

    public AddressBookController(AddressBookDao dao, AddressBookView view) {
        this.dao = dao;
        this.view = view;
    }

    public void run() {
        boolean keepGoing = true;
        while (keepGoing) {
            int selection = view.printMenuAndGetSelection();
            switch (selection) {
                case 1 -> addAddress();
                case 2 -> removeAddress();
                case 3 -> countAddresses();
                case 4 -> listAllAddresses();
                case 5 -> findAddressByLastName();
                case 6 -> keepGoing = false;
                default -> view.displayErrorMessage("Unknown selection.");
            }
        }
        view.displayExitBanner();
    }

    private void addAddress() {
        Address address = view.getAddressInfoFromUser();
        dao.addAddress(address);
        view.displayAddedBanner();
    }

    private void removeAddress() {
        String lastName = view.getLastNameFromUser();
        Address removed = dao.removeAddress(lastName);
        view.displayRemovedBanner(removed);
    }

    private void countAddresses() {
        view.displayCount(dao.getCount());
    }

    private void listAllAddresses() {
        List<Address> all = dao.getAllAddresses();
        view.displayAllAddresses(all);
    }

    private void findAddressByLastName() {
        String lastName = view.getLastNameFromUser();
        Address found = dao.findAddressByLastName(lastName);
        view.displayAddress(found);
    }
}

