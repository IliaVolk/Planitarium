package com.beans;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.swing.event.ListSelectionListener;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by user on 29.12.2015.
 */
@ApplicationScoped
@ManagedBean(name = "planetarium")
public class PlanetariumBean implements Serializable{
    private Map<PlanetName,Planet> planets = new HashMap<>();
    public PlanetariumBean(){
        //TODO: add more planets in map
        planets.put(PlanetName.saturn, new Saturn());
    }
    /*public List<Planet.MoonData> getMoons(PlanetName planetName){
        return planets.get(planetName).getMoons();
    }
    public void setMoons(PlanetName planetName, List<Planet.MoonData> newMoons){
        planets.get(planetName).setMoons(newMoons);
    }*/

    public List<Planet.MoonData> getMoons(PlanetName planetName){
        System.out.println("#####getMoons in planetarium. planetName="+planetName+ " planets.get(planetName)="+planets.get(planetName)+
        " planets.get(pn).getMoons=" +planets.get(planetName).getMoons());
        return planets.get(planetName).getMoons();
    }
    public void setMoons(PlanetName planetName, List<Planet.MoonData> newMoons){
        planets.get(planetName).setMoons(newMoons);
    }
}
