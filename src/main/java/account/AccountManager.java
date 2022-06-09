package account;

import bankbranch.Bank;
import exceptions.BalanceCannotBeNegativeException;
import exceptions.TransferCannotBeNegativeException;

import java.util.ArrayList;
import java.util.List;

public class AccountManager {
    private static List<Account> AVAILABLE_USER_ACCOUNTS = new ArrayList<>();

    public Account createUserAccount(String accountOwnerBank, double balance, String accountNumber, Bank bank) throws BalanceCannotBeNegativeException {
        var user = new Account(accountOwnerBank, balance, accountNumber, bank);
        AVAILABLE_USER_ACCOUNTS.add(user);
        return user;
    }

    public boolean transferMoney(Account accountFrom, Account accountTo, double amount) throws TransferCannotBeNegativeException {
        var firstAmount = accountFrom.getBalance();
        var secondAmount = accountTo.getBalance();
        return checkForNegativeAmountException(accountFrom, accountTo, amount, firstAmount, secondAmount);
    }

    private boolean checkForNegativeAmountException(Account accountFrom, Account accountTo, double amount, double firstAmount, double secondAmount) {
        try {
            return amountIsNotNegative(accountFrom, accountTo, amount, firstAmount, secondAmount);
        } catch (TransferCannotBeNegativeException ex) {
            System.out.println("You cannot transfer negative amount");
        }
        return false;
    }

    private boolean amountIsNotNegative(Account accountFrom, Account accountTo, double amount, double firstAmount, double secondAmount) throws TransferCannotBeNegativeException {
        if (amount > 0) {
            return checkIfTransferredAmountIsNotLargerThanBalance(accountFrom, accountTo, amount, firstAmount, secondAmount);
        }
        return false;
    }

    private boolean checkIfTransferredAmountIsNotLargerThanBalance(Account accountFrom, Account accountTo, double amount, double firstAmount, double secondAmount) throws TransferCannotBeNegativeException {
        if (accountFrom.getBalance() - amount >= 0) {
            changeBalance(accountFrom, accountTo, amount, firstAmount, secondAmount);
            return true;
        } else {
            throw new TransferCannotBeNegativeException("You cannot transfer more than you have", amount);
        }
    }

    private void changeBalance(Account accountFrom, Account accountTo, double amount, double firstAmount, double secondAmount) {
        accountFrom.setBalance(firstAmount - amount);
        accountTo.setBalance(secondAmount + amount);
        String message = "Money transferred " + amount;
        addInformationAboutTransaction(accountFrom, accountTo, message);
    }

    private void addInformationAboutTransaction(Account accountFrom, Account accountTo, String message) {
        accountFrom.transactionAdd("Transaction made: " + message);
        accountTo.transactionAdd("Transaction made: " + message);
    }

    private void addInformationAboutTransaction(Account account, String message) {
        account.transactionAdd("Transaction made: " + message);
    }


    public void depositMoneyToAccount(Account user, double depositedAmount) {
        if (depositedAmount > 0) {
            changeBalance(user, depositedAmount);
        } else {
            System.out.println("Deposited amount is zero or less than zero");
        }
    }

    private void changeBalance(Account userAccount, double depositedAmount) {
        double balance = userAccount.getBalance();
        userAccount.setBalance(depositedAmount + balance);
        String message = "Amount deposited " + depositedAmount + "balance " + userAccount.getBalance();
        addInformationAboutTransaction(userAccount, message);
    }

    public void withdrawMoneyFromAccount(Account userAccount, double withdrawAmount) {
        if (withdrawAmount > 0) {
            double balance = userAccount.getBalance();
            userAccount.setBalance(balance - withdrawAmount);
            String message = "Amount withdraw " + withdrawAmount + "balance " + userAccount.getBalance();
            addInformationAboutTransaction(userAccount, message);
        } else {
            System.out.println("Deposited amount is zero or less than zero");
        }
    }

    public void checkBalance(Account account) {
        System.out.println("Balance of the account with number: " + account.getAccountNumber() + " is: " + account.getBalance());
    }

    public List<String> transactionList(Account account) {
        return account.getTransaction();
    }
}





