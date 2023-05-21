package utils;

import models.Reading;
import play.utils.Utils;

import java.util.List;

public class Conversions extends Utils{

    public static float celsiusToFahrenheit(float temp) {           //Celsius to fahrenheit Calculation

        return (temp * 9 / 5) + 32;
    }

    public static int KmToBeaufort(double km) {                           // KM to the Beaufort Scale

        double [] beaufortScaleConversion = {1,6,12,20,29,39,50,62,75,89,103} ;

        for( int i = 0; i < beaufortScaleConversion.length; i++){
            if(km < beaufortScaleConversion[i]) {
                return i;
            }
            }
        return 12;
        }

    public static String codeToWeatherDescription(int code) {              // Converting code to Description
        // code is in numerical order increasing by 100. dividing by 100 to make the code more readable.
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

    public static String getCompassDirection(float windDirection) {

                if ((windDirection >= 348.75) && (windDirection <= 360)) {
                    return "North";
                } else if ((windDirection >= 0) && (windDirection <= 11.25)) {
                    return "North";
                } else if ((windDirection >= 11.25) && (windDirection <= 33.75)) {
                    return "North NE";
                } else if ((windDirection >= 33.75) && (windDirection <= 56.25)) {
                    return "North East";
                } else if ((windDirection >= 56.25) && (windDirection <= 78.75)) {
                    return "East NE";
                } else if ((windDirection >= 78.75) && (windDirection <= 101.25)) {
                   return "East";
                } else if ((windDirection >= 101.25) && (windDirection <= 123.75)) {
                    return "East SE";
                } else if ((windDirection >= 123.75) && (windDirection <= 146.25)) {
                    return "South East";
                } else if ((windDirection >= 146.25) && (windDirection <= 168.75)) {
                    return "South SE";
                } else if ((windDirection >= 168.75) && (windDirection <= 191.25)) {
                    return "South";
                } else if ((windDirection >= 191.25) && (windDirection <= 213.75)) {
                    return "South SW";
                } else if ((windDirection >= 213.75) && (windDirection <= 236.25)) {
                    return "South West";
                } else if ((windDirection >= 236.25) && (windDirection <= 258.75)) {
                    return  "West SW";
                } else if ((windDirection >= 258.75) && (windDirection <= 281.25)) {
                    return "West";
                } else if ((windDirection >= 281.25) && (windDirection <= 303.75)) {
                    return "West NW";
                } else if ((windDirection >= 303.75) && (windDirection <= 326.25)) {
                    return "North West";
                } else if ((windDirection >= 326.25) && (windDirection <= 348.75)) {
                    return "North NW";
                } else if ((windDirection < 0) || (windDirection > 360)) {
                    return "Enter wind direction";
                }
            return "Enter wind direction";
        }

    public static double getWindChill(float temp, double v) {

        double windChill = 13.12 + (0.6215 * temp) - (11.37 * Math.pow(v, 0.16)) +    // Calculating WindChill
                (0.3965 * temp * Math.pow(v, 0.16));

        return Math.round(windChill*100.0)/100.0;
    }
}
