package game;



interface englishStrings{
    String stringPlayerWon = " has won the game, congratulations!";
    String stringNextTurn = "'s turn, press OK to roll dice.";
    String stringEnterPlayerNamesA = "Please enter name of Player ";
    String stringEnterPlayerNamesB = " and press Enter";
    String stringNumberOfPlayers = "Please enter number of players";
    String stringExtraTurn = " gets an extra turn!";
}

interface englishBoardStrings{
    String[] stringFlavourTile = {"","",
            "You find an abandoned tower with a chest filled with coins. +",
            "You fall into the great crater, losing some of your belongings during the tumble. ",
            "You arrive at the Palace gates, where you are treated to some refreshments. +",
            "You buy a hot beverage to try and stay warm during the cold desert nights. ",
            "You find yourself outside a prosperous walled city, in the sand you find a pouch of coins someone must have dropped. +",
            "You find yourself infront of a great monastery, but you don't accomplish much.",
            "You find yourself spending the night in a dark cave, the next morning you realize you dropped some coins during your sleep. ",
            "You find an empty hut in the mountains where you can spend the night. You see some belongings from the previous owner which you can sell. +",
            "You discover the great Werewall, terrified at the sight you run as fast as you can, dropping your coin purse during your escape. ",
            "You fall into a pit, dropping some coins. ",
            "You discover an abandoned Goldmine, the minecarts still filled with gold. You cant help but wonder where everyone went... +"
    };
    String[] stringTileDesc = {"","",
            "Tower",
            "Crater",
            "Palace gates",
            "Cold Desert",
            "Walled city",
            "Monastery",
            "Black cave",
            "Huts in the mountain",
            "The Werewall(werewolf-wall)",
            "The pit",
            "Goldmine"};

}