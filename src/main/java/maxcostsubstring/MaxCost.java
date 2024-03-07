package maxcostsubstring;

public class MaxCost {
    public int maximumCostSubstring(String s, String chars, int[] vals) {
        // Fill in costs

        int[] costs = new int[26];
        // By default, a-z have a cost of 1-26.
        for (int i = 0; i < 26; i++) {
            costs[i] = i + 1;
        }
        // Those characters that have defined costs should be updated in the cost array.
        for (int i = 0; i < chars.length(); i++) {
            char curChar = chars.charAt(i);
            costs[curChar - 'a'] = vals[i];
        }

        return getAbsMax(s, costs);
    }

    private int getAbsMax(String s, int[] costs) {
        int absMax = 0;

        // Our current tracked substring.
        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);
            // Cost of substring up to this point
            sum += costs[curChar - 'a'];

            // Is the substring larger than current max?
            absMax = Math.max(absMax, sum);

            // If we ever bottom out, we should start considering a new substring
            if (sum < 0) {
                sum = 0;
            }
        }

        return absMax;
    }
}
