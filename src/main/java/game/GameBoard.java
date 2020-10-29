package game;

import gui_fields.GUI_Field;

/**
 * Should be used for the game board.
 * Tiles are the individual fields
 */
public class GameBoard {
    private Tile[] tiles;
    private int numberOfTiles;
    private final String[] descriptions={"","","Tower","Crater","Palace gates", "Cold Desert", "Walled city","Monastery","Black cave","Huts in the mountain", "The Werewall(werewolf-wall)", "The pit", "Goldmine"};
    private final int[] effects={0,0,250, -100, 100, -20, 180, 0, -70, 60, -80, -50, 650};
    private final String[] flavorText={"","","You find an abandoned tower with a chest filled with coins" + " +" + effects[2],
            "You fall into the great crater, losing some of your belongings during the tumble. " + effects[3],
            "You arrive at the Palace gates, where you are treated to some refreshments." + " +" + effects[4], "You buy a hot beverage to try and stay warm during the cold desert nights. " + effects[5],
            "You find yourself outside a prosperous walled city, in the sand you find a pouch of coins someone must have dropped." + " +" + effects[6],
            "You find yourself infront of a great monastery, but you don't accomplish much.",
            "You find yourself spending the night in a dark cave, the next morning you realize you dropped some coins during your sleep. " + effects[8],
            "You find an empty hut in the mountains where you can spend the night. You see some belongings from the previous owner which you can sell." + " +" + effects[9],
            "You discover the great Werewall, terrified at the sight you run as fast as you can, dropping your coin purse during your escape. " + effects[10],
            "You fall into a pit, dropping some coins. " + effects[11],
            "You discover an abandoned Goldmine, the minecarts still filled with gold. You cant help but wonder where everyone went..." + " +" + effects[12]

    };


    public GameBoard (int numOfTiles, GUI_Field[] gui_fields) {
        numberOfTiles=numOfTiles;
        tiles = new Tile[numOfTiles];
        tiles[0] = new Tile();
        for (int i = 1; i < numOfTiles; i++) {
            boolean extraTurn1 = false;
            if (i == 10) extraTurn1 = true;
            tiles[i] = new Tile(i, descriptions[i], effects[i], extraTurn1, gui_fields[i], flavorText[i]);

        }
    }

    public Tile[] getTiles() {
        return tiles;
    }
}

