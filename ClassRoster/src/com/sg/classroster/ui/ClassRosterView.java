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
        String studentId = io.readString("Please enter Student ID");
        String firstName = io.readString("Please enter First Name");
        String lastName = io.readString("Please enter Last Name");
        String cohort = io.readString("Please enter Cohort");
        Student currentStudent = new Student(studentId);
        currentStudent.setFirstName(firstName);
        currentStudent.setLastName(lastName);
        currentStudent.setCohort(cohort);
        return currentStudent;
    }

    public void displayStudentList(List<Student> studentList) {
        for (Student currentStudent : studentList) {
            String studentInfo = String.format("#%s : %s %s",
                    currentStudent.getStudentId(),
                    currentStudent.getFirstName(),
                    currentStudent.getLastName());
            io.print(studentInfo);
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayDisplayAllBanner() {
        io.print("=== Display All Students ===");
    }

    public void displayDisplayStudentBanner () {
        io.print("=== Display Student ===");
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
        io.readString("Please hit enter to continue.\n");
    }

    public void displayCreateStudentBanner() {
        io.print("=== Create Student ===");
    }

    public void displayCreateSuccessBanner() {
        io.print("Student successfully created.");
    }

    public void displayRemoveStudentBanner () {
        io.print("=== Remove Student ===");
    }

    public void displayRemoveResult(Student studentRecord) {
        if(studentRecord != null){
            io.print("Student successfully removed.");
        }else{
            io.print("No such student.");
        }
        io.readString("Please hit enter to continue.");
    }



    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown command.");
    }

    public void displayExitBanner() {
        io.print("Good Bye!");
    }

    public void displayRemoveSuccessBanner() {
        io.print("Student successfully removed.");
    }
}
