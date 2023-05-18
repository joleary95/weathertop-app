package controllers;

import models.Reading;
import models.Station;
import play.Logger;
import play.mvc.Controller;


public class StationCtrl extends Controller {

    public static void index(Long id) {
        Station station = Station.findById(id);
        Logger.info("Playlist id=" +id);
        render("station.html", station);
    }

    public static void addReadings(Long id, int code, float temp, float windSpeed, int pressure,
                                int windDirection)
    {
        Reading readings = new Reading(code, temp, windSpeed, pressure, windDirection);
        Station station = Station.findById(id);
        station.readings.add(readings);
        station.save();
        redirect ("/stations/" + id);
    }
}

