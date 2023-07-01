package BankApp;


public class SavingsAccount {
    private int balance;
    private String pin;
    private int accountNumber;
    private String accountName;

    public SavingsAccount(int accountNumber, String accountName, String pin) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.pin = pin;

    }

    public int deposit (int amount) {
        if (amount > 0) {
            balance+= amount;
        }
        else {
            return balance;
        }
        return 0;
    }

    public int checkBalance(String pin) {
        if (pinIsCorrect(pin)) return balance;
        return 0;
    }

    private boolean pinIsCorrect(String pin) {
        return this.pin.equals(pin);
    }

    public void withdraw(int amount, String pin) {
        if(pinIsCorrect(pin) && (balance >= amount) && (amount > 0)) balance -= amount;
    }

    public int getAccountNumber(){
        return accountNumber;
    }

    public int getBalance () {
        return balance;
    }

    public int depositNegativeAmount(int amount) {
        if (amount < 0) return balance;

        return 0;
    }
}
