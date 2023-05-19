package controllers;

import java.util.List;

import models.Member;
import models.Station;
import play.Logger;
import play.mvc.Controller;


public class Dashboard extends Controller
{
  public static void index()
  {
    Logger.info("Rendering Admin");
    Member member = Accounts.getLoggedInMember();
    List<Station> stations = member.stations;
    render ("dashboard.html", stations);
  }

  public static void deleteStation(Long id)
  {
    Member member = Accounts.getLoggedInMember();
    Station station = Station.findById(id);
    Logger.info ("Removing" + station.name);
    member.stations.remove(station);
    member.save();
    station.delete();
    redirect ("/dashboard");
  }

  public static void addStation(String name)
  {
    Member member = Accounts.getLoggedInMember();
    Station station = new Station(name);
    member.stations.add(station);
    Logger.info ("Adding a new station called " + name);
    member.save();
    redirect ("/dashboard");
  }
}

