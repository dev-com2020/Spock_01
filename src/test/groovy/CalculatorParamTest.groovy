import spock.lang.Specification
import spock.lang.Unroll

class CalculatorParamTest extends Specification {

    @Unroll
    def "should return correct product for #a * #b"() {
        given: "a calculator"
        def calculator = new Calculator()

        expect: "the correct product is returned"
        calculator.multiply(a, b) == result

        where:
        a   |   b   ||  result
        2   |   3   ||  6
        4   |   5   ||  20
        7   |   8   ||  56
    }

}
