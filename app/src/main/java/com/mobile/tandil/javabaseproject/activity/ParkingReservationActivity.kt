package com.mobile.tandil.javabaseproject.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mobile.tandil.javabaseproject.data.database.ParkingSystemDatabase
import com.mobile.tandil.javabaseproject.mvp.contract.ParkingReservationContract
import com.mobile.tandil.javabaseproject.mvp.model.ParkingReservationModel
import com.mobile.tandil.javabaseproject.mvp.presenter.ParkingReservationPresenter
import com.mobile.tandil.javabaseproject.mvp.view.ParkingReservationView

class ParkingReservationActivity : AppCompatActivity() {
    private lateinit var presenter: ParkingReservationContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = ParkingReservationPresenter(ParkingReservationView(this), ParkingReservationModel(ParkingSystemDatabase))
    }
}
