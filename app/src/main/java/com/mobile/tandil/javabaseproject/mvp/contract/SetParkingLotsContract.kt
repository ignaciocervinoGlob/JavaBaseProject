package com.mobile.tandil.javabaseproject.mvp.contract

import com.mobile.tandil.javabaseproject.databinding.DialogFragmentSetParkingLotsBinding

interface SetParkingLotsContract {
    interface Presenter {
        fun onSubmitButtonPressed()
        fun onCancelButtonPressed()
        fun getBinding(): DialogFragmentSetParkingLotsBinding
    }

    interface View {
        fun onSubmitBtnClick(onClick: () -> Unit)
        fun onCancelBtnClick(onClick: () -> Unit)
        fun closeSetParkingLotsDialog()
        fun getParkingLots(): String
        fun showParkingLots(lots: Int)
        fun showErrorMessage()
        fun getBinding(): DialogFragmentSetParkingLotsBinding
    }
}
