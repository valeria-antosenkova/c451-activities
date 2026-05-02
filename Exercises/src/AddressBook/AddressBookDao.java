package AddressBook;

import java.util.List;

public interface AddressBookDao {
    void addAddress(Address address);
    Address removeAddress(String lastName);
    Address findAddressByLastName(String lastName);
    int getCount();
    List<Address> getAllAddresses();
}
