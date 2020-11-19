package game;

import java.util.Random;

public class ChanceCards {
    public final Language chanceCardsStrings;
    private Game game;
    private String defString ;
    private Random rand;
    public ChanceCards(Game game){
        chanceCardsStrings = new Language("resources/engChancecard.txt");
        defString = chanceCardsStrings.getLine(0);
        this.game = game;
        rand = new Random();
    }

    public void DrawCard(Player player){

//        int a = rand.nextInt(9);
        int a = 7;
        switch (a){
            case(0):
                moveToStart(player);
                break;
            case(1):
                move5Tiles(player);
                break;
            case(2):
                tooMuchCandy(player);
                break;
            case(3):
                homeworkDone(player);
                break;
            case(4):
                getOutOfJailFree(player);
                break;
            case(5):
                birthday(player);
                break;
            case(6):
                getFreeTileOneColor(player);
                break;
            case(7):
                moveToLastTile(player);
                break;
            case(8):
                getFreeTileTwoColors(player);
                break;
        }


    }

    private void moveToStart(Player player){
        System.out.println("moveToStart");
        String message = chanceCardsStrings.getLine(1);
        displayMessage(message);
        int location = player.getLocation();
        int moveNum = game.getNumberOfTiles() - location;
        player.moveLocation(moveNum, game);

    }

    private void move5Tiles(Player player){
        System.out.println("move5");
        String message = chanceCardsStrings.getLine(2);
        displayMessage(message);
        player.moveLocation(5, game);
    }

    private void tooMuchCandy(Player player){
        System.out.println("Candy");
        String message = chanceCardsStrings.getLine(3);
        displayMessage(message);
        if (!player.withdrawFromBalance(2)){
            System.out.println("LOOSER!!");
        }
    }

    private void homeworkDone(Player player){
        System.out.println("homework");
        String message = chanceCardsStrings.getLine(4);
        displayMessage(message);
        player.addToBalance(2);
    }

    private void birthday(Player player){
        System.out.println("b-day");
        String message = chanceCardsStrings.getLine(5);
        displayMessage(message);
    }

    private void getOutOfJailFree(Player player){
        System.out.println("white man card");
        String message = chanceCardsStrings.getLine(6);
        displayMessage(message);
    }

    private void getFreeTileOneColor(Player player){
        System.out.println("Free one");
        String message = chanceCardsStrings.getLine(7);
        displayMessage(message);
    }



    private void moveToLastTile(Player player){
        int maxNum = game.getNumberOfTiles();
        System.out.println("movelast");
        String message = chanceCardsStrings.getLine(8);
        message= message.replace("[Last Tile]", game.getBoard().getTile(maxNum-1).getGui_field().getDescription());
        int moveNum = maxNum- player.getLocation() -1;
        displayMessage(message);
        player.moveLocation(moveNum, game);

    }

    private void getFreeTileTwoColors(Player player){
        System.out.println("free two");
        String message = chanceCardsStrings.getLine(1);
        displayMessage(message);
    }

    private void displayMessage(String message){
        game.getGui().displayChanceCard(message);
        game.getGui().showMessage(defString);
        game.getGui().displayChanceCard(" ");
    }
}
