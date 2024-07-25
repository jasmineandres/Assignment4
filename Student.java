
public class Student implements Comparable<Student> {

    private String studentId;
    private String grade;
    private String name;
    private String course;

    public Student(String studentId, String name, String course, String grade) {
        this.studentId = studentId;
        this.name = name;
        this.course = course;
        this.grade = grade;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return studentId + " " + name + " " + course + " " + grade;
    }

    @Override
    public int compareTo(Student that) {
        int gradeComparison = that.grade.compareTo(this.grade);
        if (gradeComparison == 0) {
            return this.name.compareTo(that.name);
        }
        return gradeComparison;
    }

}
