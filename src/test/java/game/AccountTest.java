package game;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {
    Account account = new Account(1000);
    @BeforeEach
    void setUp() throws Exception {
    }

    @AfterEach
    void tearDown()throws Exception  {
    }

    @Test
    void getScore() {
        assertEquals(1000, account.getScore());
    }

    @Test
    void setScore() {
        account.setScore(10);
        assertEquals(10, account.getScore());
    }

    @Test
    void tilføjScore() {
        account.tilføjScore(20);
        assertEquals(1020, account.getScore());
    }

    @Test
    void hævScore() {
        account.hævScore(20);
        assertEquals(980, account.getScore());
    }
    @Test
    public void testKontoUnderNul() {
        account.hævScore(10000);
        assertEquals(0, account.getScore());
    }
}