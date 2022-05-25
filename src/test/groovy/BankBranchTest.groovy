import bankbranch.BankBranch
import spock.lang.Specification

class BankBranchTest extends Specification{
    def "Unique id of bank branch should be generated"() {
        given:
        def bankBranch = new BankBranch("Bank1")

        when:
        def newBankBranch = new BankBranch("Bank1")

        then:
        bankBranch.getId() != newBankBranch.getId()
    }

}
