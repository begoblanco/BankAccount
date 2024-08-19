package dev.bego;

public class Account {
    protected float balance;
    protected int numberOfDeposits;
    protected int numberOfWithdrawals;
    protected float annualInterestRate;
    protected float monthlyServiceCharge;

    public Account(float balance, float annualInterestRate) {
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
        this.numberOfDeposits = 0;
        this.numberOfWithdrawals = 0;
        this.monthlyServiceCharge = 0.0f;
    }

    public void deposit(float amount) {
        this.balance += amount;
        this.numberOfDeposits++;
    }

    public void withdraw(float amount) {
        if (amount <= this.balance) {
            this.balance -= amount;
            this.numberOfWithdrawals++;
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public void calculateMonthlyInterest() {
        float monthlyInterestRate = this.annualInterestRate / 12;
        float monthlyInterest = this.balance * monthlyInterestRate;
        this.balance += monthlyInterest;
    }

    public void monthlyProcess() {
        this.balance -= this.monthlyServiceCharge;
        this.calculateMonthlyInterest();
        this.monthlyServiceCharge = 0;
    }
    

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public int getNumberOfDeposits() {
        return numberOfDeposits;
    }

    public void setNumberOfDeposits(int numberOfDeposits) {
        this.numberOfDeposits = numberOfDeposits;
    }

    public int getNumberOfWithdrawals() {
        return numberOfWithdrawals;
    }

    public void setNumberOfWithdrawals(int numberOfWithdrawals) {
        this.numberOfWithdrawals = numberOfWithdrawals;
    }

    public float getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(float annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public float getMonthlyServiceCharge() {
        return monthlyServiceCharge;
    }

    public void setMonthlyServiceCharge(float monthlyServiceCharge) {
        this.monthlyServiceCharge = monthlyServiceCharge;
    }

    public void print() {
        System.out.println("Balance: " + this.balance);
        System.out.println("Number of deposits: " + this.numberOfDeposits);
        System.out.println("Number of withdrawals: " + this.numberOfWithdrawals);
        System.out.println("Annual interest rate: " + this.annualInterestRate);
        System.out.println("Monthly service charge: " + this.monthlyServiceCharge);
    }
    
}
