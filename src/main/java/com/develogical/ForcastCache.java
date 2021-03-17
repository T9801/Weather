package com.develogical;

import com.weather.Day;
import com.weather.Forecast;
import com.weather.Region;

import java.util.HashMap;

public class ForcastCache {

    private class RegionAndDay {
        Region region;
        Day day;
    }
    HashMap<RegionAndDay, Forecast> forcastCache = new HashMap<RegionAndDay, Forecast>();

    public Forecast getDataFromCache(Region region, Day day){
        return new Forecast("Text", 42);
    }

}
