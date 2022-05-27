import bankbranch.Bank
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
