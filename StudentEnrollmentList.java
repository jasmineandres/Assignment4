public class StudentEnrollmentList {

    public static void main(String[] args) {

        FileService studentFileService = new FileService();
        studentFileService.readStudentFile();
        studentFileService.groupStudents();
    }

}

