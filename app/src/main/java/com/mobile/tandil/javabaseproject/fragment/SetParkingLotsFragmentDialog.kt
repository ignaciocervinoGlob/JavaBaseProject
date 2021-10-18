package com.mobile.tandil.javabaseproject.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.mobile.tandil.javabaseproject.mvp.contract.SetParkingLotsContract
import com.mobile.tandil.javabaseproject.mvp.presenter.SetParkingLotsPresenter
import com.mobile.tandil.javabaseproject.mvp.view.SetParkingLotsView

class SetParkingLotsFragmentDialog : DialogFragment() {
    private lateinit var presenter: SetParkingLotsContract.Presenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        presenter = SetParkingLotsPresenter(SetParkingLotsView(this))
        return presenter.getBinding().root
    }
}
