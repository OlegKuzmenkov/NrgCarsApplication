package com.oleg_kuzmenkov.android.nrgcarsapplication.dagger;

import com.oleg_kuzmenkov.android.nrgcarsapplication.presenter.CarsPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class CarsPresenterModule {

    @Provides
    @Singleton
    CarsPresenter providePresenter() {
        return new CarsPresenter();
    }
}
