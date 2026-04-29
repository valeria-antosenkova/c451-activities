package MVCPatterns.ui;

import java.util.List;
import java.util.Scanner;

// ---------------------------------------------------------------
// The UI (View) handles ALL input/output.
//
// KEY RULES:
//   - It NEVER accesses the DAO directly
//   - It NEVER does business logic (no "if grade >= 60" here)
//   - It ONLY talks to the Controller
//   - It handles: menus, prompts, printing results, error messages
// ---------------------------------------------------------------

public class StudentView {

    private final MVCPatterns.controller.StudentController controller;
    private final Scanner scanner;

    public StudentView(MVCPatterns.controller.StudentController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    // ========================
    //  MAIN MENU LOOP
    // ========================

    public void run() {
        boolean running = true;

        while (running) {
            printMenu();
            int choice = readInt("Choose an option: ");

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudent();
                    break;
                case 3:
                    viewAllStudents();
                    break;
                case 4:
                    updateStudent();
                    break;
                case 5:
                    removeStudent();
                    break;
                case 6:
                    viewClassStats();
                    break;
                case 7:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.\n");
            }
        }

        System.out.println("Goodbye!");
    }

    // ========================
    //  MENU DISPLAY
    // ========================

    private void printMenu() {
        System.out.println("===========================");
        System.out.println("   STUDENT MANAGER");
        System.out.println("===========================");
        System.out.println("1. Add a Student");
        System.out.println("2. View a Student");
        System.out.println("3. View All Students");
        System.out.println("4. Update a Student");
        System.out.println("5. Remove a Student");
        System.out.println("6. View Class Stats");
        System.out.println("7. Exit");
        System.out.println("===========================");
    }

    // ========================
    //  FEATURE METHODS
    //  Each one collects input,
    //  calls the controller,
    //  and displays the result.
    // ========================

    private void addStudent() {
        int id       = readInt("Enter student ID: ");
        String name  = readString("Enter student name: ");
        int grade    = readInt("Enter student grade (0-100): ");

        MVCPatterns.Student s = controller.addStudent(id, name, grade);
        System.out.println("\nStudent added: " + s.getName() + "\n");
    }

    private void viewStudent() {
        int id = readInt("Enter student ID: ");
        MVCPatterns.Student s = controller.getStudent(id);

        if (s == null) {
            System.out.println("\nStudent not found.\n");
        } else {
            printStudentDetails(s);
        }
    }

    private void viewAllStudents() {
        List<MVCPatterns.Student> students = controller.getAllStudents();

        if (students.isEmpty()) {
            System.out.println("\nNo students in the system.\n");
            return;
        }

        System.out.println("\n--- All Students ---");
        for (MVCPatterns.Student s : students) {
            // Notice: the UI asks the CONTROLLER if the student is passing.
            // It doesn't check s.getGrade() >= 60 on its own.
            String status = controller.isStudentPassing(s.getId())
                    ? "PASSING" : "FAILING";
            System.out.printf("  [%d] %-15s Grade: %3d  (%s)%n",
                    s.getId(), s.getName(), s.getGrade(), status);
        }
        System.out.println();
    }

    private void updateStudent() {
        int id = readInt("Enter student ID to update: ");

        if (controller.getStudent(id) == null) {
            System.out.println("\nStudent not found.\n");
            return;
        }

        String name = readString("Enter new name: ");
        int grade   = readInt("Enter new grade (0-100): ");

        controller.updateStudent(id, name, grade);
        System.out.println("\nStudent updated.\n");
    }

    private void removeStudent() {
        int id = readInt("Enter student ID to remove: ");

        if (controller.getStudent(id) == null) {
            System.out.println("\nStudent not found.\n");
            return;
        }

        controller.removeStudent(id);
        System.out.println("\nStudent removed.\n");
    }

    private void viewClassStats() {
        List<MVCPatterns.Student> all     = controller.getAllStudents();
        List<MVCPatterns.Student> passing = controller.getPassingStudents();
        List<MVCPatterns.Student> failing = controller.getFailingStudents();
        double average        = controller.getClassAverage();

        System.out.println("\n--- Class Statistics ---");
        System.out.println("  Total students:   " + all.size());
        System.out.println("  Passing:          " + passing.size());
        System.out.println("  Failing:          " + failing.size());
        System.out.printf("  Class average:    %.1f%n", average);
        System.out.println();
    }

    // ========================
    //  HELPER METHODS
    // ========================

    private void printStudentDetails(MVCPatterns.Student s) {
        String status = controller.isStudentPassing(s.getId())
                ? "PASSING" : "FAILING";

        System.out.println("\n--- Student Details ---");
        System.out.println("  ID:     " + s.getId());
        System.out.println("  Name:   " + s.getName());
        System.out.println("  Grade:  " + s.getGrade());
        System.out.println("  Status: " + status);
        System.out.println();
    }

    private int readInt(String prompt) {
        System.out.print(prompt);
        int value = scanner.nextInt();
        scanner.nextLine(); // consume leftover newline
        return value;
    }

    private String readString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}
