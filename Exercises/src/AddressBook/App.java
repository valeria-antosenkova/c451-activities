package AddressBook;

public class App {
    public static void main(String[] args) {
        UserIO io = new UserIOConsoleImpl();
        AddressBookDao dao = new AddressBookDaoImpl();
        AddressBookView view = new AddressBookView(io);
        AddressBookController controller = new AddressBookController(dao, view);
        controller.run();
    }
}

