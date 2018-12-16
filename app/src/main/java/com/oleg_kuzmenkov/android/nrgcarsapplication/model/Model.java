package com.oleg_kuzmenkov.android.nrgcarsapplication.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.oleg_kuzmenkov.android.nrgcarsapplication.view.CarsListActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class Model implements Repository {
    private static Model sRepository;

    private Database mDatabase;

    public static Model get(Context context) {
        if (sRepository == null) {
            sRepository = new Model(context);
        }

        return sRepository;
    }

    private Model(Context context) {
        mDatabase = new Database(context);
    }

    /**
     * Get cars list from local database
     */
    @Override
    public void getCarsList(String filter, final ReadCarsCallback listener) {

        getObservable(filter).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Car>>() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onNext(List<Car> cars) {
                listener.onFinished(cars);
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onComplete() {
                Log.i(CarsListActivity.LOG_TAG, "onComplete");
            }
        });
    }

    /**
     * Read cars list from local database
     */
    private List<Car> readCarsList(String filter) {
        SQLiteDatabase database = mDatabase.getWritableDatabase();

        List<Car> carsList = new ArrayList<>();

        Cursor c = database.rawQuery("select * from " + Database.TABLE_CAR + " where " +
                Database.COLUMN_CAR_MODEL + " like ?", new String[]{"%" + filter + "%"});

        if (c.moveToFirst()) {
            int carModelColIndex = c.getColumnIndex(Database.COLUMN_CAR_MODEL);
            int carCreationDateColIndex = c.getColumnIndex(Database.COLUMN_CREATION_DATE);
            int carTopSpeedColIndex = c.getColumnIndex(Database.COLUMN_TOP_SPEED);
            int carPriceColIndex = c.getColumnIndex(Database.COLUMN_PRICE);

            do {
                Car car = new Car();

                try {
                    car.setModel(c.getString(carModelColIndex));
                    car.setCreationDate(c.getString(carCreationDateColIndex));
                    car.setTopSpeed(c.getString(carTopSpeedColIndex));
                    car.setPrice(c.getString(carPriceColIndex));

                    carsList.add(car);
                } catch (Exception e) {
                    Log.e(CarsListActivity.LOG_TAG, "Cars contains an error!");
                }
            } while (c.moveToNext());
        }

        c.close();
        return carsList;
    }

    /**
     * Get Callable for reading cars list
     */
    private Callable<List<Car>> getCallable(final String filter) {
        return new Callable<List<Car>>(){
            public List<Car> call() {
                return readCarsList(filter);
            }
        };
    }

    /**
     * Make Observable
     */
    private  <T> Observable<T> makeObservable(final Callable<T> callable) {
        return Observable.create(new ObservableOnSubscribe<T>() {
            @Override
            public void subscribe(ObservableEmitter<T> emitter) {
                try {
                    T observed = callable.call();
                    if (observed != null) {
                        emitter.onNext(observed);
                    }
                    emitter.onComplete();
                } catch (Exception ex) {
                    emitter.onError(ex);
                }
            }
        });
    }

    /**
     * Get Observable
     */
    private Observable<List<Car>> getObservable(String filter) {
        return makeObservable(getCallable(filter));
    }
}
