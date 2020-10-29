package game;

public class Account {
    int score;

    public Account(int V)
    {
        score = V;
    }

    public int getScore()
    {
        return score;
    }

    public void setScore(int nyScore)
    {
        score=nyScore;
    }

    public int tilføjScore(int indskud)
    {
        return score = score + indskud;
    }

    public int hævScore(int fradrag)
    {
        score = score - fradrag;
        if (score < 0)
            score = 0;
        return score;
    }

}


