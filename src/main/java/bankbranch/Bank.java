package bankbranch;

import account.Account;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private static int nextId = 1;
    private int id;
    private String bankName;
    private String bankAddress;
    private String contact;

    private List<Account> userAccounts;

    public List<Account> getUserAccounts() {
        return userAccounts;
    }

    public Bank(String bankName, String bankAddress, String contact) {
        this.id = nextId++;
        this.bankName = bankName;
        this.bankAddress = bankAddress;
        this.contact = contact;
        this.userAccounts = new ArrayList<>();
    }


    public int getId() {
        return id;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankAddress() {
        return bankAddress;
    }

    public void setBankAddress(String bankAddress) {
        this.bankAddress = bankAddress;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public static Bank createNewBank(String bankName, String bankAddress, String contact){
        return new Bank(bankName, bankAddress, contact);
    }
}
