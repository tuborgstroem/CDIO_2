package game;

import com.company.Main;
import gui_fields.*;

import java.awt.*;
import java.lang.reflect.Array;


/**
 * Should be used for the game board.
 * Tiles are the individual fields
 */
public class GameBoard {
    private Tile[] tiles;
    private final int[] effects={2,1,1,0,1,1,0,2,2,0,2,2,0,3,3,0,3,3,0,4,4,0,5,5};
    private final Color[] tileColor = {Color.RED, Color.YELLOW, Color.GREEN, Color.BLUE, Color.ORANGE, Color.CYAN, Color.PINK, Color.WHITE};
    private int[][] colorArr;
    private int colorCounter;
    private int arraySize;

    public GameBoard (int numOfTiles, GUI_Field[] gui_fields) {
        tiles = new Tile[numOfTiles];
        //tiles[0] = new Tile();
        for (int i = 0; i < numOfTiles; i++) {
            tiles[i] = new Tile(effects[i],gui_fields[i]);
            if (gui_fields[i] instanceof GUI_Street || gui_fields[i] instanceof GUI_Start) {
                tiles[i].getGui_field().setTitle(Main.tileStrings.getLine(i));
                tiles[i].getGui_field().setSubText("M"+effects[i]);
                tiles[i].getGui_field().setDescription(Main.tileStrings.getLine(i));
            } else {
                tiles[i].getGui_field().setSubText(Main.tileStrings.getLine(i));
                tiles[i].getGui_field().setDescription(Main.tileStrings.getLine(i));
            }
        }

        //Setup board colors
        colorCounter = 0;
        arraySize = 2;
        colorArr = new int[8][arraySize];
        // Doesn't scale with board size, arraySize is the number of color-grouped tiles

        for (int i = 1; i < numOfTiles; i++) {
            if (gui_fields[i] instanceof GUI_Street) {
                tiles[i].setTileColor(tileColor[colorCounter]);
                tiles[i].getGui_field().setBackGroundColor(tileColor[colorCounter]);
            } else {
                for (int j = 0; j < arraySize; j++) {
                    colorArr[colorCounter][j] = ((i-arraySize)+j);
                }
                colorCounter++;
            }
        }
    }

    public Tile getTile(int num){
        return tiles[num];
    }

    public Tile[] getTiles() {
        return tiles;
    }

    public int[] getColorArray(Color c) { //Returns 1-dimensional array with the color appropriate tiles
        int[] tempArr = new int[arraySize];
        tempArr[0] = 0; //default
        tempArr[1] = 0; //default
        for (int i = 0; i < 8; i++) {
            if (c == tileColor[i]) {
                for (int j = 0; j < arraySize; j++) {
                    tempArr[j] = colorArr[i][j];
                }
            }
        }
        return tempArr;
    }
}

