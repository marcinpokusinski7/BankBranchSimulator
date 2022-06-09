import account.Account
import bankbranch.Bank
import exceptions.BalanceCannotBeNegativeException
import spock.lang.Specification

class AccountTest extends Specification{
    def "Check if account can be created with negative balance"() {
        when:
        new Account("Marcin Test", -100.00, "123123123",Bank.createNewBank("Testowy", "lota 40", "791 974 794"))

        then:
        thrown(BalanceCannotBeNegativeException.class)
    }

    def "checkAddedTransactions"() {
        when:
        def account = new Account("Marcin Test", 100.00, "123123123",Bank.createNewBank("Testowy", "lota 40", "791 974 794"))
        account.transactionAdd("Transaction created")

        then:
        account.getTransaction().stream().findFirst().get().toString() == "Transaction created"
    }
}
