import java.util.Objects;
import java.util.Scanner;

public class Main {
    private static final Dictionary dictionary = new Dictionary();
    private static final Scanner sc = new Scanner(System.in);
    public static void drawMenu(){
        int n;
        do {
            System.out.println("===========================");
            System.out.println("Fatsby's Dictionary");
            System.out.println("1. Find the meaning of a word");
            System.out.println("2. EXIT ");
            System.out.println("============================");
            n = sc.nextInt();
            sc.nextLine();
            switch (n){
                case 1:
                    while(true) {
                        System.out.println("Enter the word (or enter 0 to return to menu): ");
                        String input = sc.nextLine();
                        if(Objects.equals(input, "0")){
                            break;
                        }
                        dictionary.check(input);
                    }
                    break;
                case 2:
                    System.out.print("Exiting program...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }while (n != 2);
    }

    public static void main(String[] args) {
        drawMenu();
    }
}
