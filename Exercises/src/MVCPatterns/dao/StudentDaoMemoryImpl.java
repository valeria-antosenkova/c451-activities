package MVCPatterns.dao;

import java.util.ArrayList;
import java.util.List;

// ---------------------------------------------------------------
// This is the IMPLEMENTATION of the DAO interface.
// Right now it uses a simple HashMap. Later you could write a
// "StudentDaoDbImpl" that uses JDBC/MySQL and swap it in —
// nothing else in the project would need to change.
// ---------------------------------------------------------------

public class StudentDaoMemoryImpl implements StudentDao {

    // Our "database" — just a list in memory
    private final List<MVCPatterns.Student> students = new ArrayList<>();

    @Override
    public MVCPatterns.Student addStudent(int id, String name, int grade) {
        MVCPatterns.Student student = new MVCPatterns.Student(id, name, grade);
        students.add(student);
        return student;
    }

    @Override
    public MVCPatterns.Student getStudent(int id) {
        for (MVCPatterns.Student s : students) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null; // not found
    }

    @Override
    public List<MVCPatterns.Student> getAllStudents() {
        // Return a copy so outside code can't mess with our list
        return new ArrayList<>(students);
    }

    @Override
    public void updateStudent(int id, String name, int grade) {
        for (MVCPatterns.Student s : students) {
            if (s.getId() == id) {
                s.setName(name);
                s.setGrade(grade);
                return;
            }
        }
    }

    @Override
    public void removeStudent(int id) {
        students.removeIf(s -> s.getId() == id);
    }
}
