package models;

import java.util.ArrayList;
import java.util.List;
import utils.StationAnalytics;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Station extends Model
{
    public String name;

    @OneToMany(cascade = CascadeType.ALL)
    public List<Reading> readings = new ArrayList<Reading>();
    public float latitude;
    public float longitude;
    public Station(String name, float latitude, float longitude) {

        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Station() {

    }

    public String getName() {
        return name;
    }

    public Reading latestReading() {

        if (readings.size() != 0) {
            Reading lastreading = readings.get(readings.size() - 1);
            return lastreading; // return the latest reading using the index
        } else
            return null;

    }

    public String displayMaxTemp() {
        return String.valueOf(StationAnalytics.findMaxTemp(this.readings));
    }

    public String displayMinTemp() {
        return String.valueOf(StationAnalytics.findMinTemp(this.readings));
    }

    public String displayMaxWindSpeed() {
        return String.valueOf(StationAnalytics.findMaxWindSpeed(this.readings));
    }

    public String displayMinWindSpeed() {
        return String.valueOf(StationAnalytics.findMinWindSpeed(this.readings));
    }

    public String displayMaxPressure() {
        return String.valueOf(StationAnalytics.findMaxPressure(this.readings));
    }

    public String displayMinPressure() {
        return String.valueOf(StationAnalytics.findMinPressure(this.readings));
    }


}