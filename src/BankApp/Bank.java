package BankApp;

import javax.swing.*;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class Bank {
    private int lastAccountNumberGenerated;
    private final List<SavingsAccount> accounts;
    private String bankName;

    public  Bank (String bankName) {
        this.bankName = bankName;
        accounts = new ArrayList<>();
    }

    public void createAccountFor(String accountName, String pin) {
        int accountNumber = generateAccountNumber();
        SavingsAccount newAccount = new SavingsAccount(accountNumber, accountName, pin);
        accounts.add(newAccount);
    }

    private int generateAccountNumber() {
//        SecureRandom random = new SecureRandom();
//        int number1 = random.nextInt(100);
//        int number2 = random.nextInt(100);
//        int accountNumber = number1 + number2;
//
//        JOptionPane.showMessageDialog(null, "Your account number is " + accountNumber);
//
//        return accountNumber;
        return ++lastAccountNumberGenerated;
    }

    public int countNumberOfAccount() {
        return accounts.size();
    }
    public int checkBalanceFor(int accountNumber, String pin) {
        SavingsAccount foundAccount = findAccountByAccountNumber(accountNumber);
        return foundAccount.checkBalance(pin);
    }

    public void deposit(int amount, int accountNumber) {
        SavingsAccount foundAccount = findAccountByAccountNumber(accountNumber);
        foundAccount.deposit(amount);
    }

    private SavingsAccount findAccountByAccountNumber(int accountNumber) {
        for(SavingsAccount account: accounts){
            boolean accountNumberMatches = account.getAccountNumber() == accountNumber;
            if(accountNumberMatches) return account;
        }
        return null;
    }

    public void transfer(int amount, int senderAccountNumber, int receiverAccountNumber, String senderPin) {
        SavingsAccount senderAccount = findAccountByAccountNumber(senderAccountNumber);
        SavingsAccount receiverAccount = findAccountByAccountNumber(receiverAccountNumber);
        senderAccount.withdraw(amount, senderPin);
        receiverAccount.deposit(amount);

    }

    public void withdrawMoney(int amount, int accountNumber, String pin) {
        SavingsAccount customerAccountNumber = findAccountByAccountNumber(accountNumber);
        customerAccountNumber.withdraw(amount,pin);
    }

    public int withdrawNegativeAmount(int withdrawAmount, int accountNumber, String pin) {
        SavingsAccount customerAccountNumber = findAccountByAccountNumber(accountNumber);
        customerAccountNumber.withdraw(withdrawAmount,pin);
        if(withdrawAmount < 0 ) {
            return customerAccountNumber.getBalance();
        }
        return 0;
    }
}