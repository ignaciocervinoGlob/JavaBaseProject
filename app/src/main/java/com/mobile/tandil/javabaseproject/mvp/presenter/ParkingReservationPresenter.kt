package com.mobile.tandil.javabaseproject.mvp.presenter

import com.mobile.tandil.javabaseproject.mvp.contract.ParkingReservationContract
import com.mobile.tandil.javabaseproject.utils.ConstantUtils
import com.mobile.tandil.javabaseproject.utils.DateType
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class ParkingReservationPresenter(
    private val view: ParkingReservationContract.View,
    private val model: ParkingReservationContract.Model
) : ParkingReservationContract.Presenter {

    init {
        view.onCancelBtnClick { onCancelButtonPressed() }
        view.onEndDateBtnClick { onEndDateButtonPressed() }
        view.onStartDateBtnClick { onStartDateButtonPressed() }
        view.onSubmitBtnClick { onSubmitButtonPressed() }
        view.dateListener { year, monthOfYear, dayOfMonth -> onSetDate(year, monthOfYear, dayOfMonth) }
        view.timeListener { hour, minute -> onSetTime(hour, minute) }
    }

    override fun onCancelButtonPressed() {
        view.returnMainActivity()
    }

    override fun onStartDateButtonPressed() {
        model.setStartDateType()
        view.showDatePicker()
    }

    override fun onEndDateButtonPressed() {
        model.setEndDateType()
        view.showDatePicker()
    }

    override fun onSetDate(year: Int, monthOfYear: Int, dayOfMonth: Int) {
        val date = Calendar.getInstance()
        date[year, monthOfYear] = dayOfMonth
        model.setDate(date)
        view.showTimePicker()
    }

    override fun onSetTime(hour: Int, minute: Int) {
        val currentDate: Calendar = if (model.getDateType() === DateType.START) {
            model.getStartDate()
        } else {
            model.getEndDate()
        }
        currentDate.set(Calendar.HOUR_OF_DAY, hour)
        currentDate.set(Calendar.MINUTE, minute)
        model.setTime(currentDate)
        val dateFormat = SimpleDateFormat(ConstantUtils.DATE_FORMAT_STRING, Locale.US)
        if (model.getDateType() === DateType.START) {
            view.showStartDateTime(dateFormat.format(model.getStartDate().time))
        } else {
            view.showEndDateTime(dateFormat.format(model.getEndDate().time))
        }
    }

    override fun onSubmitButtonPressed() {
        val lotString: String = view.getParkingLot()
        val securityCode: String = view.getSecurityCode()
        if (lotString.isEmpty() || securityCode.isEmpty()) {
            view.showErrorMessage()
        } else {
            model.addReservation(lotString.toInt(), securityCode)
            view.returnMainActivity()
        }
    }
}
