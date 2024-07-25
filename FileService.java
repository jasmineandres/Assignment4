import java.io.*;
import java.util.Arrays;

public class FileService {

    private static String csvHeader = "Student ID, Student Name, Course, Grade";
    private String course1 = "course1.csv";
    private String course2 = "course2.csv";
    private String course3 = "course3.csv";
    File realtiveFile = new File("src/student-master-list.csv");
    private Student[] students = new Student[101];
    private int studentCount = 0;

    public Student[] readStudentFile() {
        try (BufferedReader fileReader = new BufferedReader(new FileReader(realtiveFile))) {

            String line;
            while ((line = fileReader.readLine()) != null) {
                String[] studentData = line.split("\t");
                if (studentData.length == 4) {
                    students[studentCount++] = new Student(studentData[0], studentData[1], studentData[2], studentData[3]);
                }
            }

        } catch (IOException e) {
            System.out.println("IO Exception for File " + realtiveFile);
            e.printStackTrace();

        }
        return students;
    }

    public void groupStudents() {
        Student[] compSciStudents = new Student[students.length];
        Student[] apMathStudents = new Student[students.length];
        Student[] statStudents = new Student[students.length];

        int compSciCount = 0;
        int apMathCount = 0;
        int statCount = 0;
        for (int i = 0; i < studentCount; i++) {
            Student student = students[i];
            if (student != null) {
                if (students[i].getCourse().contains("COMPSCI")) {
                    compSciStudents[compSciCount++] = students[i];
                } else if (students[i].getCourse().contains("APMTH")) {
                    apMathStudents[apMathCount++] = students[i];
                } else if (students[i].getCourse().contains("STAT")) {
                    statStudents[statCount++] = students[i];
                }
            }
        }
        writeStudentToFile(compSciStudents, compSciCount, course1);
        writeStudentToFile(apMathStudents, apMathCount, course2);
        writeStudentToFile(statStudents, statCount, course3);
    }

    private void writeStudentToFile(Student[] students, int count, String course) {
        Arrays.sort(students, 0, count);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(course))) {
            writer.write(csvHeader);
            writer.newLine();
            for (int i = 0; i < count; i++) {
                writer.write(students[i].toString());
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("IO Exception Writing to File" + course);
            e.printStackTrace();
        }
    }

}