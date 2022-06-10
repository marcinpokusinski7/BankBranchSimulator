import bankbranch.Bank
import bankbranch.BankBranchMain
import bankbranch.BanksManager
import spock.lang.Specification

class BanksManagerTest extends Specification{

    def "Test method add bank to branch"() {
        given:
        def bankBranch = BankBranchMain.createBankBranch("Test branch")
        def bank = Bank.createNewBank("Test", "test2", "test3")
        def manager = new BanksManager();

        when:
        manager.addBranch(bankBranch)
        def isValid = manager.addBankToBranch(bank, bankBranch);

        then:
        isValid
    }

    def "Add Branch to collection"() {
        given:
        def bankBranch = BankBranchMain.createBankBranch("Second test branch")
        def manager = new BanksManager();

        when:
        manager.addBranch(bankBranch);

        then:
        manager.getBranches().stream().anyMatch(x-> x.getBranchName() == bankBranch.getBranchName())

    }
}
