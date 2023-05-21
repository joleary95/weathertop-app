package models;

import java.util.ArrayList;
import java.util.List;

import utils.StationAnalytics;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Station extends Model {
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

    public float displayMaxTemp() {
        return StationAnalytics.findMaxTemp(this.readings);
    }

    public float displayMinTemp() {
        return StationAnalytics.findMinTemp(this.readings);
    }

    public float displayMaxWindSpeed() {
        return StationAnalytics.findMaxWindSpeed(this.readings);
    }

    public float displayMinWindSpeed() {
        return StationAnalytics.findMinWindSpeed(this.readings);
    }

    public int displayMaxPressure() {
        return StationAnalytics.findMaxPressure(this.readings);
    }

    public int displayMinPressure() {
        return StationAnalytics.findMinPressure(this.readings);
    }


}