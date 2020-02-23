package Std_Version;

public class Account {

    public double balance;
    public int accountNumber;

    public Account(double initialBalance, int accountNumber) {

        if (initialBalance < 0) {
            throw new IllegalArgumentException(
                    "Accounts with a negative balance cannot be created!");
        }

        if (accountNumber < 10000 || accountNumber > 99999) {
            throw new IllegalArgumentException(
                    "Account numbers must be 5 digits and positive.");
        }

        balance = initialBalance;
        this.accountNumber = accountNumber;

    }

    public void deposit(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException(
                    "Don't deposit negative amounts!");
        }
        balance = balance + amount;
    }

    public void withdraw(double amount) {

        if (amount > balance) {
            throw new IllegalArgumentException("Don't withdraw too much!");
        }
        if (amount < 0) {
            throw new IllegalArgumentException(
                    "Don't withdraw a negative amount!");
        }
        balance = balance - amount;

    }

    public double getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String toString() {
        return "" + accountNumber + " ₺" + balance;
    }
}
