package account;

import bankbranch.Bank;
import exceptions.BalanceCannotBeNegativeException;

public class Account {
    private static int nextId = 1;
    private int id;
    private String accountOwner;
    private double balance;
    private Bank bank;

    public Account(String accountOwner, double balance, Bank bank) throws BalanceCannotBeNegativeException {
        this.id = nextId++;
        this.accountOwner = accountOwner;
        this.bank = bank;
        if (balance < 0) {
            throw new BalanceCannotBeNegativeException("You can't create account with negative balance", balance);
        }
        this.balance = balance;
    }


    public int getId() {
        return id;
    }


    public String getAccountOwner() {
        return accountOwner;
    }

    public void setAccountOwner(String accountOwner) {
        this.accountOwner = accountOwner;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

}
