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
    }


    public void depositMoneyToAccount(Account user, double depositedAmount) {
        if (depositedAmount > 0) {
            double balance = user.getBalance();
            user.setBalance(depositedAmount + balance);
        } else {
            System.out.println("Deposited amount is zero or less than zero");
        }
    }

    public void withdrawMoneyFromAccount(Account account, double withdrawAmount) {
        if (withdrawAmount > 0) {
            double balance = account.getBalance();
            account.setBalance(balance - withdrawAmount);
        } else {
            System.out.println("Deposited amount is zero or less than zero");
        }
    }
}





