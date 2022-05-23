package bankbranch;

public class BankBranch {
    public static int nextId = 1;
    public int id;
    public String bankName;
    public String bankAddress;

    public BankBranch(String bankName, String bankAddress) {
        this.id = nextId++;
        this.bankName = bankName;
        this.bankAddress = bankAddress;
    }

    public BankBranch() {
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
}
