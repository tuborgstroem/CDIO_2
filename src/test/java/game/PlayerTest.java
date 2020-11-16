package game;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
public  Player testplayer;
String testName = "Testplayer";
int location = 0;
int balance = 1000;
    @Test
    public void constructorTest(){
        assertEquals(testName, testplayer.getName());
        assertEquals(balance, testplayer.getBalance());
        assertEquals(location, testplayer.getLocation());

    }

    @BeforeEach
    public void beforeTestsMethod(){
        testplayer = new Player(testName, balance, location, null);
    }

    @Test
    void addToBalance() {
        int addedToBalance = 100;
        testplayer.addToBalance(100);
        assertEquals(balance+addedToBalance, testplayer.getBalance());
    }

}