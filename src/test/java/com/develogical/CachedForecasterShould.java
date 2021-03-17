package com.develogical;

import com.weather.Day;
import com.weather.Forecast;
import com.weather.Forecaster;
import com.weather.Region;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class CachedForecasterShould {

    @Test
    public void cachedForecasterShouldDelegateToRealForecaster() {
        Forecaster forecaster =  mock(Forecaster.class);
        given(forecaster.forecastFor(Region.LONDON, Day.MONDAY)).willReturn(new Forecast("testText",22));
        Forecast londonForecast = new CachedForecaster(forecaster).forecastFor(Region.LONDON, Day.MONDAY);
        assertThat(londonForecast.summary(), equalTo("testText"));
        assertThat(londonForecast.temperature(), equalTo(22));
    }

    @Test
    public void getFromCacheIfSeenBefore() {
        Forecaster forecaster =  mock(Forecaster.class);
        given(forecaster.forecastFor(Region.LONDON, Day.MONDAY)).willReturn(new Forecast("testText",22));
        CachedForecaster underTest = new CachedForecaster(forecaster);

        Forecast londonForecastFirst = underTest.forecastFor(Region.LONDON, Day.MONDAY);
        Forecast londonForecastSecond = underTest.forecastFor(Region.LONDON, Day.MONDAY);

        assertThat(londonForecastFirst.summary(), equalTo("testText"));
        assertThat(londonForecastFirst.temperature(), equalTo(22));
        assertThat(londonForecastSecond.summary(), equalTo("testText"));
        assertThat(londonForecastSecond.temperature(), equalTo(22));

        verify(forecaster, times(1)).forecastFor(Region.LONDON, Day.MONDAY);
    }
}
