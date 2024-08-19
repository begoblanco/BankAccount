package dev.bego;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SavingsAccountTest {
    private SavingsAccount savingsAccount;

    @BeforeEach
    public void setUp() {
        savingsAccount = new SavingsAccount(15000, 0.05f); 
    }

    @Test
    public void testAccountActivation() {
        assertTrue(savingsAccount.isActive());
        savingsAccount.withdraw(6000);
        assertFalse(savingsAccount.isActive()); 
    }

    @Test
    public void testDepositWhenInactive() {
        savingsAccount.withdraw(6000); 
        assertFalse(savingsAccount.isActive());
        savingsAccount.deposit(2000); 
        assertTrue(savingsAccount.isActive());
        assertEquals(11000, savingsAccount.getBalance(), 0.001);
    }

    @Test
    public void testWithdrawWhenInactive() {
        savingsAccount.withdraw(6000);
        assertEquals(9000, savingsAccount.getBalance(), 0.001);
    }

    @Test
    public void testMonthlyStatementWithExtraWithdrawals() {
        for (int i = 0; i < 5; i++) {
            savingsAccount.withdraw(1000); // 5 retiros
        }
        savingsAccount.setMonthlyServiceCharge(50);
        savingsAccount.monthlyProcess();
        assertEquals(8987.29, savingsAccount.getBalance(), 0.01); 
    }

}


