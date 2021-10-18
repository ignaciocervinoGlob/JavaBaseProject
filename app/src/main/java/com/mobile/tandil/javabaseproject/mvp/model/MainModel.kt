package com.mobile.tandil.javabaseproject.mvp.model

import com.mobile.tandil.javabaseproject.data.database.ParkingSystemDatabase
import com.mobile.tandil.javabaseproject.mvp.contract.MainContract

class MainModel(private val parkingDatabase: ParkingSystemDatabase) : MainContract.Model {

    override fun setParkingLots(lots: Int) {
        parkingDatabase.parkingLots = lots
    }

    override fun getParkingLots(): Int = parkingDatabase.parkingLots
}
