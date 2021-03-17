package com.develogical;

import com.weather.Day;
import com.weather.Forecast;
import com.weather.Forecaster;
import com.weather.Region;

import java.util.HashMap;

public class CachedForecaster implements ForecasterTemplate {

    private Forecaster forecaster;
    HashMap<RegionAndDay, Forecast> forecastCache;

    private class RegionAndDay {
        Region region;
        Day day;

        @Override
        public int hashCode() {
            return region.hashCode() + day.hashCode();
        }

        @Override
        public boolean equals(Object other) {
            return this.hashCode() == other.hashCode();
        }

        RegionAndDay(Region region, Day day) {
            this.region = region;
            this.day = day;
        }

    }

    public CachedForecaster(Forecaster f) {
        this.forecaster = f;
        forecastCache = new HashMap<RegionAndDay, Forecast>();
    }


    public Forecast forecastFor(Region region, Day day) {
        RegionAndDay regionDay = new RegionAndDay(region, day);
        Forecast forecast = forecastCache.get(regionDay);

        if (forecast == null) {
            forecast = forecaster.forecastFor(region, day);
            forecastCache.put(regionDay, forecast);
        }
        return forecast;
    }


}
