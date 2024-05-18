import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter bank type (TPBANK or VIETCOMBANK):");
        String bankTypeInput = scanner.nextLine().toUpperCase();
        BankType bankType = BankType.valueOf(bankTypeInput);

        Bank bank = BankFactory.getBank(bankType);
        System.out.println("Bank name: " + bank.getBankName());
    }
}
