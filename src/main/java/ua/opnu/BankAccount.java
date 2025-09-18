package ua.opnu;

public class BankAccount {
    String name;
    double balance;
    double transactionFee = 0;

    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    double getBalance() {
        return balance;
    }

    boolean withdraw(double amount) {
        if (amount > 0) {
            double totalAmount = amount + transactionFee;
            if (totalAmount <= balance) {
                balance -= totalAmount;
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    boolean transfer(BankAccount receiver, double amount) {
        if (amount > 0) {
            double totalAmount = amount + transactionFee;
            if (totalAmount <= balance) {
                balance -= totalAmount;
                receiver.deposit(amount);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}