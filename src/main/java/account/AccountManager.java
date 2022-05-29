package account;

import bankbranch.Bank;
import exceptions.BalanceCannotBeNegativeException;
import exceptions.TransferCannotBeNegativeException;

import java.util.ArrayList;
import java.util.List;

public class AccountManager {
    private static List<Account> AVAILABLE_USER_ACCOUNTS = new ArrayList<>();

    public Account createUserAccount(String accountOwnerBank, double balance, Bank bank) throws BalanceCannotBeNegativeException {
        var user = new Account(accountOwnerBank, balance, bank);
        AVAILABLE_USER_ACCOUNTS.add(user);
        return user;
    }

    public boolean transferMoney(Account accountFrom, Account accountTo, double amount) throws TransferCannotBeNegativeException {
        var firstAmount = accountFrom.getBalance();
        var secondAmount = accountTo.getBalance();
        try{
            if (amount > 0) {
                if (accountFrom.getBalance() - amount >= 0) {
                    accountFrom.setBalance(firstAmount - amount);
                    accountTo.setBalance(secondAmount + amount);
                    return true;
                } else {
                    System.out.println("You cannot transfer more than you have");
                    throw new TransferCannotBeNegativeException("You cannot transfer more than you have", amount);
                }
            }
        } catch (TransferCannotBeNegativeException ex) {
            System.out.println("You cannot transfer negative amount");
        }
        return false;
    }

}





