package AddressBook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddressBookDaoImpl implements AddressBookDao {
    private final Map<String, Address> addresses = new HashMap<>();

    @Override
    public void addAddress(Address address) {
        addresses.put(address.getLastName().toLowerCase(), address);
    }

    @Override
    public Address removeAddress(String lastName) {
        return addresses.remove(lastName.toLowerCase());
    }

    @Override
    public Address findAddressByLastName(String lastName) {
        return addresses.get(lastName.toLowerCase());
    }

    @Override
    public int getCount() {
        return addresses.size();
    }

    @Override
    public List<Address> getAllAddresses() {
        return new ArrayList<>(addresses.values());
    }
}
