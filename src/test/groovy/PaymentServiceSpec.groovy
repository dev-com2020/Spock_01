import spock.lang.Specification

class PaymentServiceSpec extends Specification {

    def "should process payment through gateway"(){

        given: "a mock payment gateway"
        def gateway = Mock(PaymentGateway)
        def paymentService = new PaymentService(gateway)

        when: "processing a payment"
        paymentService.proccessPayment(100.0);

        then: "the payment is processed through the gateway"
        1 * gateway.process(100.0) >> true
    }
}
