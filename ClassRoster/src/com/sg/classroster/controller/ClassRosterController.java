package com.sg.classroster.controller;

import com.sg.classroster.dao.ClassRosterDao;
import com.sg.classroster.dao.ClassRosterPersistenceException;
import com.sg.classroster.dto.Student;
import com.sg.classroster.ui.ClassRosterView;

import java.util.List;

public class ClassRosterController {
    private final ClassRosterDao dao;
    private final ClassRosterView view;

    public ClassRosterController(ClassRosterDao dao, ClassRosterView view) {
        this.dao = dao;
        this.view = view;
    }

    public void run() {
        boolean keepGoing = true;

        while (keepGoing) {
            int menuSelection = view.printMenuAndGetSelection();

            switch (menuSelection) {
                case 1:
                    createStudent();
                    break;
                case 2:
                    listStudents();
                    break;
                case 3:
                    viewStudent();
                    break;
                case 4:
                    removeStudent();
                    break;
                case 5:
                    keepGoing = false;
                    break;
                default:
                    unknownCommand();            }
        }

        exitMessage();
    }

    private void createStudent() {
        view.displayCreateStudentBanner();
        Student newStudent = view.getNewStudentInfo();
        try {
            dao.addStudent(newStudent.getStudentId(), newStudent);
        } catch (ClassRosterPersistenceException e) {
            view.displayErrorMessage(e.getMessage());
        }
        view.displayCreateSuccessBanner();
    }

    private void listStudents() {
        view.displayDisplayAllBanner();
        try {
            List<Student> studentList = dao.getAllStudents();
            view.displayStudentList(studentList);
        } catch (ClassRosterPersistenceException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private void viewStudent() {
        view.displayDisplayStudentBanner();
        String studentId = view.getStudentIdChoice();
        try {
            Student student = dao.getStudent(studentId);
            view.displayStudent(student);
        } catch (ClassRosterPersistenceException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private void removeStudent() {
        String studentId = view.getStudentIdChoice();
        try {
            Student removedStudent = dao.removeStudent(studentId);
            view.displayRemoveResult(removedStudent);
        } catch (ClassRosterPersistenceException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }
}
