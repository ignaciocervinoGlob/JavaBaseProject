package com.mobile.tandil.javabaseproject.mvp.contract;

public interface MainActivityContract {
    interface MainActivityModel {
        void setParkingLots(int lots);

        int getParkingLots();
    }

    interface MainActivityPresenter {
        void onSetParkingLotsButtonPressed();
    }

    interface MainActivityView {
        void showParkingLots(int lots);

        String getParkingLots();
    }
}
