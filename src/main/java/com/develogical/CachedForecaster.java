package com.develogical;
import com.weather.Day;
import com.weather.Forecast;
import com.weather.Forecaster;
import com.weather.Region;
import java.util.HashMap;

public class CachedForecaster implements ForecasterTemplate{

    private Forecaster forecaster = new Forecaster();


    public CachedForecaster(Forecaster f, ForcastCache c){
        this.forecaster = f;
    }


    public Forecast forecastFor(Region region, Day day) {
        return forecaster.forecastFor(Region.LONDON, Day.MONDAY);
    }


}
