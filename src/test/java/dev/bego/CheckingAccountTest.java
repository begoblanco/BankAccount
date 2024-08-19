package dev.bego;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CheckingAccountTest {
    private CheckingAccount checkingAccount;

    @BeforeEach
    public void setUp() {
        checkingAccount = new CheckingAccount(10000, 0.05f); 
    }

    @Test
    public void testWithdrawWithOverdraft() {
        checkingAccount.withdraw(12000); 
        assertEquals(2000, checkingAccount.getOverdraft(), 0.001);
        assertEquals(0, checkingAccount.getBalance(), 0.001); 
    }

    @Test
    public void testDepositReducesOverdraft() {
        checkingAccount.withdraw(12000); 
        checkingAccount.deposit(1000); 
        assertEquals(1000, checkingAccount.getOverdraft(), 0.001);
        assertEquals(0, checkingAccount.getBalance(), 0.001); 
    }

    @Test
    public void testDepositClearsOverdraft() {
        checkingAccount.withdraw(12000); 
        checkingAccount.deposit(2500); 
        assertEquals(0, checkingAccount.getOverdraft(), 0.001);
        assertEquals(500, checkingAccount.getBalance(), 0.001); 
    }


}
