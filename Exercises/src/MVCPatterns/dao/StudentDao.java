package MVCPatterns.dao;

import java.util.List;

// ---------------------------------------------------------------
// This INTERFACE defines what operations are available.
// By coding to an interface, you can swap implementations later
// (e.g., swap in-memory storage for a real database) without
// changing anything in the controller or UI.
// ---------------------------------------------------------------

public interface StudentDao {

    MVCPatterns.Student addStudent(int id, String name, int grade);

    MVCPatterns.Student getStudent(int id);

    List<MVCPatterns.Student> getAllStudents();

    void updateStudent(int id, String name, int grade);

    void removeStudent(int id);
}
