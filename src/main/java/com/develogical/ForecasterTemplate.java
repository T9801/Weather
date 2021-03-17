package com.develogical;

import com.weather.Day;
import com.weather.Forecast;
import com.weather.Region;

public interface ForecasterTemplate {
    public Forecast forecastFor(Region region, Day day);
}
