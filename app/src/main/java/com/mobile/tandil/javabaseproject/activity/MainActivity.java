package com.mobile.tandil.javabaseproject.activity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.mobile.tandil.javabaseproject.databinding.ActivityMainBinding;
import com.mobile.tandil.javabaseproject.listener.ParkingLotsInputListener;
import com.mobile.tandil.javabaseproject.mvp.contract.MainActivityContract;
import com.mobile.tandil.javabaseproject.mvp.model.SelectParkingModel;
import com.mobile.tandil.javabaseproject.mvp.presenter.SelectParkingPresenter;
import com.mobile.tandil.javabaseproject.mvp.view.SelectParkingView;

public class MainActivity extends AppCompatActivity implements ParkingLotsInputListener {
    private ActivityMainBinding binding;
    private MainActivityContract.MainActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        presenter = new SelectParkingPresenter(new SelectParkingModel(), new SelectParkingView(this, binding));

        setListeners();
    }

    private void setListeners() {
        binding.buttonMainActivitySelectParking.setOnClickListener(view -> presenter.onSetParkingLotsButtonPressed());
        binding.buttonMainActivityNewReservation.setOnClickListener(view -> presenter.onNewParkingReservationButtonPressed());
    }

    @Override
    public void shareLotsInput(int lots) {
        presenter.setParkingLots(lots);
    }
}
