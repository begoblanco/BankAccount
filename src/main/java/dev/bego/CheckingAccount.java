package dev.bego;

public class CheckingAccount extends Account{
    private float overdraft;

    public CheckingAccount(float balance, float annualInterestRate) {
        super(balance, annualInterestRate);
        this.overdraft = 0.0f;
    }

    @Override
    public void withdraw(float amount) {
        if (amount <= this.balance) {
            super.withdraw(amount);
        } else {
            this.overdraft += (amount - this.balance);
            this.balance = 0;
            this.numberOfWithdrawals++;
        }
    }

    @Override
    public void deposit(float amount) {
        if (this.overdraft > 0) {
            if (amount >= this.overdraft) {
                amount -= this.overdraft;
                this.overdraft = 0.0f;
            } else {
                this.overdraft -= amount;
                amount = 0;
            }
        }
        super.deposit(amount);
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Overdraft: " + this.overdraft);
    }
}
