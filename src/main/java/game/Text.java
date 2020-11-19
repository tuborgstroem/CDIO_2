package game;

import gui_fields.*;
import gui_main.GUI;

public class Text {
    private GUI_Field[] fields;
    private Game game;
    public final Language textStrings;
    private String tileString;
    private GameBoard board;
    private GUI gui;
    private Player player;
    int location;

    public Text(Game game) {
        textStrings = new Language("resources/engFieldText.txt");
        tileString = textStrings.getLine(0);
        this.game = game;
        location = player.getLocation();
    }
    public void TileMessage (Player player) {
        switch (player.getLocation()) {
//            case 1:
//                String message = textStrings.getLine(1);
//                displayMessage(message);
//                break;
            case 2:
                String message = textStrings.getLine(2);
                displayMessage(message);
                break;
            case 3:
                message = textStrings.getLine(3);
                displayMessage(message);
                break;
//            case 4:
//                message = textStrings.getLine(4);
//                displayMessage(message);
//                break;
            case 5:
                message = textStrings.getLine(5);
                displayMessage(message);
                break;
            case 6:
                message = textStrings.getLine(6);
                displayMessage(message);
                break;
//            case 7:
//                message = textStrings.getLine(7);
//                displayMessage(message);
//                break;
            case 8:
                message = textStrings.getLine(8);
                displayMessage(message);
                break;
            case 9:
                message = textStrings.getLine(9);
                displayMessage(message);
                break;
//            case 10:
//                message = textStrings.getLine(10);
//                displayMessage(message);
//                break;
            case 11:
                message = textStrings.getLine(11);
                displayMessage(message);
                break;
            case 12:
                message = textStrings.getLine(12);
                displayMessage(message);
                break;
//            case 13:
//                message = textStrings.getLine(13);
//                displayMessage(message);
//                break;
            case 14:
                message = textStrings.getLine(14);
                displayMessage(message);
                break;
            case 15:
                message = textStrings.getLine(15);
                displayMessage(message);
                break;
//            case 16:
//                message = textStrings.getLine(16);
//                displayMessage(message);
//                break;
            case 17:
                message = textStrings.getLine(17);
                displayMessage(message);
                break;
            case 18:
                message = textStrings.getLine(18);
                displayMessage(message);
                break;
//            case 19:
//                message = textStrings.getLine(19);
//                displayMessage(message);
//                break;
            case 20:
                message = textStrings.getLine(20);
                displayMessage(message);
                break;
            case 21:
                message = textStrings.getLine(21);
                displayMessage(message);
                break;
//            case 22:
//                message = textStrings.getLine(22);
//                displayMessage(message);
//                break;
            case 23:
                message = textStrings.getLine(23);
                displayMessage(message);
                break;
            case 24:
                message = textStrings.getLine(24);
                displayMessage(message);
                break;
        }
    }
    private void displayMessage(String message) {
        getGui().displayChanceCard(message);

        getGui().showMessage(tileString);
    }
    
        public GameBoard getBoard() {
            return board;
        }
        


    public GUI getGui() {
        return gui;
    }
    
}
