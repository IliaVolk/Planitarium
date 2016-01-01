package com.beans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by user on 30.12.2015.
 */
public class Saturn implements Planet{
    private List<MoonData> moons;
    public Saturn(){
        moons = new ArrayList<>(Arrays.asList(
                new MoonData("Mimas", 396), new MoonData("Enceladus", 504),
                new MoonData("Tethys", 1062), new MoonData("Dione", 1123),
                new MoonData("Rhea", 1527), new MoonData("Titan", 5150),
                new MoonData("Iapetus", 1470)));
    }
    @Override
    public List<MoonData> getMoons() {
        System.out.println("#####getMoons in Saturn. moons=" + moons);
        return moons;
    }

    @Override
    public void setMoons(List<MoonData> newMoons) {
        moons = newMoons;
    }


}
