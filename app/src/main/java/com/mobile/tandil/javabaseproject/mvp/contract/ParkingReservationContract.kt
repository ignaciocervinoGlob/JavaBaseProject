package com.mobile.tandil.javabaseproject.mvp.contract

import com.mobile.tandil.javabaseproject.data.entity.ParkingReservation
import com.mobile.tandil.javabaseproject.utils.DateType
import java.util.Calendar

interface ParkingReservationContract {
    interface Presenter {
        fun onCancelButtonPressed()
        fun onStartDateButtonPressed()
        fun onEndDateButtonPressed()
        fun onSubmitButtonPressed()
        fun onSetDate(year: Int, monthOfYear: Int, dayOfMonth: Int)
        fun onSetTime(hour: Int, minute: Int)
    }

    interface View {
        fun onCancelBtnClick(onClick: () -> Unit)
        fun onSubmitBtnClick(onClick: () -> Unit)
        fun onStartDateBtnClick(onClick: () -> Unit)
        fun onEndDateBtnClick(onClick: () -> Unit)
        fun showDatePicker()
        fun returnMainActivity()
        fun showTimePicker()
        fun showStartDateTime(startDate: String)
        fun showEndDateTime(endDate: String)
        fun getParkingLot(): String
        fun getSecurityCode(): String
        fun showErrorMessage()
        fun dateListener(onClick: (year: Int, monthOfYear: Int, dayOfMonth: Int) -> Unit)
        fun timeListener(onClick: (hour: Int, minute: Int) -> Unit)
    }

    interface Model {
        fun addReservation(lot: Int, code: String)
        fun getReservation(): ParkingReservation
        fun setDate(date: Calendar)
        fun setTime(selection: Calendar)
        fun setStartDateType()
        fun setEndDateType()
        fun getStartDate(): Calendar
        fun getEndDate(): Calendar
        fun getDateType(): DateType
        fun getParkingLot(): Int
        fun getSecurityCode(): String
    }
}
