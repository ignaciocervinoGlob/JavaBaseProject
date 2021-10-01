package com.mobile.tandil.javabaseproject.mvp.presenter;

import com.mobile.tandil.javabaseproject.mvp.contract.MainActivityContract;

public class SelectParkingPresenter implements MainActivityContract.MainActivityPresenter {
    private final MainActivityContract.MainActivityModel model;
    private final MainActivityContract.MainActivityView view;

    public SelectParkingPresenter(MainActivityContract.MainActivityModel model, MainActivityContract.MainActivityView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void onSetParkingLotsButtonPressed() {
        view.showSelectParkingLotsDialogFragment();
    }

    @Override
    public void setParkingLots(int lots) {
        model.setParkingLots(lots);
    }

    @Override
    public void onNewParkingReservationButtonPressed() {
        view.showNewParkingReservationActivity();
    }
}
