package com.oleg_kuzmenkov.android.nrgcarsapplication.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.oleg_kuzmenkov.android.nrgcarsapplication.R;
import com.oleg_kuzmenkov.android.nrgcarsapplication.model.Car;

import java.util.List;

public class CarsListAdapter extends RecyclerView.Adapter<CarsListHolder> {
    private final Context mContext;
    private List<Car> mCars;

    CarsListAdapter(final Context context, List<Car> cars) {
        mContext = context;
        mCars = cars;
    }

    @Override
    public CarsListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.car_view, parent, false);
        return new CarsListHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarsListHolder holder, int position) {
        Car car = mCars.get(position);
        holder.bindCar(car, position);
    }

    @Override
    public int getItemCount() {
        return  mCars.size();
    }
}
