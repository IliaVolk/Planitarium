package com.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import java.util.ArrayList;

/**
 * Created by user on 01.01.2016.
 */
@ManagedBean(name = "moonTableData")
@SessionScoped
public class MoonTableDataBean {
    @ManagedProperty(value = "#{planetarium}")
    private PlanetariumBean planetarium;
    public void setPlanetarium(PlanetariumBean planetarium) {
        this.planetarium = planetarium;
    }

    public MoonTableDataBean(){}
    private SortFilterModel<Planet.MoonData> filterModel;
    /////////////////////////TODO:this is debug. Delete
    private String rows;
    public String getRows(){
        return filterModel.getRows().toString();
    }
    public void setRows(String s){}
    ///////////////////////////////
    public void initializeMoonTableDataBeanModel(PlanetName planetName){/*
        System.out.println("#### инициализация mootTableData начинается planetName="+
                planetName+"array of moons="+planetarium.getMoons(planetName).toArray());
        System.out.println("#####array of moons="+planetarium.getMoons(planetName).toArray());
        ListDataModel<Planet.MoonData> listDataModel = new ListDataModel<Planet.MoonData>(
                planetarium.getMoons(planetName));
        System.out.println("#####arrayDataModel="+listDataModel);
*/
        filterModel = new SortFilterModel<Planet.MoonData>(new ListDataModel<Planet.MoonData>(
                planetarium.getMoons(planetName)));
    }
    public DataModel<Planet.MoonData> getMoons(){
        //System.out.println("#####getMoons в moontabledatabean. selectedPlanet="+selectedPlanet+"planetarium.getMoons="+
        //planetarium.getMoons(selectedPlanet));
        return filterModel;
    }
    public void setMoons(PlanetName planetName, DataModel<Planet.MoonData> newMoons){
        ArrayList<Planet.MoonData> list = new ArrayList<>(newMoons.getRowCount());
        newMoons.forEach(list::add);
        planetarium.setMoons(planetName, list);
        filterModel = new SortFilterModel<>(newMoons);
    }
    public void deleteRow(PlanetName selectedPlanet, Object name){
        planetarium.getMoons(selectedPlanet).remove(name);
        initializeMoonTableDataBeanModel(selectedPlanet);
    }
    public void addRow(PlanetName selectedPlanet){
        planetarium.getMoons(selectedPlanet).add(new Planet.MoonData("", 0));
        initializeMoonTableDataBeanModel(selectedPlanet);
    }


    public String sortByName(){

        filterModel.sortBy((o1, o2) -> {
            /*System.out.println("*SORTING* by name o1.compareTo(o2)="+
                    o1.getName().compareTo(o2.getName())+" o1.compareTo(o2){{in lower case}}="  +
                            (o1.getName().toLowerCase()).compareTo(o2.getName().toLowerCase())+
                    "  o1="+o1.getName()+" o2="+o2.getName());*/
            return (o1.getName().toLowerCase()).compareTo(o2.getName().toLowerCase());
        });
        return null;
    }

    public String sortByDiameter(){

        filterModel.sortBy((o1, o2) -> o1.getDiameter().compareTo(o2.getDiameter()));
        return null;
    }
}
