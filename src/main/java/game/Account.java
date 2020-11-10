package game;

public class Account {
    int balance;

    public Account(int V)
    {
        balance = V;
    }

    public int getBalance()
    {
        return balance;
    }

    public void setBalance(int amount)
    {
        balance=amount;
        if (balance < 0) balance = 0;
    }
    

    public void withdraw(int amount)
    {
        if (amount > 0) {
            if (amount > balance) {
                System.out.println("Can't withdraw, not enough funds. Available: "+balance);
            } else {
                balance -= amount;
            }
        }

    }

    public void deposit(int amount)
    {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Amount deposited must be higher than 0.");
        }
    }


}


