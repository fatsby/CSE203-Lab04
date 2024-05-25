import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class University {
    private List<Student> students;

    public University(){
        students = new ArrayList<Student>();

        if (FileUtils.fileExists("College.DAT")) {
            students.addAll(FileUtils.readStudentFromFile("College.DAT"));
        }
        if (FileUtils.fileExists("University.DAT")) {
            students.addAll(FileUtils.readStudentFromFile("University.DAT"));
        }
    }

    public void addCollegeStudent(int loop){
        for(int i = 0; i < loop; i++){
            CollegeStudent student = new CollegeStudent();
            student.Input();
            students.add(student);
        }
        saveToFile();
    }
    public void addUniversityStudent(int loop){
        for (int i = 0; i < loop; i++) {
            UniversityStudent student = new UniversityStudent();
            student.Input();
            students.add(student);
        }
        saveToFile();
    }

    public void printStudentList(){
        System.out.println();
        System.out.println("===========================");
        System.out.println("      Student List");
        System.out.println("===========================");
        System.out.println();
        for(Student student : students){
            System.out.println();
            System.out.println("System: " + student.getClass().getSimpleName());
            System.out.println("Full Name: " + student.getFullName());
            System.out.println("Student Number: " + student.getNumber());
            System.out.println();
        }
    }

    public void eligibleCheck(){
        int counter = 0;
        System.out.println("Students eligible for graduation: ");
        for(Student student : students){
            if (student.isEligibleForGraduation()){
                System.out.println(student.getFullName());
                counter++;
            }
        }
        System.out.println("Number of students eligible: " + counter);
    }

    public void removeStudent(String code){
        students.removeIf(student -> student.getNumber().equals(code));
        saveToFile();
    }

    public void sortStudentList() {
        students.sort(Comparator.comparing((Student student) -> student.getClass().getSimpleName())
                .thenComparing(Student::getNumber));
        saveToFile();
    }

    public void findByName(String name){
        List<Student> results = new ArrayList<>();
        for(Student student : students){
            if(student.getFullName().contains(name)){
                results.add(student);
                System.out.println(student.getFullName() + " " + student.getNumber());
            }
        }
        FileUtils.writeStudentsToFile("Result.dat", results);
    }


    //RANDOM
    public void addRandomCollegeStudent(String fullName, String number, int totalCredits, double averageScore, double graduationExamScore) {
        CollegeStudent student = new CollegeStudent();
        student.setFullName(fullName);
        student.setNumber(number);
        student.setCreditsEarned(totalCredits);
        student.setAvgScore(averageScore);
        student.setGradScore(graduationExamScore);
        students.add(student);
    }

    public void addRandomUniversityStudent(String fullName, String number, int totalCredits, double averageScore, String thesisName, double thesisScore) {
        UniversityStudent student = new UniversityStudent();
        student.setFullName(fullName);
        student.setNumber(number);
        student.setCreditsEarned(totalCredits);
        student.setAvgScore(averageScore);
        student.setThesisName(thesisName);
        student.setThesisScore(thesisScore);
        students.add(student);
    }

    public void saveToFile(){
        List<Student> collegeStudents = new ArrayList<>();
        List<Student> universityStudents = new ArrayList<>();
        for(Student student : students){
            if(student instanceof CollegeStudent){
                collegeStudents.add(student);
            } else if (student instanceof UniversityStudent) {
                universityStudents.add(student);
            }
        }
        FileUtils.writeStudentsToFile("College.DAT", collegeStudents);
        FileUtils.writeStudentsToFile("University.DAT", universityStudents);
    }
}
