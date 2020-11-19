package game;

import gui_fields.GUI_Field;


/**
 * Should be used for the game board.
 * Tiles are the individual fields
 */
public class GameBoard implements englishBoardStrings{
    private Tile[] tiles;
    private int numberOfTiles;
    private final String[] descriptions={"","",stringTileDesc[2],stringTileDesc[3],stringTileDesc[4],stringTileDesc[5],stringTileDesc[6],stringTileDesc[7],stringTileDesc[8],stringTileDesc[9],stringTileDesc[10],stringTileDesc[11],stringTileDesc[12]};
    private final int[] effects={0,0,250, -100, 100, -20, 180, 0, -70, 60, -80, -50, 650};
    private final String[] flavorText={"","",
            stringFlavourTile[2] + effects[2],
            stringFlavourTile[3] + effects[3],
            stringFlavourTile[4] + effects[4],
            stringFlavourTile[5] + effects[5],
            stringFlavourTile[6] + effects[6],
            stringFlavourTile[7],
            stringFlavourTile[8] + effects[8],
            stringFlavourTile[9] + effects[9],
            stringFlavourTile[10] + effects[10],
            stringFlavourTile[11] + effects[11],
            stringFlavourTile[12] + effects[12],
    };


    public GameBoard (int numOfTiles, GUI_Field[] gui_fields) {
        numberOfTiles=numOfTiles;
        tiles = new Tile[numOfTiles];
        //tiles[0] = new Tile();
        for (int i = 0; i < numOfTiles; i++) {
            boolean extraTurn1 = false;
            if (i == 10) extraTurn1 = true;
            tiles[i] = new Tile(i, "test", 0, extraTurn1, gui_fields[i], "flavour");

        }
    }

    public Tile[] getTiles() {
        return tiles;
    }
}

