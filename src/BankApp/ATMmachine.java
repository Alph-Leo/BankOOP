package BankApp;


import javax.swing.*;

public class ATMmachine {
    private static final Bank accessBank = new Bank("Access Bank");
    public static void main(String[] args) {
        displayMainMenu();
    }
    private static void displayMainMenu(){
        String mainMenu = """
                Welcome to Access Bank
                1 -> Create Account
                2 -> Deposit
                3 -> Withdraw
                4 -> Transfer
                5 -> Check Balance
                6 -> Exit
                """;
        //System.out.println(mainMenu);
        //Scanner scanner = new Scanner(System.in);
        String userInput = input(mainMenu);
        switch (userInput.charAt(0)) {
            case '1' -> createAccount();
            case '2' -> deposit();
            case '3' -> withdraw();
            case '4' -> transfer();
            case '5' -> checkBalance();
            case '6' -> System.exit(14);
            default -> {
                System.out.println("Wrong entry. Please try again");
                displayMainMenu();
            }
        }
    }



    private static void checkBalance() {
        int accountNumber = Integer.parseInt(input("What is your account number?"));
        String pin = input("Enter pin");
        int balance = accessBank.checkBalanceFor(accountNumber,pin);
        display("Your balance is " + balance);
        displayMainMenu();
    }


    private static void createAccount(){
        String accountName = input("What is the account name?"); //1. collect account name
        String accountPin = input("What is the account pin?"); //2. collect account pin

        //create account from bank

        accessBank.createAccountFor("Legend","1234");
        display("Account created successfully");


        //3. collect account from bank
        displayMainMenu();
    }

    private static void deposit(){
        int accountNumber = Integer.parseInt(input("What is your account number?"));
        int amount  = Integer.parseInt(input("How much do you want to deposit?"));

        accessBank.deposit(amount,accountNumber);
        display("Deposited successfully");
        displayMainMenu();
    }

    private static void withdraw() {
        int amount = Integer.parseInt(input("How much do you want to withdraw?"));
        int accountNumber = Integer.parseInt(input("What is your account number?"));
        String pin = input("Enter PIN");

        accessBank.withdrawMoney(amount,accountNumber,pin);
        display("Withdrawal successful");
        displayMainMenu();

    }

    private static void transfer() {
        int amount = Integer.parseInt(input("How much do you want to transfer?"));
        int senderAccountNumber = Integer.parseInt(input("What is your account number?"));
        int receiverAccountNumber = Integer.parseInt(input("Please enter beneficiary account number"));
        String senderPin = input("Enter PIN");
        accessBank.transfer(amount,senderAccountNumber,receiverAccountNumber,senderPin);
        display("Transfer Successful");
        displayMainMenu();
    }

    private static String input(String prompt) {
        return JOptionPane.showInputDialog(prompt);
    }
    private static void display(String message) {
        JOptionPane.showMessageDialog(null, message);

    }

    private static void print(String message) {
        System.out.println(message);
    }
}
