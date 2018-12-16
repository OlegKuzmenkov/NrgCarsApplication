package com.oleg_kuzmenkov.android.nrgcarsapplication.presenter;

import com.oleg_kuzmenkov.android.nrgcarsapplication.model.Car;
import com.oleg_kuzmenkov.android.nrgcarsapplication.model.Repository;
import com.oleg_kuzmenkov.android.nrgcarsapplication.view.CarsListView;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CarsPresenter implements Repository.ReadCarsCallback {

    private CarsListView mCarsView;
    private Repository mRepository;

    private List<Car> mCarsList;

    public CarsPresenter() { }

    public void setView(CarsListView newsView) {
        mCarsView = newsView;
    }

    public void setRepository(Repository repository) {
        mRepository = repository;
    }

    /**
     * Detach presenter with view and repository
     */
    public void detach() {
        mCarsView = null;
        mRepository = null;
    }

    /**
     * Get cars list from Model
     */
     public void getCarsList(String filter) {
         mRepository.getCarsList(filter,this);
    }

    /**
     * Get sorted car list
     */
    public void getSortedList() {
        if(mCarsList != null){
            sortByModel(mCarsList);
            mCarsView.displayCars(mCarsList);
        }
    }

    /**
     * This is callback from Model. Show cars list
     */
    @Override
    public void onFinished(List<Car> list) {
        mCarsList = list;
        mCarsView.displayCars(mCarsList);
    }

    /**
     * Sort cars list by model
     */
    private void sortByModel(List<Car> list) {
        Collections.sort(list, new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o1.getModel().compareTo(o2.getModel());
            }
        });
    }
}
