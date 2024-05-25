import java.io.Serializable;
import java.util.Scanner;

public class UniversityStudent extends Student implements Serializable {
    private String thesisName;
    private double thesisScore;
    static Scanner sc = new Scanner(System.in);

    public UniversityStudent(){}

    public UniversityStudent(String thesisName, double thesisScore) {
        super();
        this.thesisName = thesisName;
        this.thesisScore = thesisScore;
    }

    @Override
    public void Input(){
        super.Input();
        System.out.print("Enter thesis name: ");
        thesisName = sc.next();
        System.out.print("Enter thesis score: ");
        thesisScore = sc.nextDouble();
    }

    @Override
    public boolean isEligibleForGraduation() {
        return creditsEarned >= 150 && avgScore >= 5 && thesisScore >= 5;
    }

    public void setThesisName(String thesisName) {
        this.thesisName = thesisName;
    }

    public void setThesisScore(double thesisScore) {
        this.thesisScore = thesisScore;
    }
}
