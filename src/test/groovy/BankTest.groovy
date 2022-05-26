import account.Account
import bankbranch.Bank
import bankbranch.BankBranch
import bankbranch.BanksManager
import spock.lang.Specification

class BankTest extends Specification{

    def "Unique id of bank should be generated"() {
        given:
        def bank = new Bank("Pekao", "Zlota", "Contact")

        when:
        def newBank = new Bank("Pekao", "Zlota", "Contact")

        then:
        bank.getId() != newBank.getId()
    }
}
