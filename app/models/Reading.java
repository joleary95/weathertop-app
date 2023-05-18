package models;

import utils.Conversions;
import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Reading extends Model {
    public int code;
    public float temp;
    public float windSpeed;
    public int pressure;

    public int windDirection;


    public Reading(int code, float temp, float windSpeed, int pressure,
                    int windDirection) {
        this.code = code;
        this.temp = temp;
        this.windSpeed = windSpeed;
        this.pressure = pressure;
        this.windDirection = windDirection;

    }
    public Reading() {
    }

    //Methods to call readings to DashBoard
    public float Fahrenheit() {

        return Conversions.celsiusToFahrenheit(temp);
    }
    public String weatherDescription() {

        return Conversions.codeToWeatherDescription(this.code);
    }

    public String CompassDirection() {

        return Conversions.getCompassDirection(windDirection);
    }

    public int kmToBeaufort() {

        return Conversions.KmToBeaufort(this.windSpeed);
    }

    public double windChill() {


        return Conversions.getWindChill(temp, windSpeed);
    }
    //Getter
    public float getWindSpeed() {

        return this.windSpeed;
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

}
