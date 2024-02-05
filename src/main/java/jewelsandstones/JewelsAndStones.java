package jewelsandstones;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> jewelsList = new HashSet<>();

        for (int i = 0; i < jewels.length(); i++) {
            jewelsList.add(jewels.charAt(i));
        }

        int count = 0;

        for (int i = 0; i < stones.length(); i++) {
            if (jewelsList.contains(stones.charAt(i))) {
                count++;
            }
        }

        return count;
    }
}
