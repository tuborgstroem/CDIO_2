package game;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    public void constructorTest(){
        String testName = "Testplayer";
        int location = 0;
        int balance = 1000;
        Player player = new Player(testName, balance, location, null);

        assertEquals(testName, player.getName());
        assertEquals(balance, player.getBalance());
        assertEquals(location, player.getLocation());

    }


    @Test
    void addToBalance() {
    }

    @Test
    void moveLocation() {
    }
}