package dev.bego;

public class SavingsAccount extends Account {
    private boolean isActive;

    public SavingsAccount(float balance, float annualInterestRate) {
        super(balance, annualInterestRate);
        this.isActive = balance >= 10000;
    }

    @Override
    public void deposit(float amount) {
        if (this.isActive) {
            super.deposit(amount);
        } else {
            System.out.println("Account is inactive. Cannot deposit.");
        }
        this.checkStatus();
    }

    @Override
    public void withdraw(float amount) {
        if (this.isActive) {
            super.withdraw(amount);
        } else {
            System.out.println("Account is inactive. Cannot withdraw.");
        }
        this.checkStatus();
    }

    @Override
    public void monthlyProcess() {
        if (this.numberOfWithdrawals > 4) {
            this.monthlyServiceCharge += (this.numberOfWithdrawals - 4) * 1000;
        }
        super.monthlyProcess();
        this.checkStatus();
    }

    private void checkStatus() {
        this.isActive = this.balance >= 10000;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Account active: " + this.isActive);
    }
}