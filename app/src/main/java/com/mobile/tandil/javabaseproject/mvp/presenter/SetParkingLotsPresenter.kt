package com.mobile.tandil.javabaseproject.mvp.presenter

import com.mobile.tandil.javabaseproject.databinding.DialogFragmentSetParkingLotsBinding
import com.mobile.tandil.javabaseproject.mvp.contract.SetParkingLotsContract

class SetParkingLotsPresenter(private val view: SetParkingLotsContract.View) : SetParkingLotsContract.Presenter {

    init {
        view.onSubmitBtnClick { onSubmitButtonPressed() }
        view.onCancelBtnClick { onCancelButtonPressed() }
    }

    override fun onSubmitButtonPressed() {
        val lotsString: String = view.getParkingLots()
        if (lotsString.isEmpty()) {
            view.showErrorMessage()
        } else {
            val lots = lotsString.toInt()
            view.showParkingLots(lots)
            view.closeSetParkingLotsDialog()
        }
    }

    override fun onCancelButtonPressed() {
        view.closeSetParkingLotsDialog()
    }

    override fun getBinding(): DialogFragmentSetParkingLotsBinding {
        return view.getBinding()
    }
}
