package bankbranch;

import java.util.ArrayList;
import java.util.List;

public class BanksManager {
    private static List<BankBranchMain> AVAILABLE_BANK_BRANCH_MAINS = new ArrayList<>();


    public boolean addBankToBranch(Bank bank, BankBranchMain bankBranchMain) {
        for (BankBranchMain branch : AVAILABLE_BANK_BRANCH_MAINS) {
            if (bankBranchMain.getBranchName().equals(branch.getBranchName())) {
                if (!branch.getBankList().isEmpty()) {
                    for (Bank banks : branch.getBankList()) {
                        {
                            if (banks.getBankName().equals(bank.getBankName())) {
                                System.out.println("Bank already exists in this branch");
                                return false;
                            } else {
                                bankBranchMain.addBankToBranch(bank);
                                return true;
                            }
                        }
                    }
                } else {
                    bankBranchMain.addBankToBranch(bank);
                    return true;
                }
            } else {
                System.out.println("Branch does not exists");
                return false;
            }
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
        if (bankBranchMain.getBranchName().equals(getBranches())) {
            System.out.println("Branch already exists");
            return false;
        }
        AVAILABLE_BANK_BRANCH_MAINS.add(bankBranchMain);
        return true;
    }

    private String getBranches() {
        for (BankBranchMain branch : AVAILABLE_BANK_BRANCH_MAINS) {
            return branch.getBranchName();
        }
        return null;
    }


}
