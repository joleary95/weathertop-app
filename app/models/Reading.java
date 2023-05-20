package models;

import utils.Conversions;
import utils.StationAnalytics;
import javax.persistence.Entity;

import play.db.jpa.Model;

import java.util.List;

@Entity
public class Reading extends Model {
    public int code;
    public float temp;
    public float windSpeed;
    public int pressure;
    public int windDirection;


    public Reading(int code, float temp, float windSpeed, int pressure,
                    int windDirection)
    {
        this.code = code;
        this.temp = temp;
        this.windSpeed = windSpeed;
        this.pressure = pressure;
        this.windDirection = windDirection;

    }
    public Reading() {
    }

    //Methods to call readings to Dashboard
    public float Fahrenheit() {

        return Conversions.celsiusToFahrenheit(this.temp);
    }

    public String weatherDescription() {

        return Conversions.codeToWeatherDescription(this.code);
    }

    public String CompassDirection() {

        return Conversions.getCompassDirection(this.windDirection);
    }

    public int kmToBeaufort() {

        return Conversions.KmToBeaufort(this.windSpeed);
    }

    public double windChill() {

        return Conversions.getWindChill(this.temp, this.windSpeed);
    }


    //Getter
    public float getWindSpeed() {

        return this.windSpeed;
    }

    public float getTemp() {

        return this.temp;
    }

    public int getPressure() {

        return this.pressure;
    }

    public int getWindDirection() {

        return Math.round(this.windDirection);
    }

    public int getCode() {
        return this.code;
    }



    //Setters
    public void setWindSpeed(float windSpeed) {

        this.windSpeed = windSpeed;
    }
    public void setWindDirection(int windDirection) {

        this.windDirection = windDirection;
    }

    public void setCode(int code) {

        this.code = code;
    }

    public void setTemp(int temp) {

        this.temp = temp;
    }

    public void setPressure(int pressure) {

        this.pressure = pressure;
    }

}
