package utils;

import models.Reading;
import play.utils.Utils;

import java.util.List;

public class Conversions extends Utils{

    public static float celsiusToFahrenheit(float temp) {

        return (temp * 9 / 5) + 32;
    }

    public static float findMaxTemp(List<Reading> readings) {
        float maxTemp = Float.MIN_VALUE;
        for (Reading reading : readings) {
            if (reading.temp > maxTemp) {
                maxTemp = reading.temp;
            }
        }
        return maxTemp;
    }
    public static int KmToBeaufort(double km) {

        double [] beaufortScaleConversion = {1,6,12,20,29,39,50,62,75,89,103} ;

        for( int i = 0; i < beaufortScaleConversion.length; i++){
            if(km < beaufortScaleConversion[i]) {
                return i;
            }

            }
        return 12;
        }

    public static String codeToWeatherDescription(int code) {

        // code is in numerical order of increasing by 100. dividing by 100 to make the code more readable.

        switch (code/100) {
            case 1:
                return "Clear";
            case 2:
                return "Partial Cloud";
            case 3:
                return "Cloudy";
            case 4:
                return "Light Showers";
            case 6:
                return "Rain";
            case 7:
                return "Snow";
            case 8:
                return "Thunder";
            default:
                return "Unknown";
        }
    }

    /*Using the Modulo to convert the wind direction to an integer by splitting the
      circle into 16 even degrees of 22.5 and then
      dividing by that number to find the corresponding index.
    */
    public static String getCompassDirection(float windDirection) {

        String[] compassDirection = {"N", "NNE", "NE", "ENE", "E", "ESE",
                "SE", "SSE", "S", "SSW", "SW", "WSW", "W", "WNW", "NW", "NNW"};

        int mainNumber = (int) windDirection; // get the integer part of the wind speed value
        float decimalPart = windDirection - mainNumber; // get the decimal part of the wind speed value
        int CompassDirection;

        if (decimalPart > 0.25 && decimalPart < 0.75) {
            CompassDirection = (int) Math.floor(((windDirection % 360) + 11.25) / 22.5);
        } else {
            CompassDirection = (int) Math.ceil(((windDirection % 360) + 11.25) / 22.5);
        }
        CompassDirection = CompassDirection % 16;
        return compassDirection[CompassDirection];

    }

    public static double getWindChill(float temp, double v) {

        double windChill = 13.12 + (0.6215 * temp) - (11.37 * Math.pow(v, 0.16)) +
                (0.3965 * temp * Math.pow(v, 0.16));

        return Math.round(windChill*100.0)/100.0;
    }
}
