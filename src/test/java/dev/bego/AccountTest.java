package dev.bego;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {
    private Account account;

    @BeforeEach
    public void setUp() {
        account = new Account(10000, 0.05f); 
    }

    @Test
    public void testDeposit() {
        account.deposit(5000);
        assertEquals(15000, account.getBalance(), 0.001);
        assertEquals(1, account.getNumberOfDeposits());
    }

    @Test
    public void testWithdraw() {
        account.withdraw(3000);
        assertEquals(7000, account.getBalance(), 0.001);
        assertEquals(1, account.getNumberOfWithdrawals());
    }

    
    @Test
    public void testWithdrawOverBalance() {
        account.withdraw(15000);
        assertEquals(10000, account.getBalance(), 0.001); 
        assertEquals(0, account.getNumberOfWithdrawals()); 
    }

    @Test
    public void testCalculateMonthlyInterest() {
        account.calculateMonthlyInterest();
        assertEquals(10041.67, account.getBalance(), 0.01); 
    }

    @Test
    public void testMonthlyStatement() {
        account.setMonthlyServiceCharge(100); 
        account.monthlyProcess();
        assertEquals(9941.25, account.getBalance(), 0.01); 
    }

    @Test
    public void testPrint() {

        assertDoesNotThrow(() -> account.print());
    }
}