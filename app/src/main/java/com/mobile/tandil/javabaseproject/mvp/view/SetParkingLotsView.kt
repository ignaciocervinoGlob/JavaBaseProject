package com.mobile.tandil.javabaseproject.mvp.view

import androidx.fragment.app.DialogFragment
import com.mobile.tandil.javabaseproject.R
import com.mobile.tandil.javabaseproject.databinding.DialogFragmentSetParkingLotsBinding
import com.mobile.tandil.javabaseproject.mvp.contract.SetParkingLotsContract
import com.mobile.tandil.javabaseproject.mvp.view.base.FragmentView
import com.mobile.tandil.javabaseproject.utils.GeneralUtils

class SetParkingLotsView(dialogFragment: DialogFragment) : FragmentView(dialogFragment), SetParkingLotsContract.View {
    private var binding: DialogFragmentSetParkingLotsBinding = DialogFragmentSetParkingLotsBinding.inflate(dialogFragment.layoutInflater)

    override fun getBinding(): DialogFragmentSetParkingLotsBinding {
        return binding
    }

    override fun onSubmitBtnClick(onClick: () -> Unit) {
        binding.buttonFragmentSetParkingLotsSubmit.setOnClickListener { onClick() }
    }

    override fun onCancelBtnClick(onClick: () -> Unit) {
        binding.buttonFragmentSetParkingLotsCancel.setOnClickListener { onClick() }
    }

    override fun closeSetParkingLotsDialog() {
        fragment?.dismiss()
    }

    override fun getParkingLots(): String = binding.inputSetParkingLotsFragment.text.toString()

    override fun showParkingLots(lots: Int) {
        GeneralUtils.showToast(context, context.getString(R.string.main_activity_toast_parking_lots, lots))
    }

    override fun showErrorMessage() {
        GeneralUtils.showToast(context, context.getString(R.string.main_activity_error_toast_parking_lots))
    }
}
