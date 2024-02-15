package smallestnumcoins;

public class CoinCount {

    // Can be easily expanded to say which coins with a hash map.
    public int minCoins(int[] coins, int amount) {
        double[] minSoFar = new double[amount + 1];
        for (int i = 1; i < amount + 1; i++) {
            minSoFar[i] = Double.POSITIVE_INFINITY;
        }

        // loop through every index
        for (int i = 1 ; i < amount + 1; i++) {
            for (int coin : coins) {
                // check if coin can even fit up to this point
                if (coin <= i) {
                    // now - assign minSoFar to the minimum of our CURRENT value and the value coins indices away
                    // does 1 more of these new coins result in a net lower coin count?
                    minSoFar[i] = Math.min(minSoFar[i], minSoFar[i - coin] + 1);
                }
            }
        }

        // If our last value hasn't been set, we know no coin  combinations reached the target amount - return -1
        if (minSoFar[amount] == Double.POSITIVE_INFINITY) {
            return -1;
        }
        return (int) minSoFar[amount];
    }
}
