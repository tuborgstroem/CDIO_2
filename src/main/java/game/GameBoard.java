package game;

import gui_fields.*;

import java.awt.*;

/**
 * Should be used for the game board.
 * Tiles are the individual fields
 */
public class GameBoard implements englishBoardStrings{
    private Tile[] tiles;
    private final int[] effects={2,1,1,0,1,1,0,2,2,0,2,2,0,3,3,0,3,3,0,4,4,0,4,4};

    public GameBoard (int numOfTiles, GUI_Field[] gui_fields) {
        tiles = new Tile[numOfTiles];
        //tiles[0] = new Tile();
        for (int i = 0; i < numOfTiles; i++) {
            //tiles[i] = new Tile(effects[i], tileStrings.getLine(i), effects[i], gui_fields[i], "");
            //if (gui_fields[i] instanceof GUI_Start) {
            //    tiles[i].getGui_field().setTitle(tileStrings.getLine(i));
            //}
            tiles[i] = new Tile(effects[i],gui_fields[i]);
            if (gui_fields[i] instanceof GUI_Street || gui_fields[i] instanceof GUI_Start) {
                tiles[i].getGui_field().setTitle(Game.tileStrings.getLine(i));
                tiles[i].getGui_field().setSubText("M"+effects[i]);
                tiles[i].getGui_field().setDescription(tileStrings.getLine(i));
            } else {
                tiles[i].getGui_field().setSubText(Game.tileStrings.getLine(i));
            }
        }
    }

    public Tile[] getTiles() {
        return tiles;
    }
}

