import java.util.Comparator;
import java.util.Scanner;
import java.util.Vector;

public class University {
    private static Scanner sc = new Scanner(System.in);
    private static Vector<Student> students = new Vector<>();

    public void addCollegeStudent(int loop){
        for(int i = 0; i < loop; i++){
            CollegeStudent student = new CollegeStudent();
            student.Input();
            students.add(student);
        }
    }
    public void addUniversityStudent(int loop){
        for (int i = 0; i < loop; i++) {
            UniversityStudent student = new UniversityStudent();
            student.Input();
            students.add(student);
        }
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
    }

    public void sortStudentList() {
        students.sort(Comparator.comparing((Student student) -> student.getClass().getSimpleName())
                .thenComparing(Student::getNumber));
    }

    public void findByName(String name){
        for(Student student : students){
            if(student.getFullName().contains(name)){
                System.out.println(student.getFullName() + " " + student.getNumber());
            }
        }
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
}
