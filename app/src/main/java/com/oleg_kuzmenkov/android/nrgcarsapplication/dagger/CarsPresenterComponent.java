package com.oleg_kuzmenkov.android.nrgcarsapplication.dagger;

import com.oleg_kuzmenkov.android.nrgcarsapplication.view.CarsListActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {CarsContextModule.class, CarsPresenterModule.class})
public interface CarsPresenterComponent {
    void inject(CarsListActivity activity);
}
