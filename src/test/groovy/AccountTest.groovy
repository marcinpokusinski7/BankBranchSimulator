import account.Account
import exceptions.BalanceCannotBeNegativeException
import bankbranch.Bank
import spock.lang.Specification

class AccountTest extends Specification{
    def "Check if account can be created with negative balance"() {
        when:
        new Account("Marcin Test", -100.00, "123123123",Bank.createNewBank("Testowy", "lota 40", "791 974 794"))

        then:
        thrown(BalanceCannotBeNegativeException.class)
    }
}
