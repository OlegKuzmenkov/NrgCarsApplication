package com.oleg_kuzmenkov.android.nrgcarsapplication.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.oleg_kuzmenkov.android.nrgcarsapplication.dagger.DaggerCarsPresenterComponent;
import com.oleg_kuzmenkov.android.nrgcarsapplication.presenter.CarsPresenter;
import com.oleg_kuzmenkov.android.nrgcarsapplication.dagger.CarsPresenterModule;
import com.oleg_kuzmenkov.android.nrgcarsapplication.R;
import com.oleg_kuzmenkov.android.nrgcarsapplication.model.Car;
import com.oleg_kuzmenkov.android.nrgcarsapplication.model.Model;

import java.util.List;

import javax.inject.Inject;

public class CarsListActivity extends AppCompatActivity implements CarsListView {
    public static final String LOG_TAG = "LOGS";

    @Inject
    CarsPresenter mPresenter;

    private RecyclerView mRecycler;
    private CarsListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cars_list);

        initControls();

        DaggerCarsPresenterComponent.builder().carsPresenterModule(new CarsPresenterModule())
                .build().inject(this);

        setupPresenter();
        mPresenter.getCarsList("");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detach();
    }

    @Override
    public void displayCars(List<Car> list) {
        mAdapter = new CarsListAdapter(this, list);
        mRecycler.setAdapter(mAdapter);
    }

    /**
     * Initialize RecyclerView
     */
    private void initRecyclerView() {
        mRecycler = findViewById(R.id.cars_recycler_view);
        mRecycler.setLayoutManager(new LinearLayoutManager(this));
    }

    /**
     * Initialize all controls
     */
    private void initControls() {
        initRecyclerView();

        Button sortButton = findViewById(R.id.sort_button);
        sortButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.getSortedList();
            }
        });

        EditText editText = findViewById(R.id.filter_edit_text);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mPresenter.getCarsList(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    /**
     * Setup presenter
     */
    private void setupPresenter(){
        mPresenter.setView(this);
        mPresenter.setRepository(Model.get(this));
    }
}
