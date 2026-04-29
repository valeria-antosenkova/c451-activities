package MVCPatterns;

import MVCPatterns.dao.StudentDao;
import MVCPatterns.dao.StudentDaoMemoryImpl;
import MVCPatterns.controller.StudentController;
import MVCPatterns.ui.StudentView;

// ---------------------------------------------------------------
// App.java — The entry point. This is where you WIRE everything.
//
// Notice the order:
//   1. Create the DAO        (data layer)
//   2. Inject it into the Controller  (logic layer)
//   3. Inject the Controller into the View  (UI layer)
//   4. Start the View
//
// This is called DEPENDENCY INJECTION — you pass each layer
// the thing it depends on, rather than letting it create its own.
// ---------------------------------------------------------------

public class App {

    public static void main(String[] args) {

        // 1. Choose your DAO implementation
        //    Swap this line to switch from memory to a database!
        StudentDao dao = new StudentDaoMemoryImpl();

        // 2. Create the controller, give it the DAO
        StudentController controller = new StudentController(dao);

        // 3. Create the view, give it the controller
        StudentView view = new StudentView(controller);

        // 4. Launch!
        view.run();
    }
}
