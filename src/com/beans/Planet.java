package com.beans;

import java.io.Serializable;
import java.util.List;

/**
 * Created by user on 30.12.2015.
 */
public interface Planet extends Serializable{
    public List<MoonData> getMoons();
    public void setMoons(List<MoonData> newMoons);
    class MoonData{
        public MoonData(String name, int diameter){
            this.name = name;
            this.diameter = diameter;
        }
        private String name;
        private Integer diameter;
        private boolean editable = false;

        public MoonData(){

        }


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getDiameter() {
            return diameter;
        }

        public void setDiameter(Integer diameter) {
            this.diameter = diameter;
        }

        public boolean isEditable() {
            return editable;
        }

        public void setEditable(boolean editable) {
            this.editable = editable;
        }
    }
}
