package com.mobile.tandil.javabaseproject.mvp.contract;

public interface SetParkingLotsContract {

    interface SetParkingLotsPresenter {
        void onSubmitButtonPressed();

        void onCancelButtonPressed();
    }

    interface SetParkingLotsView {
        void closeSetParkingLotsDialog();

        String getParkingLots();

        void showParkingLots(int lots);

        void showErrorMessage();
    }
}
