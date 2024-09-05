import spock.lang.Specification

class CalculatorSpec extends Specification {
    def "should add two numbers correctly"() {

        given: "a calculator"
        def calculator = new Calculator()

        when: "adding two numbers"
        def result = calculator.add(2,3)

        then:"the result is the sum of the numbers"
        result == 5
    }
}