import bankbranch.BankBranch
import spock.lang.Specification

class BankBranchTest extends Specification {
    def "Check if bank is unique"() {
        given:
        def bankBranch = new BankBranch( "Bank Pekao SA", "Ul. Smutna")

        when:
        def newBankBranch = new BankBranch("Bank Pekao SA", "Ul. Smutna")

        then:
        bankBranch.id != newBankBranch.id
    }

}
