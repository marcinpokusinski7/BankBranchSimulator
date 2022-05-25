package bankbranch;

import java.util.ArrayList;
import java.util.List;

public class ManageBanks {
    private final List<BankBranch> availableBankBranches = new ArrayList<>();


    public boolean addBankToBranch(Bank bank, BankBranch bankBranch) {
        for (BankBranch branch : availableBankBranches) {
            if (bankBranch.getBranchName().equals(branch.getBranchName())) {
                if (!branch.getBankList().isEmpty()) {
                    for (Bank banks : branch.getBankList()) {
                        {
                            if (banks.getBankName().equals(bank.getBankName())) {
                                System.out.println("Bank already exists in this branch");
                                return false;
                            } else {
                                bankBranch.addBankToBranch(bank);
                                return true;
                            }
                        }
                    }
                } else {
                    bankBranch.addBankToBranch(bank);
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
        for (BankBranch i : availableBankBranches) {
            System.out.println("branch " + i.getBranchName());
            for (Bank j : i.getBankList()) {
                System.out.printf("Banks: " + j.getBankName() + " " + j.getBankAddress() + " " + j.getContact());
            }
        }
    }

    public boolean addBranch(BankBranch bankBranch) {
        if (bankBranch.getBranchName().equals(getBranches())) {
            System.out.println("Branch already exists");
            return false;
        }
        availableBankBranches.add(bankBranch);
        return true;
    }

    private String getBranches() {
        for (BankBranch branch : availableBankBranches) {
            return branch.getBranchName();
        }
        return null;
    }
}
