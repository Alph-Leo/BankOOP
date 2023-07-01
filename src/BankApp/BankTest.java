package BankApp;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {
    Bank AccessBank;

    @BeforeEach
    void startWithThis(){
        AccessBank = new Bank("Access Bank");
        AccessBank.createAccountFor("Legends", "1234");
    }

    @Test
    void createAccount() {
        Bank AccessBank = new Bank("Access Bank");
    }
    @Test
    void checkBalanceOfNewAccountIsZeroByDefaultTest(){
        assertEquals(0, AccessBank.checkBalanceFor(1,"1234"));
    }
    @Test
    void depositCheckBalanceTest(){
        AccessBank.deposit(1500, 1);
        assertEquals(1500, AccessBank.checkBalanceFor(1,"1234"));
    }
    @Test
    void transferMoneyTest(){
        AccessBank.createAccountFor("Inemesit", "receiverPin");
        AccessBank.deposit(4500,1);
        AccessBank.transfer(2000, 1, 2, "1234");
        assertEquals(2500, AccessBank.checkBalanceFor(1,"1234"));
        assertEquals(2000, AccessBank.checkBalanceFor(2,"receiverPin"));
    }
    @Test
    void withdrawMoneyTest(){
        AccessBank.deposit(5000,1);
        AccessBank.withdrawMoney(2000,1,"1234");
        assertEquals(3000,AccessBank.checkBalanceFor(1,"1234"));

    }
    @Test
    void withdrawMoneyAboveBalance(){
        AccessBank.deposit(5000,1);
        AccessBank.withdrawMoney(7500,1,"1234");
        assertEquals(5000,AccessBank.checkBalanceFor(1, "1234"));
    }
    @Test
    void withdrawNegativeAmount(){
        AccessBank.deposit(5000,1);
        AccessBank.withdrawNegativeAmount(-3000,1,"1234");
        assertEquals(5000,AccessBank.checkBalanceFor(1,"1234"));
    }


}