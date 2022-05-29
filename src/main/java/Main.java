import account.AccountManager;
import bankbranch.Bank;
import bankbranch.BanksManager;
import exceptions.BalanceCannotBeNegativeException;

import java.util.Scanner;


public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private final static AccountManager accountManager = new AccountManager();
    private final static BanksManager bankmanager = new BanksManager();

    public static void main(String[] args) throws BalanceCannotBeNegativeException {
        boolean quit = false;
        Bank.createNewBank("Siema","zlota","email");
        Bank.createNewBank("Czesc","zlota","poczta");
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
                    createNewAccount();
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

    private static void createNewAccount() throws BalanceCannotBeNegativeException {
        System.out.println("Enter account owner name: ");
        String accountOwner = scanner.nextLine();
        System.out.println("Enter new deposit: ");
        int balance = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter new account number: ");
        String accountNumber = scanner.nextLine();
        System.out.println("Choose bank: ");
        String bank = scanner.nextLine();
        var account = accountManager.createUserAccount(accountOwner, balance, accountNumber, bankmanager.getBank(Integer.parseInt(bank)));
        System.out.println(account.toString());
       /* if(account.get){
            System.out.println("New account created: " +accountOwner +" " +accountNumber +" "+balance);

        }else {
            System.out.println("Cannot add" +accountNumber + "already exists");
        }*/
    }

    private static void printActions() {
        System.out.println("1 - Add Bank branch \n" +
                "2 - Add User Account \n" +
                "0 - quit");
    }
}
