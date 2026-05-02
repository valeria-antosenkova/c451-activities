package AddressBook;

import java.util.List;

public class AddressBookView {
    private final UserIO io;

    public AddressBookView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print("\n=== Address Book Menu ===");
        io.print("1. Add Address");
        io.print("2. Remove Address");
        io.print("3. Count Addresses");
        io.print("4. List All Addresses");
        io.print("5. Find Address by Last Name");
        io.print("6. Exit");
        return io.readInt("Enter selection: ", 1, 6);
    }

    public Address getAddressInfoFromUser() {
        String firstName = io.readString("Enter first name: ");
        String lastName  = io.readString("Enter last name: ");
        String street    = io.readString("Enter street: ");
        String city      = io.readString("Enter city: ");
        String state     = io.readString("Enter state: ");
        String zip       = io.readString("Enter zip: ");
        return new Address(firstName, lastName, street, city, state, zip);
    }

    public String getLastNameFromUser() {
        return io.readString("Enter last name: ");
    }

    public void displayAddress(Address address) {
        if (address == null) {
            io.print("No address found.");
        } else {
            io.print(address.toString());
        }
    }

    public void displayAllAddresses(List<Address> addresses) {
        if (addresses.isEmpty()) {
            io.print("No addresses in the book.");
        } else {
            io.print("\n--- All Addresses ---");
            for (Address a : addresses) {
                io.print(a.toString());
            }
        }
    }

    public void displayCount(int count) {
        io.print("Total addresses: " + count);
    }

    public void displayAddedBanner() {
        io.print("Address added successfully.");
    }

    public void displayRemovedBanner(Address removed) {
        if (removed == null) {
            io.print("No address found with that last name.");
        } else {
            io.print("Removed: " + removed);
        }
    }

    public void displayExitBanner() {
        io.print("Goodbye!");
    }

    public void displayErrorMessage(String errorMessage) {
        io.print("ERROR: " + errorMessage);
    }
}

