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
        board = game.getBoard();
        gui = game.getGui();
    }


    public void TileMessage (Player player) {
        Player owner = board.getTiles()[player.getLocation()].getOwner();
        if (owner==null) {
            String message = textStrings.getLine(player.getLocation() * 3);
            displayMessage(message);
        }else if (owner.getName().equals(player.getName())){
            String message = textStrings.getLine(player.getLocation() * 3+1);
            displayMessage(message);
        }else {
            String message = textStrings.getLine(player.getLocation() * 3+2);
            displayMessage(message);
        }

    }
    private void displayMessage(String message) {
        game.getGui().displayChanceCard(message);

        game.getGui().showMessage(tileString);
    }
    
        public GameBoard getBoard() {
            return board;
        }
        




}
