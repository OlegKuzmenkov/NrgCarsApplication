package com.oleg_kuzmenkov.android.nrgcarsapplication.dagger;

import com.oleg_kuzmenkov.android.nrgcarsapplication.view.CarsListActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class CarsContextModule {

    CarsListActivity carsContext;

    public CarsContextModule(CarsListActivity context) {
        carsContext = context;
    }

    @Provides
    CarsListActivity provideCarsContext() {
        return carsContext;
    }
}
