public class BankAccount {
    private double balance;

    public void withdraw(double amount){
        if (amount > balance){
            throw new IllegalArgumentException("Niewystarczajace saldo");
        }
        balance -= amount;
    }
    public void deposit(double amount){
        balance += amount;
    }
}
