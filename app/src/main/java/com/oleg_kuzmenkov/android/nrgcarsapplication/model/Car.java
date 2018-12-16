package com.oleg_kuzmenkov.android.nrgcarsapplication.model;

public class Car {
    private String mCarId;
    private String mModel;
    private String mCreationDate;
    private String mTopSpeed;
    private String mPrice;

    public Car() {
    }

    public String getCarId() {
        return mCarId;
    }

    public void setCarId(String carId) {
        mCarId = carId;
    }

    public String getModel() {
        return mModel;
    }

    public void setModel(String model) {
        mModel = model;
    }

    public String getCreationDate() {
        return mCreationDate;
    }

    public void setCreationDate(String creationDate) {
        mCreationDate = creationDate;
    }

    public String getTopSpeed() {
        return mTopSpeed;
    }

    public void setTopSpeed(String topSpeed) {
        mTopSpeed = topSpeed;
    }

    public String getPrice() {
        return mPrice;
    }

    public void setPrice(String price) {
        mPrice = price;
    }
}
