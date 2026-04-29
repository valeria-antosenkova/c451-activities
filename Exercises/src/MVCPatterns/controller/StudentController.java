package MVCPatterns.controller;

import java.util.List;
import java.util.stream.Collectors;

// ---------------------------------------------------------------
// The Controller is the BRAIN. It sits between the UI and the DAO.
//
// KEY RULES:
//   - It NEVER prints anything (that's the UI's job)
//   - It NEVER touches storage directly (that's the DAO's job)
//   - It DOES contain business logic (like "what counts as passing?")
// ---------------------------------------------------------------

public class StudentController {

    // The controller depends on the DAO interface, NOT the implementation.
    // This is called "coding to an interface" — a big deal in Java.
    private final MVCPatterns.dao.StudentDao dao;

    public StudentController(MVCPatterns.dao.StudentDao dao) {
        this.dao = dao;
    }

    // --- Thin pass-through methods (routing) ---

    public MVCPatterns.Student addStudent(int id, String name, int grade) {
        return dao.addStudent(id, name, grade);
    }

    public MVCPatterns.Student getStudent(int id) {
        return dao.getStudent(id);
    }

    public List<MVCPatterns.Student> getAllStudents() {
        return dao.getAllStudents();
    }

    public void updateStudent(int id, String name, int grade) {
        dao.updateStudent(id, name, grade);
    }

    public void removeStudent(int id) {
        dao.removeStudent(id);
    }

    // --- Business logic methods ---
    // These are where the controller earns its keep.
    // The DAO doesn't know what "passing" means.
    // The UI doesn't decide what "passing" means.
    // The Controller does.

    public boolean isStudentPassing(int id) {
        MVCPatterns.Student s = dao.getStudent(id);
        if (s == null) return false;
        return s.getGrade() >= 60;
    }

    public List<MVCPatterns.Student> getPassingStudents() {
        return dao.getAllStudents().stream()
                .filter(s -> s.getGrade() >= 60)
                .collect(Collectors.toList());
    }

    public List<MVCPatterns.Student> getFailingStudents() {
        return dao.getAllStudents().stream()
                .filter(s -> s.getGrade() < 60)
                .collect(Collectors.toList());
    }

    public double getClassAverage() {
        List<MVCPatterns.Student> all = dao.getAllStudents();
        if (all.isEmpty()) return 0.0;
        int total = 0;
        for (MVCPatterns.Student s : all) {
            total += s.getGrade();
        }
        return (double) total / all.size();
    }
}
