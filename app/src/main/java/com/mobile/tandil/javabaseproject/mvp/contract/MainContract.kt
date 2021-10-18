package com.mobile.tandil.javabaseproject.mvp.contract

interface MainContract {
    interface Model {
        fun setParkingLots(lots: Int)
        fun getParkingLots(): Int
    }

    interface Presenter {
        fun onSelectParkingButtonPressed()
        fun setParkingLots(lots: Int)
        fun onNewReservationButtonPressed()
    }

    interface View {
        fun showSelectParkingLotsDialogFragment()
        fun showNewParkingReservationActivity()
        fun onSelectParkingBtnClick(onClick: () -> Unit)
        fun onNewReservationBtnClick(onClick: () -> Unit)
    }
}
