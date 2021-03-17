package com.develogical;

import com.weather.Day;
import com.weather.Forecast;
import com.weather.Forecaster;
import com.weather.Region;

public class ForecasterAdapter implements WeatherForecaster {

    private Forecaster forecaster;

    public ForecasterAdapter(Forecaster f) {
        forecaster = f;
    }

    @Override
    public Forecast forecastFor(Region region, Day day) {
        return forecaster.forecastFor(region, day);
    }
}
