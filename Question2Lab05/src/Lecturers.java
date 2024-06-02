

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lecturers extends Staff {

    private int academicRank;
    private String academicDegree;
    private int teachingYears;
    private List<String> taughtSubject = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public Lecturers() {
    }

    public Lecturers(int academicRank, String academicDegree, int teachingYears, List<String> taughtSubject) {
        super();
        this.academicRank = academicRank;
        this.academicDegree = academicDegree;
        this.teachingYears = teachingYears;
        this.taughtSubject = taughtSubject;
    }

    @Override
    public void CalculateSalary() {
        salary = (taughtSubject.size() * teachingYears * 0.12) * 20000;
    }

    @Override
    public void Input() {
        super.Input();
        while (true) {
            try {
                System.out.print("Enter academic rank: ");
                academicRank = sc.nextInt();
                break;
            } catch (Exception e) {
                System.out.print("Please enter academic rank again (integer)");
                sc.nextLine();
            }
        }

        System.out.print("Enter academic degree: ");
        academicDegree = sc.next();

        while (true) {
            try {
                System.out.print("Enter number of teaching years: ");
                teachingYears = sc.nextInt();
                break;
            } catch (Exception e) {
                System.out.print("Please enter teaching years again (integer)");
                sc.nextLine();
            }
        }

        while (true) {
            try {
                System.out.print("Enter number of taught subjects: ");
                int n = sc.nextInt();

                for (int i = 0; i < n; i++) {
                    System.out.print("Enter subject " + (i + 1) + ": ");
                    taughtSubject.add(sc.next());
                }

                break;
            } catch (Exception e) {
                System.out.print("Please enter number of taught subjects again (integer)");
                sc.nextLine();
            }
        }
        CalculateSalary();

    }

    @Override
    public String toString() {
        String n = super.toString();
        n = n + "Academic rank: " + academicRank + "\nAcademic degree: " + academicDegree + "\nNumber of teaching years: " + teachingYears + "\nNumber of taught subjects: " + taughtSubject + "are:\n";
        for (String string : taughtSubject) {
            n += string + "\n";
        }
        n += "Salary: " + salary + "\n";
        return n;
    }

    @Override
    public void Edit() {
        System.out.println("What do you want to edit:\n 1.Fullname \n 2.Date of birth \n 3.ID number \n 4.Academic rank \n 5.Academic degree\n 6.Number of teaching years \n 7.Taught subjects");
        int n = sc.nextInt();
        switch (n) {
            case 1:
                System.out.print("Enter the new one: ");
                fullname = sc.next();
                break;
            case 2:
                System.out.print("Enter the new one: ");
                dateOfBirth = sc.next();
                break;
            case 3:
                System.out.print("Enter the new one: ");
                IDnumber = sc.nextLong();
                break;
            case 4:
                System.out.print("Enter the new one: ");
                academicRank = sc.nextInt();
                break;
            case 5:
                System.out.print("Enter the new one: ");
                academicDegree = sc.next();
                break;
            case 6:
                System.out.print("Enter the new one: ");
                teachingYears = sc.nextInt();
                CalculateSalary();
                break;
            case 7:
                System.out.print("The number of taught subjects is remain ?\n 0 (no) \n 1(yes): ");
                int temp = sc.nextInt();
                if (temp == 0) {
                    System.out.print("Enter the index of taught subject you want to change(from 1 to ...): ");
                    int index = sc.nextInt();
                    System.out.print("Enter the new subject: ");
                    String newSub = sc.next();
                    taughtSubject.add(index - 1, newSub);
                } else {
                    System.out.print("Do you want to remove subject(0) or add more subject(1): ");
                    int com = sc.nextInt();
                    if (com == 0) {
                        System.out.print("Enter the index of taught subject you want to remove(from 1 to ...): ");
                        int indexR = sc.nextInt();
                        taughtSubject.remove(indexR - 1);
                    } else {
                        System.out.print("Enter new subject: ");
                        taughtSubject.add(sc.next());
                    }
                    CalculateSalary();
                }
        }
    }
}