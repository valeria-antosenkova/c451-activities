import DataMarshaling.Student;
import DataMarshaling.StudentRepository;

void main() {
    StudentRepository repo = new StudentRepository("/Users/v-an/c451-activities/Exercises/src/DataMarshaling/students.txt");

    // Load existing students from file
    List<Student> students = repo.loadStudents();
    System.out.println("Loaded " + students.size() + " student(s) from file.");

    // Add some new students
    Student s1 = new Student("0001");
    s1.setFirstName("John");
    s1.setLastName("Doe");
    s1.setCohort("Java - August 2014");

    Student s2 = new Student("0002");
    s2.setFirstName("Sally");
    s2.setLastName("Smith");
    s2.setCohort("Java - April 2014");

    Student s3 = new Student("0003");
    s3.setFirstName("John");
    s3.setLastName("Jones");
    s3.setCohort(".NET - Jan 2014");

    students.add(s1);
    students.add(s2);
    students.add(s3);

    // Save all students back to file
    repo.saveStudents(students);
    System.out.println("Saved " + students.size() + " student(s) to file.");

    // Reload and print to verify
    List<Student> reloaded = repo.loadStudents();
    System.out.println("\n--- Students in file ---");
    for (Student s : reloaded) {
        System.out.println(s.getStudentID() + " | " +
                s.getFirstName() + " " +
                s.getLastName() + " | " +
                s.getCohort());
    }
}

