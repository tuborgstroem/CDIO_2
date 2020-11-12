package game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiceCupTest {
    public DiceCup diceCupTest;
    int testNumberOfDice = 1;
    int testDiceIncup = 1;
    int testSum = 5;

    @BeforeEach
    public void beforeTestsMethod() {

    }

    @Test
    public void constructorTest() {
        assertEquals(testNumberOfDice, testNumberOfDice);
    }
}