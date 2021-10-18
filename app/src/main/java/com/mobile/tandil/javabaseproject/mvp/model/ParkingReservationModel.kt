package com.mobile.tandil.javabaseproject.mvp.model

import com.mobile.tandil.javabaseproject.data.database.ParkingSystemDatabase
import com.mobile.tandil.javabaseproject.data.entity.ParkingReservation
import com.mobile.tandil.javabaseproject.mvp.contract.ParkingReservationContract
import com.mobile.tandil.javabaseproject.utils.DateType
import java.util.Calendar

class ParkingReservationModel(private val parkingDatabase: ParkingSystemDatabase) : ParkingReservationContract.Model {
    private var dateType: DateType = DateType.START
    private val reservation = ParkingReservation()

    override fun addReservation(lot: Int, code: String) {
        parkingDatabase.addReservation(reservation)
        reservation.parkingLot = lot
        reservation.securityCode = code
    }

    override fun getReservation(): ParkingReservation = reservation

    override fun setDate(date: Calendar) {
        if (dateType == DateType.START) {
            reservation.startDate = date
        } else {
            reservation.endDate = date
        }
    }

    override fun setTime(selection: Calendar) {
        if (dateType == DateType.START) {
            reservation.startDate = selection
        } else {
            reservation.endDate = selection
        }
    }

    override fun setStartDateType() {
        dateType = DateType.START
    }

    override fun setEndDateType() {
        dateType = DateType.END
    }

    override fun getDateType(): DateType = dateType

    override fun getParkingLot(): Int = reservation.parkingLot

    override fun getSecurityCode(): String = reservation.securityCode

    override fun getStartDate(): Calendar = reservation.startDate

    override fun getEndDate(): Calendar = reservation.endDate
}
