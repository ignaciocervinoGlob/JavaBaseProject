package com.mobile.tandil.javabaseproject.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mobile.tandil.javabaseproject.data.database.ParkingSystemDatabase
import com.mobile.tandil.javabaseproject.mvp.contract.MainContract
import com.mobile.tandil.javabaseproject.mvp.model.MainModel
import com.mobile.tandil.javabaseproject.mvp.presenter.MainPresenter
import com.mobile.tandil.javabaseproject.mvp.view.MainView

class MainActivity : AppCompatActivity() {
    private lateinit var presenter: MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = MainPresenter(MainModel(ParkingSystemDatabase), MainView(this))
    }
}
