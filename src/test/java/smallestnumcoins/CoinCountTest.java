package smallestnumcoins;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CoinCountTest {

    CoinCount test;

    @BeforeEach
    void init() {
        test = new CoinCount();
    }

    @Test
    void testMinCoins() {
        int[] possibleCoins = new int[]{1,2,5};
        int amount = 11;
        int expectedNumCoins = 3;

        assertEquals(expectedNumCoins, test.minCoins(possibleCoins, amount));

        possibleCoins = new int[]{1,5,10,25};
        amount = 47;
        expectedNumCoins = 5; // a quarter, 2 dimes and 2 pennies

        assertEquals(expectedNumCoins, test.minCoins(possibleCoins, amount));
    }
}
