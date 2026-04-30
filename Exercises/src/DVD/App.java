package DVD;

public class App {
    public static void main(String[] args) {
        DVDdao dao = new DVDdaoFileImpl();
        DVDView view = new DVDView();
        DVDController controller = new DVDController(dao, view);
        controller.run();
    }
}

