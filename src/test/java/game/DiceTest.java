package game;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiceTest {
    private Dice die;
    @BeforeEach
    void setUp() throws Exception{
        this.die = new Dice();
    }

    @AfterEach
    void tearDown() throws Exception{

    }

    @Test
    void roll() {
        this.die.roll();

        Assert.assertTrue("Die faceValue to low", this.die.getValue() >= 1);
        Assert.assertTrue("Die faceValue to high", this.die.getValue() <= 6);
    }

    @Test
    void getValue() throws Exception{
        Assert.assertEquals(6, this.die.getSides());
    }

    @Test
    void getSides() {
    }
}