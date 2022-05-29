package bankbranch;

import java.util.ArrayList;
import java.util.List;

public class BankBranchMain {
    private static int nextId = 1;
    private int id;
    private String branchName;
    private List<Bank> bankList;

    public List<Bank> getBankList() {
        return bankList;
    }

    public BankBranchMain(String branchName) {
        this.id = nextId++;
        this.branchName = branchName;
        this.bankList = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getBranchName() {
        return branchName;
    }

    public BankBranchMain() {
    }

    public static BankBranchMain createBankBranch(String branchName) {
        return new BankBranchMain(branchName);
    }

    protected void addBankToBranch(Bank bank){
        this.bankList.add(bank);
    }

    @Override
    public String toString() {
        return "BankBranchMain{" +
                "id=" + id +
                ", branchName='" + branchName + '\'' +
                ", bankList="  +bankList +
                '}';
    }
}
