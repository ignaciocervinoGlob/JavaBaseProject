package com.mobile.tandil.javabaseproject.mvp.view

import android.app.Activity
import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.app.TimePickerDialog
import android.app.TimePickerDialog.OnTimeSetListener
import android.content.Intent
import com.mobile.tandil.javabaseproject.R
import com.mobile.tandil.javabaseproject.activity.MainActivity
import com.mobile.tandil.javabaseproject.databinding.ActivityNewParkingReservationBinding
import com.mobile.tandil.javabaseproject.mvp.contract.ParkingReservationContract
import com.mobile.tandil.javabaseproject.mvp.view.base.ActivityView
import com.mobile.tandil.javabaseproject.utils.GeneralUtils
import java.util.Calendar

class ParkingReservationView(activity: Activity) : ActivityView(activity), ParkingReservationContract.View {
    private val binding: ActivityNewParkingReservationBinding = ActivityNewParkingReservationBinding.inflate(activity.layoutInflater)
    private lateinit var dateListener: OnDateSetListener
    private lateinit var timeListener: OnTimeSetListener

    init {
        activity.setContentView(binding.root)
    }

    override fun onCancelBtnClick(onClick: () -> Unit) {
        binding.buttonNewParkingReservationCancel.setOnClickListener { onClick() }
    }

    override fun onSubmitBtnClick(onClick: () -> Unit) {
        binding.buttonNewParkingReservationSubmit.setOnClickListener { onClick() }
    }

    override fun onStartDateBtnClick(onClick: () -> Unit) {
        binding.buttonNewParkingReservationActivityStartDate.setOnClickListener { onClick() }
    }

    override fun onEndDateBtnClick(onClick: () -> Unit) {
        binding.buttonNewParkingReservationActivityEndDate.setOnClickListener { onClick() }
    }

    override fun dateListener(onClick: (year: Int, monthOfYear: Int, dayOfMonth: Int) -> Unit) {
        dateListener = OnDateSetListener { _, year, monthOfYear, dayOfMonth -> onClick(year, monthOfYear, dayOfMonth) }
    }

    override fun timeListener(onClick: (hour: Int, minute: Int) -> Unit) {
        timeListener = OnTimeSetListener { _, hour, minute -> onClick(hour, minute) }
    }

    override fun showDatePicker() {
        val calendar = Calendar.getInstance()
        activity?.let {
            DatePickerDialog(
                it,
                dateListener,
                calendar[Calendar.YEAR],
                calendar[Calendar.MONTH],
                calendar[Calendar.DAY_OF_MONTH]
            ).apply {
                datePicker.minDate = System.currentTimeMillis() - oneDayInMillis
                show()
            }
        }
    }

    override fun showTimePicker() {
        val calendar = Calendar.getInstance()
        activity?.let {
            val timePickerDialog =
                TimePickerDialog(it, timeListener, calendar[Calendar.HOUR_OF_DAY], calendar[Calendar.MINUTE], true)
            timePickerDialog.show()
        }
    }

    override fun showStartDateTime(startDate: String) {
        binding.textNewParkingReservationActivityStartDate.text = startDate
    }

    override fun showEndDateTime(endDate: String) {
        binding.textNewParkingReservationActivityEndDate.text = endDate
    }

    override fun getParkingLot(): String = binding.inputParkingLotReservationActivity.editText?.text.toString()

    override fun getSecurityCode(): String = binding.inputSecurityCodeReservationActivity.editText?.text.toString()

    override fun showErrorMessage() {
        context?.let {
            GeneralUtils.showToast(it, it.getString(R.string.parking_reservation_activity_error_toast_empty_input))
        }
    }

    override fun returnMainActivity() {
        context?.let {
            it.startActivity(Intent(it, MainActivity::class.java))
            GeneralUtils.showToast(it, it.getString(R.string.parking_reservation_activity_success_toast))
        }
    }

    companion object {
        private const val oneDayInMillis = 1000
    }
}
