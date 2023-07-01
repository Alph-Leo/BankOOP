package BankApp;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SavingsAccountTest {
    SavingsAccount account;
    @BeforeEach
    void setUp() {
        account = new SavingsAccount(1, "Legends", "1234");
    }

    @Test
    public void depositTest() {
        account.deposit(1500);
        assertEquals(1500, account.checkBalance("1234"));
    }
    @Test
    void depositNegativeAmountDoesNotWorkTest(){
        account.depositNegativeAmount(-1200);
        assertEquals(0,account.checkBalance("1234"));
    }
    @Test
    void checkBalanceWithWrongPinReturnsZeroTest(){
        account.deposit(1500);
        assertEquals(0, account.checkBalance("3694"));
    }
    @Test
    void withdrawMoneyTest(){
        account.deposit(1500);
        account.withdraw(1000,"1234");
        assertEquals(500, account.checkBalance("1234"));
    }
    @Test
    void withdrawMoneyWithWrongPinDoesNotWork(){
        account.deposit(5000);
        account.withdraw(2000,"3694");
        assertEquals(5000, account.checkBalance("1234"));
    }


}