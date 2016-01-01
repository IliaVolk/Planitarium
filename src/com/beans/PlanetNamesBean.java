package com.beans;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;

/**
 * PlanetName adapter for jsf bean
 */
@ManagedBean
@ApplicationScoped
public class PlanetNamesBean implements Serializable{
    public PlanetName getMercury(){return PlanetName.mercury;}
    public PlanetName getVenus(){return PlanetName.venus;}
    public PlanetName getEarth(){return PlanetName.earth;}
    public PlanetName getMars(){return PlanetName.mars;}
    public PlanetName getJupiter(){return PlanetName.jupiter;}
    public PlanetName getSaturn(){return PlanetName.saturn;}
    public PlanetName getUranus(){return PlanetName.uranus;}
    public PlanetName getNeptune(){return PlanetName.neptune;}

}
