import java.util.Scanner;

public abstract class Student {
    protected String fullName;
    protected String number;
    protected int creditsEarned;
    protected double avgScore;

    public abstract boolean isEligibleForGraduation();


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getCreditsEarned() {
        return creditsEarned;
    }

    public void setCreditsEarned(int creditsEarned) {
        this.creditsEarned = creditsEarned;
    }

    public double getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(double avgScore) {
        this.avgScore = avgScore;
    }

    public Student(){}


    public void Input(){
        Scanner sc = new Scanner(System.in);
        System.out.println("===========================");
        System.out.println("Adding New Student");
        System.out.println("===========================");
        System.out.print("Enter student number: ");
        number = sc.nextLine();
        System.out.print("Enter full name: ");
        fullName = sc.nextLine();
        System.out.print("Enter total credits: ");
        creditsEarned = sc.nextInt();
        System.out.print("Enter average score: ");
        avgScore = sc.nextDouble();
        sc.nextLine();
    }

    public Student(String fullName, String number, int creditsEarned, double avgScore) {
        this.fullName = fullName;
        this.number = number;
        this.creditsEarned = creditsEarned;
        this.avgScore = avgScore;
    }
}
