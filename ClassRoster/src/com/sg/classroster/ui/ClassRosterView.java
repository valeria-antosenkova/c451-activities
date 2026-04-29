package com.sg.classroster.ui;

import com.sg.classroster.dto.Student;
import java.util.List;

public class ClassRosterView {
    private final UserIO io;

    public ClassRosterView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print("=== Main Menu ===");
        io.print("1. Add Student");
        io.print("2. List Students");
        io.print("3. View Student");
        io.print("4. Remove Student");
        io.print("5. Exit");
        return io.readInt("Please select from the above choices: ", 1, 5);
    }

    public Student getNewStudentInfo() {
        String studentId = io.readString("Please enter Student ID: ");
        Student currentStudent = new Student(studentId);

        currentStudent.setFirstName(io.readString("Please enter First Name: "));
        currentStudent.setLastName(io.readString("Please enter Last Name: "));
        currentStudent.setCohort(io.readString("Please enter Cohort: "));

        return currentStudent;
    }

    public void displayStudentList(List<Student> studentList) {
        io.print("=== Student List ===");
        if (studentList.isEmpty()) {
            io.print("No students found.");
        } else {
            for (Student currentStudent : studentList) {
                io.print(currentStudent.getStudentId() + ": " + currentStudent);
            }
        }
        io.readString("Please hit enter to continue.");
    }

    public String getStudentIdChoice() {
        return io.readString("Please enter the Student ID: ");
    }

    public void displayStudent(Student student) {
        io.print("=== Student Info ===");
        if (student == null) {
            io.print("Student not found.");
        } else {
            io.print("ID: " + student.getStudentId());
            io.print("First Name: " + student.getFirstName());
            io.print("Last Name: " + student.getLastName());
            io.print("Cohort: " + student.getCohort());
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayCreateSuccessBanner() {
        io.print("Student successfully created.");
    }

    public void displayRemoveResult(boolean removed) {
        io.print(removed ? "Student successfully removed." : "No student was removed.");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown command.");
    }

    public void displayExitBanner() {
        io.print("Good Bye!");
    }
}
