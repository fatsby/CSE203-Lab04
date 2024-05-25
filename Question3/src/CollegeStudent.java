import java.io.Serializable;
import java.util.Scanner;

public class CollegeStudent extends Student implements Serializable {
    private double gradScore;
    static Scanner sc = new Scanner(System.in);

    public CollegeStudent(){
    }

    public CollegeStudent(double graduationExamScore) {
        super();
        this.gradScore = graduationExamScore;
    }

    @Override
    public void Input(){
        super.Input();
        System.out.print("Enter graduation exam score: ");
        gradScore = sc.nextDouble();
    }


    @Override
    public boolean isEligibleForGraduation() {
        return creditsEarned >= 100 && avgScore >= 5 && gradScore >= 5;
    }

    public void setGradScore(double gradScore) {
        this.gradScore = gradScore;
    }
}
