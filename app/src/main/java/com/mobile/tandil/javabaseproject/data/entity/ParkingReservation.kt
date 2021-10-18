package com.mobile.tandil.javabaseproject.data.entity

import com.mobile.tandil.javabaseproject.utils.ConstantUtils
import java.util.Calendar

data class ParkingReservation(
    var startDate: Calendar = Calendar.getInstance(),
    var endDate: Calendar = Calendar.getInstance(),
    var parkingLot: Int = ConstantUtils.EMPTY_PARKING_LOT,
    var securityCode: String = ConstantUtils.EMPTY_STRING
)
