package game;

public class Text {
    private Game game;
    public final Language textStrings;
    private String tileString;
    private GameBoard board;
    private Player[] playerList;

    public Text(Game game) {
        textStrings = new Language("resources/engChancecard.txt");
        tileString = textStrings.getLine(0);
        this.game = game;
    }

     switch (player.getLocation()) {
                    case 1:
                        String message = tileString.getLine(1);
                        displayMessage(message);
                        break;
                    case 2:
                         message = textStrings.getLine(2);
                        displayMessage(message);
                        break;
                    case 3:
                        message = tileString.getLine(3);
                        displayMessage(message);
                        break;
                    case 4:
                        message = tileString.getLine(4);
                        displayMessage(message);
                        break;
                    case 5:
                        message = tileString.getLine(5);
                        displayMessage(message);
                        break;
                    case 6:
                        message = tileString.getLine(6);
                        displayMessage(message);
                        break;
                    case 7:
                        message = tileString.getLine(7);
                        displayMessage(message);
                        break;
                    case 8:
                        message = tileString.getLine(8);
                        displayMessage(message);
                        break;
                    case 9:
                        message = tileString.getLine(9);
                        displayMessage(message);
                        break;
                    case 10:
                        message = tileString.getLine(10);
                        displayMessage(message);
                        break;
                    case 11:
                        message = tileString.getLine(11);
                        displayMessage(message);
                        break;
                    case 12:
                        message = tileString.getLine(12);
                        displayMessage(message);
                        break;
                    case 13:
                        message = tileString.getLine(13);
                        displayMessage(message);
                        break;
                    case 14:
                        message = tileString.getLine(14);
                        displayMessage(message);
                        break;
                    case 15:
                        message = tileString.getLine(15);
                        displayMessage(message);
                        break;
                    case 16:
                        message = tileString.getLine(16);
                        displayMessage(message);
                        break;
                    case 17:
                        message = tileString.getLine(17);
                        displayMessage(message);
                        break;
                    case 18:
                        message = tileString.getLine(18);
                        displayMessage(message);
                        break;
                    case 19:
                        message = tileString.getLine(19);
                        displayMessage(message);
                        break;
                    case 20:
                        message = tileString.getLine(20);
                        displayMessage(message);
                        break;
                    case 21:
                        message = tileString.getLine(21);
                        displayMessage(message);
                        break;
                    case 22:
                        message = tileString.getLine(22);
                        displayMessage(message);
                        break;
                    case 23:
                        message = tileString.getLine(23);
                        displayMessage(message);
                        break;
                    case 24:
                        message = tileString.getLine(24);
                        displayMessage(message);
                        break;
                } 

    private void displayMessage(String message) {
        game.getGui().displayChanceCard(message);

        game.getGui().showMessage(tileString);
    }
    
        public GameBoard getBoard() {
            return board;
        }
        
        public Player[] getPlayerList() { 
        return playerList; 
    }
    
}
