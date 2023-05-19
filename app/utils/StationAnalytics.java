package utils;

import models.Reading;
import play.db.jpa.Model;

import java.util.List;

public class StationAnalytics extends Model {

    public static float findMinTemp(List<Reading> readings) {
        float minTemp = Float.MAX_VALUE;  //
        for (Reading reading : readings) {
            if (reading.getTemp() < minTemp) {
                minTemp = reading.getTemp();
            }
        }
        return minTemp;
    }

    public static float findMaxTemp(List<Reading> readings) {
        float maxTemp = Float.MIN_VALUE;  //
        for (Reading reading : readings) {
            if (reading.getTemp() > maxTemp) {
                maxTemp = reading.getTemp();
            }
        }
        return maxTemp;
    }

    public static float findMinWindSpeed(List<Reading> readings) {
        float minWindSpeed = Float.MAX_VALUE;  //
        for (Reading reading : readings) {
            if (reading.getWindSpeed() < minWindSpeed) {
                minWindSpeed = reading.getWindSpeed();
            }
        }
        return minWindSpeed;
    }

    public static float findMaxWindSpeed(List<Reading> readings) {
        float maxWindSpeed = Float.MIN_VALUE;  //
        for (Reading reading : readings) {
            if (reading.getWindSpeed() > maxWindSpeed) {
                maxWindSpeed = reading.getWindSpeed();
            }
        }
        return maxWindSpeed;
    }

    public static int findMinPressure(List<Reading> readings) {
        int minPressure = Integer.MAX_VALUE;  //
        for (Reading reading : readings) {
            if (reading.getPressure() < minPressure) {
                minPressure = reading.getPressure();
            }
        }
        return minPressure;
    }

    public static int findMaxPressure(List<Reading> readings) {
        int maxPressure = Integer.MIN_VALUE;  //
        for (Reading reading : readings) {
            if (reading.getPressure() > maxPressure) {
                maxPressure = reading.getPressure();
            }
        }
        return maxPressure;
    }

}
