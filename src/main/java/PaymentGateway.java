public interface PaymentGateway {
    boolean process(double amount);
}
