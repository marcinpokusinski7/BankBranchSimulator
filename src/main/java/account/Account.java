package account;

import bankbranch.Bank;
import exceptions.BalanceCannotBeNegativeException;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private static int nextId = 1;
    private final int id;
    private final String accountOwner;

    private final String accountNumber;
    private double balance;
    private final Bank bank;
    private List<String> transactions;

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accountOwner='" + accountOwner + '\'' +
                ", balance=" + balance +
                ", accountNumber=" + accountNumber +
                ", bank=" + bank +
                '}';
    }

    public Account(String accountOwner, double balance, String accountNumber , Bank bank) throws BalanceCannotBeNegativeException {
        this.id = nextId++;
        this.accountOwner = accountOwner;
        this.accountNumber = accountNumber;
        this.bank = bank;
        if (balance < 0) {
            throw new BalanceCannotBeNegativeException("You can't create account with negative balance", balance);
        }
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountOwner() {
        return accountOwner;
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

    public void transactionAdd(String transaction){
       this.transactions.add(transaction);
    }

    public List<String> getTransaction(){
        return transactions;
    }
}
