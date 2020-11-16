package game;

import gui_fields.GUI_Field;
import gui_fields.GUI_Street;

/**
 * Should be used for the game board.
 * Tiles are the individual fields
 */
public class GameBoard implements englishBoardStrings{
    private Tile[] tiles;
    private final int[] effects={0,1,1,0,1,1,0,2,2,0,2,2,0,3,3,0,3,3,0,4,4,0,4,4};
    private final Language tileStrings = new Language("resources/engTileStrings.txt");

    public GameBoard (int numOfTiles, GUI_Field[] gui_fields) {
        tiles = new Tile[numOfTiles];
        //tiles[0] = new Tile();
        for (int i = 0; i < numOfTiles; i++) {
            if (!gui_fields[i].getSubText().equals("Parking lot") && !gui_fields[i].getSubText().equals("Prison") && !gui_fields[i].getTitle().equals("Start") && !gui_fields[i].getSubText().equals("Go to jail!") && !gui_fields[i].getSubText().equals("Chancecard")) {
                tiles[i] = new Tile(effects[i], tileStrings.getLine(i), effects[i], gui_fields[i], "");
            }
        }
    }

    public Tile[] getTiles() {
        return tiles;
    }
}

