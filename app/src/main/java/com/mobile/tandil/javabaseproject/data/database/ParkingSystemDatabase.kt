package com.mobile.tandil.javabaseproject.data.database

import com.mobile.tandil.javabaseproject.data.entity.ParkingReservation
import com.mobile.tandil.javabaseproject.utils.ConstantUtils
import java.util.Collections

object ParkingSystemDatabase {
    private val reservations: MutableMap<Int, MutableList<ParkingReservation>> = mutableMapOf()
    var parkingLots: Int = ConstantUtils.EMPTY_PARKING_LOT

    fun addReservation(newReservation: ParkingReservation) {
        with(newReservation.parkingLot) {
            if (reservations.containsKey(this)) {
                reservations[this]?.add(newReservation)
            } else {
                reservations[this] = mutableListOf(newReservation)
            }
        }
    }

    fun getReservations() = Collections.unmodifiableMap(reservations)
}
