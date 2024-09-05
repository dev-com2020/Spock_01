import spock.lang.Specification

class BankAccountSpec extends Specification {
    def "should throw exception with a balance of 100"(){
        given: "a bank account with balance 100"
        def account = new BankAccount()
        account.deposit(100)

        when: "withdrawing an amount greater than the balance"
        account.withdraw(150)

        then: "an exception is thrown"
        def e = thrown(IllegalArgumentException)
        e.message == "Niewystarczajace saldo"
    }
}
