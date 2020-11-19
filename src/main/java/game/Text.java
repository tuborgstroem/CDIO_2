package game;

import gui_fields.*;
import gui_main.GUI;


public class Text {
    private GUI_Field[] fields;
    private Game game;
    public final Language textStrings;
    private String tileString;
    private String landString;
    private String unOwnedString;
    private String ownedSelfString;
    private String ownedOtherStringLast;
    private String ownedOtherStringFirst;

    private String currencyPlural;
    private String currencySingular;
    private GameBoard board;
    private GUI gui;
    private Player player;
    int location;

    public Text(Game game) {
        textStrings = new Language("resources/engFieldText.txt");
        int i = 0;
        landString = textStrings.getLine(i++);
        unOwnedString = textStrings.getLine(i++);
        ownedSelfString = textStrings.getLine(i++);
        ownedOtherStringFirst = textStrings.getLine(i++);
        ownedOtherStringLast = textStrings.getLine(i++);
        currencyPlural = textStrings.getLine(i++);
        currencySingular = textStrings.getLine(i++);

//        tileString = textStrings.getLine(0);
        this.game = game;
        board = game.getBoard();
        gui = game.getGui();
    }


    public void TileMessage (Player player) {

        Tile tile = board.getTile(player.getLocation());
        String finalmsg = landString + " "+ tile.getGui_field().getTitle();
        if (tile.getOwner()== null){
            finalmsg += unOwnedString;
        }
        else if(tile.getOwner() == player) {
             displayMessage(finalmsg += ownedSelfString);
             return;
        }
        else{
            finalmsg += ownedOtherStringFirst + " " + tile.getOwner().getName() + ownedOtherStringLast;
        }
        finalmsg += " " + Integer.toString(tile.getRent());
        if(tile.getRent() > 1){
            finalmsg += currencyPlural;
        }
        else{
            finalmsg += currencySingular;
        }
        displayMessage(finalmsg);
    }
    private void displayMessage(String message) {
        game.getGui().showMessage(message);
    }
    
        public GameBoard getBoard() {
            return board;
        }
        




}
