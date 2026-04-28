package DataMarshaling;

import java.io.*;
import java.util.*;

public class StudentRepository {

    private String filePath;

    public StudentRepository(String filePath) {
        this.filePath = filePath;
    }

    // MARSHAL: Write students to file
    public void saveStudents(List<Student> students) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            for (Student student : students) {
                String line = student.getStudentID() + "::" +
                        student.getFirstName() + "::" +
                        student.getLastName() + "::" +
                        student.getCohort();
                writer.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error saving students: " + e.getMessage());
        }
    }

    // UNMARSHAL: Read students from file
    public List<Student> loadStudents() {
        List<Student> students = new ArrayList<>();

        File file = new File(filePath);
        if (!file.exists()) {
            return students; // return empty list if no file yet
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) continue; // skip blank lines

                String[] parts = line.split("::");

                if (parts.length == 4) {
                    Student student = new Student(parts[0]); // studentId
                    student.setFirstName(parts[1]);
                    student.setLastName(parts[2]);
                    student.setCohort(parts[3]);
                    students.add(student);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading students: " + e.getMessage());
        }

        return students;
    }
}
