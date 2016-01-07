package com.beans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by user on 01.01.2016.
 */
public class Mars implements Planet {
    List<MoonData> moons;
    public Mars(){
        moons = new ArrayList<>(Arrays.asList(
                new MoonData("Phobos", 22), new MoonData("Deimos", 12)
        ));
    }

    @Override
    public List<MoonData> getMoons() {
        return moons;
    }

    @Override
    public void setMoons(List<MoonData> newMoons) {

    }
}
