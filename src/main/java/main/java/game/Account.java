package main.java.game;

public class Account {

    private int score = 1000;

        public int addScore(int point){
            this.score += point;
            if (this.score < 0)
                this.score = 0;
            return this.score;
        }

        public int getScore(){
            return this.score;
        }
        public void setScore(int score){
            this.score = score;
            if (this.score < 0)
                this.score = 0;
        }
    }



