import bankbranch.Bank;
import bankbranch.BankBranch;
import bankbranch.ManageBanks;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean quit = false;
        BankBranch branch = BankBranch.createBankBranch("Polski");
        BankBranch branch1 = BankBranch.createBankBranch("Wloski");

        ManageBanks manager = new ManageBanks();
        manager.addBranch(branch);
        manager.addBranch(branch1);
        manager.addBankToBranch(Bank.createNewBank("Pekao", "Smiesnzy", "123"), branch);



        printActions();

        while (!quit) {
            System.out.println("Enter actions: (press 6 to show available actions)");
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
                case 0:
                    System.out.println("\nShutting down");
                    quit = true;
                    break;
                case 1:
                    //bankSystem.printAccounts();
                    break;
                case 2:
                    //createNewAccount();
                    break;
                case 3:
                    //removeAccount();
                    break;
                case 6:
                    printActions();
                    break;
            }

        }

    }
    private static void printActions() {
        System.out.println("1 - Add Bank branch" +
                "0 - quit");
    }
}
