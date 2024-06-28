package lab7.question1;

abstract class BankAccount {
    protected double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);

    public double getBalance() {
        return balance;
    }
}

class SavingsAccount extends BankAccount {
    public SavingsAccount(double balance) {
        super(balance);
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit of $" + amount + " into savings account successful.");
    }

    @Override
    public void withdraw(double amount) {
        if (balance - amount >= 0) {
            balance -= amount;
            System.out.println("Withdrawal of $" + amount + " from savings account successful.");
        } else {
            System.out.println("Insufficient funds in savings account.");
        }
    }
}

class CurrentAccount extends BankAccount {
    private double overdraftLimit;

    public CurrentAccount(double balance, double overdraftLimit) {
        super(balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit of $" + amount + " into current account successful.");
    }

    @Override
    public void withdraw(double amount) {
        if (balance + overdraftLimit - amount >= 0) {
            balance -= amount;
            System.out.println("Withdrawal of $" + amount + " from current account successful.");
        } else {
            System.out.println("Insufficient funds in current account.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Example usage
        SavingsAccount savingsAccount = new SavingsAccount(1000);
        savingsAccount.deposit(500);
        savingsAccount.withdraw(3000);

        CurrentAccount currentAccount = new CurrentAccount(2000, 1000);
        currentAccount.withdraw(3000);
        currentAccount.deposit(200);
        currentAccount.withdraw(3000);
    }
}