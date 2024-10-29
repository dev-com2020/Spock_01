import spock.lang.Specification

class CalculatorSpec extends Specification {
    def "test addition and mocked multi using Spy"() {
        given:
        Calculator calculator = Spy(Calculator)

        when:
        int additionalResult = calculator.add(3,4)
        int multiResutl = calculator.multiply(5,5)

        then:
        additionalResult == 7
        multiResutl == 100

        1 * calculator.add(3,4)
        1 * calculator.multiply(_,_) >> 100
    }
}