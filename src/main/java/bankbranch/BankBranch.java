package bankbranch;

import java.util.ArrayList;
import java.util.List;

public class BankBranch {
    private static int nextId = 1;
    private int id;
    private String branchName;
    private List<Bank> bankList;

    public List<Bank> getBankList() {
        return bankList;
    }

    public void setBankList(List<Bank> bankList) {
        this.bankList = bankList;
    }

    public BankBranch(String branchName) {
        this.id = nextId++;
        this.branchName = branchName;
        this.bankList = new ArrayList<>();
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        BankBranch.nextId = nextId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public BankBranch() {
    }

    public static BankBranch createBankBranch(String branchName) {
        return new BankBranch(branchName);
    }

    public void addBankToBranch(Bank bank){
        this.bankList.add(bank);
    }

    @Override
    public String toString() {
        return "BankBranch{" +
                "id=" + id +
                ", branchName='" + branchName + '\'' +
                ", bankList="  +bankList +
                '}';
    }
}
