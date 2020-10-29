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

    public void setBalance(int input)
    {
        balance=input;
        if (balance < 0) balance = 0;
    }

    public int addToBalance(int input)
    {
        balance += input;
        if (balance < 0) balance = 0;
        return balance;
    }
}


