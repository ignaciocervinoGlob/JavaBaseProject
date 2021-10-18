package com.mobile.tandil.javabaseproject.mvp.view

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.mobile.tandil.javabaseproject.activity.ParkingReservationActivity
import com.mobile.tandil.javabaseproject.databinding.ActivityMainBinding
import com.mobile.tandil.javabaseproject.fragment.SetParkingLotsFragmentDialog
import com.mobile.tandil.javabaseproject.mvp.contract.MainContract
import com.mobile.tandil.javabaseproject.mvp.view.base.ActivityView

class MainView(activity: Activity) : ActivityView(activity), MainContract.View {
    private val binding: ActivityMainBinding = ActivityMainBinding.inflate(activity.layoutInflater)

    init {
        activity.setContentView(binding.root)
    }

    override fun showSelectParkingLotsDialogFragment() {
        SetParkingLotsFragmentDialog().show((activity as AppCompatActivity).supportFragmentManager, DIALOG_TAG)
    }

    override fun showNewParkingReservationActivity() {
        activity?.startActivity(Intent(activity, ParkingReservationActivity::class.java))
    }

    override fun onSelectParkingBtnClick(onClick: () -> Unit) {
        binding.buttonMainActivitySelectParking.setOnClickListener { onClick() }
    }

    override fun onNewReservationBtnClick(onClick: () -> Unit) {
        binding.buttonMainActivityNewReservation.setOnClickListener { onClick() }
    }

    companion object {
        private const val DIALOG_TAG = "SetParkingLotsView"
    }
}
