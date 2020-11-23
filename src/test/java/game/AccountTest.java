package game;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
//
//public class AccountTest {
//    Account account = new Account(1000);
//    @BeforeEach
//    void setUp() throws Exception {
//    }
//
//    @AfterEach
//    void tearDown()throws Exception  {
//    }
//
//    @Test
//    void getScore() {
//        assertEquals(1000, account.getBalance());
//    }
//
//    @Test
//    void setScore() {
//        account.setBalance(10);
//        assertEquals(10, account.getBalance());
//    }
//
//    @Test
//    void deposit() {
//        account.deposit(20);
//        assertEquals(1020, account.getBalance());
//    }
//
//    @Test
//    void withdraw() {
//        account.withdraw(20);
//        assertEquals(980, account.getBalance());
//    }
//    @Test
//    public void balanceBelowZero() {
//        int tempInt = account.getBalance();
//        account.withdraw(10000);
//        assertEquals(tempInt, account.getBalance());
//    }
//}