import bankbranch.Bank
import bankbranch.BankBranch
import bankbranch.ManageBanks
import spock.lang.Specification

class ManageBanksTest extends Specification{

    def "Test method add bank to branch"() {
        given:
        def bankBranch = BankBranch.createBankBranch("Test branch")
        def bank = Bank.createNewBank("Test", "test2", "test3")
        def manager = new ManageBanks();

        when:
        manager.addBranch(bankBranch)
        def isValid = manager.addBankToBranch(bank, bankBranch);

        then:
        isValid
    }

    def "Add Branch to collection"() {
        given:
        def bankBranch = BankBranch.createBankBranch("Second test branch")
        def manager = new ManageBanks();

        when:
        def isValid = manager.addBranch(bankBranch);

        then:
        isValid
    }
}
