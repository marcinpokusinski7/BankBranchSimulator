import account.Account
import bankbranch.Bank
import bankbranch.BankBranch
import bankbranch.BanksManager
import spock.lang.Specification

class AccountManagerTest extends Specification{
    def "Add Account to existing Bank"() {
        given:
        def bankBranch = BankBranch.createBankBranch("Odział główny")
        def bank = Bank.createNewBank("Bank", "glowny", "email")
        def manager = new BanksManager();
        manager.addBankToBranch(bank, bankBranch);
        Account userAccount = new Account("Marcin Test", 100.00, Bank.createNewBank("Testowy", "lota 40", "791 974 794"))

        when:
        boolean test = Account.createUserAccount(bank, userAccount)

        then:
        test
    }

}
