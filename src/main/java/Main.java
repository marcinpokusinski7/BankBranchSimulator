import account.Account;
import account.AccountManager;
import bankbranch.Bank;
import bankbranch.BankBranchMain;
import bankbranch.BanksManager;
import com.github.javaparser.utils.Pair;
import exceptions.BalanceCannotBeNegativeException;
import exceptions.TransferCannotBeNegativeException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private final static AccountManager accountManager = new AccountManager();
    private final static BanksManager bankmanager = new BanksManager();

    private final static List<Account> accountList = new ArrayList<>();

    public static void main(String[] args) throws BalanceCannotBeNegativeException, TransferCannotBeNegativeException {
        boolean quit = false;
        bankmanager.addBranch(BankBranchMain.createBankBranch("Odział główny"));
        printActions();

        while (!quit) {
            System.out.println("Enter actions: (press 7 to show available actions)");
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
                case 0:
                    System.out.println("\nShutting down");
                    quit = true;
                    break;
                case 1:
                    createNewAccount();
                    break;
                case 2:
                    withdrawMoney();
                    break;
                case 3:
                    depositMoney();
                    break;
                case 4:
                    transferMoney();
                    break;
                case 5:
                    createNewBank();
                    break;
                case 6:
                    printLastTransactions();
                    break;
                case 7:
                    printActions();
                    break;
            }

        }

    }

    private static void printLastTransactions() {
        System.out.println("Check history of account: ");
        accountManager.printAccountList();
        int accNumber = scanner.nextInt();
        scanner.nextLine();
        accNumber = accNumber - 1;
        List<String> tempTransactions = accountManager.transactionList(AccountManager.AVAILABLE_USER_ACCOUNTS.get(accNumber));
        tempTransactions.forEach(System.out::println);
    }

    private static Pair<Integer, Integer> getAccNumbers() {
        accountManager.printAccountList();
        int accNumberFirst = scanner.nextInt() - 1;
        scanner.nextLine();
        System.out.println("Choose account to transfer money: ");
        accountManager.printAccountList();
        int accNumberSecond = scanner.nextInt() - 1;
        scanner.nextLine();
        return new Pair<>(accNumberFirst, accNumberSecond);
    }

    private static void depositMoney() {
        if (AccountManager.AVAILABLE_USER_ACCOUNTS.stream().count() >= 1) {
            System.out.println("Choose account to deposit: ");
            accountManager.printAccountList();
            int accNumber = scanner.nextInt();
            scanner.nextLine();
            accNumber = accNumber - 1;
            System.out.println("Enter how much you want deposit: ");
            int depositBalance = scanner.nextInt();
            scanner.nextLine();
            accountManager.depositMoneyToAccount(AccountManager.AVAILABLE_USER_ACCOUNTS.get(accNumber), depositBalance);
            System.out.println(AccountManager.AVAILABLE_USER_ACCOUNTS.get(accNumber).getAccountOwner() + " " + AccountManager.AVAILABLE_USER_ACCOUNTS.get(accNumber).getBalance() + " zł");
        } else {
            System.out.println("There is insufficiently accounts created");
        }

    }

    private static void withdrawMoney() {
        System.out.println("Choose account to withdraw: ");
        accountManager.printAccountList();
        int accNumber = scanner.nextInt();
        scanner.nextLine();
        accNumber = accNumber - 1;
        System.out.println("Enter how much you want withdraw: ");
        int depositBalance = scanner.nextInt();
        scanner.nextLine();
        accountManager.withdrawMoneyFromAccount(AccountManager.AVAILABLE_USER_ACCOUNTS.get(accNumber), depositBalance);
        System.out.println(AccountManager.AVAILABLE_USER_ACCOUNTS.get(accNumber).getAccountOwner() + " " + AccountManager.AVAILABLE_USER_ACCOUNTS.get(accNumber).getBalance() + " zł");
    }

    private static void transferMoney() throws TransferCannotBeNegativeException {
        if ((long) AccountManager.AVAILABLE_USER_ACCOUNTS.size() >= 2) {
            System.out.println("Choose account from which transfer money: ");
            Pair<Integer, Integer> accNumber = getAccNumbers();
            System.out.println("Enter how much you want to transfer: ");
            int transferredMoney = scanner.nextInt();
            scanner.nextLine();
            accountManager.transferMoney(AccountManager.AVAILABLE_USER_ACCOUNTS.get(accNumber.a),
                    AccountManager.AVAILABLE_USER_ACCOUNTS.get(accNumber.b), transferredMoney);

            System.out.println("transfered from :"
                    + AccountManager.AVAILABLE_USER_ACCOUNTS.get(accNumber.a).getAccountOwner()
                    + " Amount: " + transferredMoney + " to "
                    + AccountManager.AVAILABLE_USER_ACCOUNTS.get(accNumber.b).getAccountOwner() +
                    " Balance is : "
                    + AccountManager.AVAILABLE_USER_ACCOUNTS.get(accNumber.b).getBalance()
                    + " zł");
        } else {
            System.out.println("There is insufficiently accounts created");
        }
    }

    private static void createNewAccount() throws BalanceCannotBeNegativeException {
        if ((long) Bank.AVAILABLE_BANKS.size() != 0) {
            System.out.println("Enter account owner name: ");
            String accountOwner = scanner.nextLine();
            System.out.println("Enter new deposit: ");
            int balance = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter new account number: ");
            String accountNumber = scanner.nextLine();
            if (AccountManager.AVAILABLE_USER_ACCOUNTS.stream().noneMatch(account -> account.getAccountNumber().equals(accountNumber))) {
                System.out.println("Choose bank: ");
                bankmanager.printBanks();
                String bank = scanner.nextLine();
                var account = accountManager.createUserAccount(accountOwner, balance, accountNumber, bankmanager.getBank(Integer.parseInt(bank)));
                System.out.println(account.toString());
                System.out.println("New account created: " + accountOwner + " " + accountNumber + " " + balance);
            } else {
                System.out.println("Cannot add" + accountNumber + "already exists");
            }
        } else {
            System.out.println("No banks, add one");
        }
    }

    private static void createNewBank() throws BalanceCannotBeNegativeException {
        System.out.println("Enter bank name: ");
        String bankName = scanner.nextLine();
        System.out.println("Enter bank address: ");
        String bankAddress = scanner.nextLine();
        System.out.println("Enter contact: ");
        String bankContact = scanner.nextLine();
        Bank bank = Bank.createNewBank(bankName, bankAddress, bankContact);
        Bank bankPrint = bankmanager.getBank(bank.getId());
        System.out.println(bankPrint.getBankName() + " " + bankPrint.getBankAddress() + " " + bankPrint.getBankAddress());
        System.out.println("Choose main branch, insert number: ");
        bankmanager.getBranches();
        System.out.println("Branch number: ");
        int numberBranch = scanner.nextInt();
        scanner.nextLine();
        bankmanager.addBankToBranch(bank, bankmanager.getBranch(numberBranch));
    }

    private static void printActions() {
        System.out.println("1 - Create New Account \n" +
                "2 - Withdraw Money \n" +
                "3 - Deposit Money \n" +
                "4 - Transfer Money \n" +
                "5 - Create New Bank \n" +
                "6 - Print Last Transactions \n" +
                "7 - Print Actions \n" +
                "0 - quit");
    }
}
