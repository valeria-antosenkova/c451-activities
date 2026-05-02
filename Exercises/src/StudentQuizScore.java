import com.sg.classroster.ui.UserIO;
import com.sg.classroster.ui.UserIOConsoleImpl;
import java.util.*;

void main() {
    UserIO io = new UserIOConsoleImpl();
    Map<String, Student> students = new HashMap<>();
    boolean running = true;

    while (running) {
        io.print("\n=== Student Quiz Score System ===");
        io.print("1. View all students");
        io.print("2. Add a student");
        io.print("3. Remove a student");
        io.print("4. View quiz scores for a student");
        io.print("5. View average quiz score for a student");
        io.print("6. Add a quiz score for a student");
        io.print("7. Exit");

        int choice = io.readInt("Select an option: ", 1, 7);

        switch (choice) {
            case 1 -> {
                if (students.isEmpty()) {
                    io.print("No students in the system.");
                } else {
                    io.print("\n--- Students ---");
                    students.keySet().forEach(io::print);
                }
            }
            case 2 -> {
                String name = io.readString("Enter student name: ").trim();
                if (name.isEmpty()) {
                    io.print("Name cannot be blank.");
                } else if (students.containsKey(name)) {
                    io.print("Student already exists.");
                } else {
                    students.put(name, new Student(name));
                    io.print(name + " added.");
                }
            }
            case 3 -> {
                String name = io.readString("Enter student name to remove: ").trim();
                if (students.remove(name) != null) {
                    io.print(name + " removed.");
                } else {
                    io.print("Student not found.");
                }
            }
            case 4 -> {
                String name = io.readString("Enter student name: ").trim();
                Student s = students.get(name);
                if (s == null) {
                    io.print("Student not found.");
                } else if (s.getScores().isEmpty()) {
                    io.print(name + " has no quiz scores yet.");
                } else {
                    io.print("Quiz scores for " + name + ": " + s.getScores());
                }
            }
            case 5 -> {
                String name = io.readString("Enter student name: ").trim();
                Student s = students.get(name);
                if (s == null) {
                    io.print("Student not found.");
                } else if (s.getScores().isEmpty()) {
                    io.print(name + " has no quiz scores yet.");
                } else {
                    double avg = s.getScores().stream()
                            .mapToInt(Integer::intValue)
                            .average()
                            .orElse(0);
                    io.print(String.format("Average score for %s: %.2f", name, avg));
                }
            }
            case 6 -> {
                String name = io.readString("Enter student name: ").trim();
                Student s = students.get(name);
                if (s == null) {
                    io.print("Student not found.");
                } else {
                    int score = io.readInt("Enter quiz score (0-100): ", 0, 100);
                    s.addScore(score);
                    io.print("Score added.");
                }
            }
            case 7 -> {
                running = false;
                io.print("Goodbye!");
            }
        }
    }
}

class Student {
    private final String name;
    private final List<Integer> scores = new ArrayList<>();

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addScore(int score) {
        scores.add(score);
    }

    public List<Integer> getScores() {
        return Collections.unmodifiableList(scores);
    }

    @Override
    public String toString() {
        return name;
    }
}