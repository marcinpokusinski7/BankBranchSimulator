import account.AccountManager
import bankbranch.Bank
import spock.lang.Specification

class AccountManagerTest extends Specification{
    def "checkLastTransactionsForUsers"() {
        given:
        def accountManager = new AccountManager();
        def bank = Bank.createNewBank("Bank", "glowny", "email")
        def userFirst = new AccountManager().createUserAccount("Test", 100.0,"123123123", bank);
        def userSecond = new AccountManager().createUserAccount("Test", 100.0,"123123143", bank);

        when:
        accountManager.transferMoney(userFirst, userSecond, 50);
        accountManager.depositMoneyToAccount(userFirst, 150);

        then:
        accountManager.transactionList(userFirst).stream().count() == 2
    }

    def "Check the negative amount of money transfer"() {
        given:
        def bank = Bank.createNewBank("Bank", "glowny", "email")
        def accountManager = new AccountManager();
        def userFirst = new AccountManager().createUserAccount("Test", 100.0,"123123123", bank);
        def userSecond = new AccountManager().createUserAccount("Test", 100.0,"123123123", bank);

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
        account.createUserAccount("Test", 2.0 ,"123123123",  bank)

        then:
        bank.getUserAccounts().forEach(x -> x.accountOwner == "Test")
    }

    def "Deposit money to account"() {
        given:
        def account = new AccountManager().createUserAccount("Test", 100.0, "123123123", Bank.createNewBank("Bank", "glowny","email"))
        def accountManager = new AccountManager()

        when:
        accountManager.depositMoneyToAccount(account, 100);

        then:
        account.getBalance() == 200;
    }

    def "Withdraw money from account"(){
        given:
        def account = new AccountManager().createUserAccount("Test", 100.0,"123123123",  Bank.createNewBank("Bank", "glowny","email"))
        def accountManager = new AccountManager()

        when:
        accountManager.withdrawMoneyFromAccount(account, 100);


        then:
        account.getBalance() == 0;
    }
    def "Cannot transfer to the same account"(){
        given:
        def account = new AccountManager().createUserAccount("Test", 100.0,"123123123",  Bank.createNewBank("Bank", "glowny","email"))
        def accountSecond = new AccountManager().createUserAccount("Test", 100.0,"123123123",  Bank.createNewBank("Bank", "glowny","email"))
        def accountManager = new AccountManager()

        when:
        var value = accountManager.transferMoney(account, accountSecond, 50);


        then:
        !value
    }

}
