public class BankAccount {
    private double balance;

    public void withdraw(double amount){
        if (amount > balance){
            throw new IllegalArgumentException("Niewystarczające saldo");
        }
        balance -= amount;
    }
}
