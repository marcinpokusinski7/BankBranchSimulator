import account.Account
import account.BalanceCannotBeNegativeException
import bankbranch.Bank
import spock.lang.Specification

class AccountTest extends Specification{
    def "Check if account can be created with negative balance"() {
        when:
        def userAccount = new Account("Marcin Test", -100.00, Bank.createNewBank("Testowy", "lota 40", "791 974 794"))

        then:
        thrown(BalanceCannotBeNegativeException.class)
    }
}
