package clockangle;

public class ClockAngle {
    public double angleClock(int hour, int minutes) {
        int degreesInSection = 30;
        int degreesInMin = 6;
        int minutesInHr = 60;
        int hoursOnClock = 12;

        hour = hour % hoursOnClock;

        double hrAngle = hour * degreesInSection +
                ((double) degreesInSection * minutes / minutesInHr);

        int minAngle = minutes * degreesInMin;

        double res = Math.abs(minAngle - hrAngle);
        return res > 180 ? 360 - res : res;
    }
}
