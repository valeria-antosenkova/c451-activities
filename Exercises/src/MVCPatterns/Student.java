package MVCPatterns;

public class Student {

    private int id;
    private String name;
    private int grade;

    // -------------------------------------------------------
    // A DTO is just a "data bag." No logic, no database calls,
    // no printing. Just fields + getters/setters.
    // -------------------------------------------------------

    public Student(int id, String name, int grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    // --- Getters ---

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    // --- Setters ---

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
