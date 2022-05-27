import bankbranch.BankBranchMain
import spock.lang.Specification

class BankBranchMainTest extends Specification{
    def "Unique id of bank branch should be generated"() {
        given:
        def bankBranch = new BankBranchMain("Bank1")

        when:
        def newBankBranch = new BankBranchMain("Bank1")

        then:
        bankBranch.getId() != newBankBranch.getId()
    }

}
