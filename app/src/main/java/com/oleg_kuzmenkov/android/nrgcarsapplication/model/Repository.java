package com.oleg_kuzmenkov.android.nrgcarsapplication.model;

import java.util.List;

public interface Repository {

    void getCarsList(String filter, ReadCarsCallback listener);

    interface ReadCarsCallback {
        void onFinished(List<Car> list);
    }
}
