package com.mobile.tandil.javabaseproject.mvp.contract;

public interface MainActivityContract {

    interface MainActivityModel {
        void setParkingLots(int lots);

        int getParkingLots();
    }

    interface MainActivityPresenter {
        void onSetParkingLotsButtonPressed();

        void setParkingLots(int lots);

        void onNewParkingReservationButtonPressed();
    }

    interface MainActivityView {
        void showSelectParkingLotsDialogFragment();

        void showNewParkingReservationActivity();
    }
}
