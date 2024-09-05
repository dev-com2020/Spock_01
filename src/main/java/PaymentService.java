public class PaymentService {
    private final PaymentGateway gateway;

    public PaymentService(PaymentGateway gateway){
        this.gateway = gateway;
    }

    public boolean proccessPayment(double amount){
        return gateway.process(amount);
    }
}
