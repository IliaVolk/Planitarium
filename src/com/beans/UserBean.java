package com.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import java.io.Serializable;
import java.util.List;

/**
 * Created by user on 29.12.2015.
 */
@ManagedBean(name = "user")
@SessionScoped
public class UserBean implements Serializable{
    private String name;
    private String password;
    /*@ManagedProperty(value = "#{planetarium}")
    private PlanetariumBean planetarium;
    public void setPlanetarium(PlanetariumBean planetarium) {
        this.planetarium = planetarium;
    }*/
    @ManagedProperty(value = "#{moonTableData}")
    private MoonTableDataBean moonTableData;
    public void setMoonTableData(MoonTableDataBean moonTableData) {
        this.moonTableData = moonTableData;
    }

    public UserBean(){
        System.out.println("#####Конструктор userBean начинается");
        initializeMoonTableData();
        System.out.println("#####КОнструктор userBean выполнился mtd=" + moonTableData);
    }

    private void initializeMoonTableData(){
        try {
            moonTableData.initializeMoonTableDataBeanModel(selectedPlanet());
        }catch (NullPointerException e){System.out.println("#####Ошибка при инициализации moonTableData");}
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    private String selectedPlanet;
    private PlanetName selectedPlanet(){
        System.out.println("#####selectedPlanet начинается");
        return PlanetName.valueOf(selectedPlanet);
    }
    public String getSelectedPlanet() {
        return selectedPlanet;
    }

    public void setSelectedPlanet(String selectedPlanet) {
        this.selectedPlanet = selectedPlanet;
    }
    public String changePlanet(String name){
        setSelectedPlanet(name);
        initializeMoonTableData();
        return name;
    }
    public DataModel<Planet.MoonData> getMoons(){
        System.out.println("#####getMoons начинается moonTableData=" + moonTableData + "  selectedPlanet="+ selectedPlanet +  " mtd = null->" + (moonTableData == null));
        return moonTableData.getMoons();
    }
    public void setMoons(DataModel<Planet.MoonData> newMoons){
        moonTableData.setMoons(selectedPlanet(), newMoons);
    }
    public String deleteRow(Object name){
        moonTableData.deleteRow(selectedPlanet(), name);
        return null;
    }
    public String addRow(){
        moonTableData.addRow(selectedPlanet());
        return null;
    }

}
