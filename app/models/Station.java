package models;

import java.util.ArrayList;
import java.util.List;

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

    public Station(String name) {
        this.name = name;
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


}