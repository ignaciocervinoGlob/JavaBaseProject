package com.mobile.tandil.javabaseproject.mvp.presenter

import com.mobile.tandil.javabaseproject.mvp.contract.MainContract

class MainPresenter(private val model: MainContract.Model, private val view: MainContract.View) : MainContract.Presenter {

    init {
        view.onSelectParkingBtnClick { onSelectParkingButtonPressed() }
        view.onNewReservationBtnClick { onNewReservationButtonPressed() }
    }

    override fun onSelectParkingButtonPressed() {
        view.showSelectParkingLotsDialogFragment()
    }

    override fun setParkingLots(lots: Int) {
        model.setParkingLots(lots)
    }

    override fun onNewReservationButtonPressed() {
        view.showNewParkingReservationActivity()
    }
}
