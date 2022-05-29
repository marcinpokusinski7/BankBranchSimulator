package bankbranch;

import java.util.ArrayList;
import java.util.List;

import static bankbranch.Bank.AVAILABLE_BANKS;

public class BanksManager {
    public static List<BankBranchMain> AVAILABLE_BANK_BRANCH_MAINS = new ArrayList<>();


    public boolean addBankToBranch(Bank bank, BankBranchMain bankBranchMain) {
        for (BankBranchMain branch : AVAILABLE_BANK_BRANCH_MAINS) {
            if (branch.getBranchName().equals(bankBranchMain.getBranchName()))
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


    public void printBanks() {
        for (int i = 0; i < AVAILABLE_BANKS.size(); i++) {
            System.out.println(i + " - "
                    + " " + AVAILABLE_BANKS.get(i).getBankName()
                    + ", " + AVAILABLE_BANKS.get(i).getBankAddress()
                    + ", " + AVAILABLE_BANKS.get(i).getContact());
        }
    }

    public Bank getBank(int index){
       return AVAILABLE_BANKS.get(index);
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
