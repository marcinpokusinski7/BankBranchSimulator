import account.AccountManager
import bankbranch.Bank
import spock.lang.Specification

class AccountManagerTest extends Specification{
    def "Check the negative amount of money transfer"() {
        given:
        def bank = Bank.createNewBank("Bank", "glowny", "email")
        def accountManager = new AccountManager();
        def userFirst = new AccountManager().createUserAccount("Test", 100.0, bank);
        def userSecond = new AccountManager().createUserAccount("Test", 100.0, bank);

        when:
        boolean check = accountManager.transferMoney(userFirst, userSecond, -50.00)

        then:
        !check

    }

    def "Add Account to existing Bank"() {
        given:
        def bank = Bank.createNewBank("Bank", "glowny", "email")
        def account = new AccountManager()

        when:
        account.createUserAccount("Test", 2.0 , bank)

        then:
        bank.getUserAccounts().forEach(x -> x.accountOwner == "Test")
    }

}
