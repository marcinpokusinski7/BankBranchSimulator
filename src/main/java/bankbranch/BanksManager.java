package bankbranch;

import java.util.ArrayList;
import java.util.List;

public class BanksManager {
    private static List<BankBranchMain> AVAILABLE_BANK_BRANCH_MAINS = new ArrayList<>();


    public boolean addBankToBranch(Bank bank, BankBranchMain bankBranchMain) {
        for(BankBranchMain branch :AVAILABLE_BANK_BRANCH_MAINS) {
            if(branch.getBranchName().equals(bankBranchMain.getBranchName()))
                return bankEquals(bank, bankBranchMain);
            else {
                System.out.println("Branch does not exists");
            }
        }
        return false;
    }


    private boolean bankEquals(Bank bank, BankBranchMain bankBranchMain) {
        if (bankBranchMain.getBankList().stream().anyMatch(bank1 -> bank1.equals(bank))) {
            System.out.println("Bank already exists in this branch");
        } else {
            bankBranchMain.addBankToBranch(bank);
            return true;
        }
        return false;
    }


    public void getBankBranches() {
        for (BankBranchMain i : AVAILABLE_BANK_BRANCH_MAINS) {
            System.out.println("branch " + i.getBranchName());
            for (Bank j : i.getBankList()) {
                System.out.printf("Banks: " + j.getBankName() + " " + j.getBankAddress() + " " + j.getContact());
            }
        }
    }

    public boolean addBranch(BankBranchMain bankBranchMain) {
        if (!bankBranchMain.getBranchName().equals(getBranches())) {
            AVAILABLE_BANK_BRANCH_MAINS.add(bankBranchMain);
            return true;
        }
        System.out.println("Branch already exists");
        return false;
    }

    private String getBranches() {
        for (BankBranchMain branch : AVAILABLE_BANK_BRANCH_MAINS) {
            return branch.getBranchName();
        }
        return null;
    }


}
