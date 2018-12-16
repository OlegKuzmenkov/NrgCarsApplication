package com.oleg_kuzmenkov.android.nrgcarsapplication.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.oleg_kuzmenkov.android.nrgcarsapplication.R;
import com.oleg_kuzmenkov.android.nrgcarsapplication.model.Car;

public class CarsListHolder extends RecyclerView.ViewHolder {

    private TextView mCarId;
    private TextView mModel;
    private TextView mCreationDate;
    private TextView mTopSpeed;
    private TextView mPrice;

    private Car mCar;

    CarsListHolder(View itemView) {
        super(itemView);

        mCarId = itemView.findViewById(R.id.car_id);
        mModel = itemView.findViewById(R.id.car_model);
        mCreationDate = itemView.findViewById(R.id.car_creation_date);
        mTopSpeed = itemView.findViewById(R.id.car_top_speed);
        mPrice = itemView.findViewById(R.id.car_price);
    }

    /**
     * Bind car
     */
    void bindCar(Car car, int position) {
        mCar = car;

        mCarId.setText(String.format("Car # %d",(++position)));
        mModel.setText(mCar.getModel());
        mCreationDate.setText(String.format("Year: %s",mCar.getCreationDate()));
        mTopSpeed.setText(String.format("Top speed: %s km/h",mCar.getTopSpeed()));
        mPrice.setText(String.format("Price: %s$",mCar.getPrice()));
    }
}
