package domain;

import static utils.RacingCarUtils.validateCarName;

public class RacingCarPosition {
    private String name;
    private Integer locationPoint;

    private RacingCarPosition(String name, Integer locationPoint) {
        this.name = name;
        this.locationPoint = locationPoint;
    }

    public static RacingCarPosition newInstance(String name, Integer locationPoint) {
        validateCarName(name);
        validateLocationPoint(locationPoint);

        return new RacingCarPosition(name, locationPoint);
    }

    private static void validateLocationPoint(Integer locationPoint) {
        if (locationPoint == null) {
            throw new IllegalArgumentException("car location point is null.");
        }

        if (locationPoint < 0) {
            throw new IllegalArgumentException("car location point must be greater than zero.");
        }
    }

    public String getName() {
        return name;
    }

    public Integer getLocationPoint() {
        return locationPoint;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof RacingCarPosition) {
            return name.equals(((RacingCarPosition) obj).name) && locationPoint.equals(((RacingCarPosition) obj).locationPoint);
        }
        return false;
    }
}
