package happynumber;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    private HappyNumber() {}
    public static boolean isHappy(int number) {
        // A number is happy if it leads to 1 after a sequence
        // of steps where each step, the number is replaced by the sum
        // of squares of its digit(s)
        Set<Integer> totalsSeen = new HashSet<>();
        while (number != 1) {
            int answer = 0;
            while (number > 0) {
                int remainder = number % 10;
                answer += remainder * remainder;
                number /= 10;
            }
            if (totalsSeen.contains(answer)) {
                return false;
            }
            totalsSeen.add(answer);
            number = answer;
        }
        return true;
    }

    public static boolean isHappyFloydsAlgorithm(int number) {
        int slowTravel = sumSquareDigits(number);
        int fastTravel = sumSquareDigits(sumSquareDigits(number));

        while (slowTravel != fastTravel) {
            slowTravel = sumSquareDigits(slowTravel);
            fastTravel = sumSquareDigits(sumSquareDigits(fastTravel));
        }

        return slowTravel == 1;
    }

    private static int sumSquareDigits(int number) {
        int answer = 0;
        while (number > 0) {
            int remainder = number % 10;
            answer += remainder * remainder;
            number /= 10;
        }
        return answer;
    }
}
