package com.mobile.tandil.javabaseproject.mvp.presenter;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.mobile.tandil.javabaseproject.mvp.contract.ParkingReservationActivityContract;
import com.mobile.tandil.javabaseproject.mvp.model.ParkingReservationModel;
import com.mobile.tandil.javabaseproject.utils.ConstantUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

@RunWith(MockitoJUnitRunner.class)
public class ParkingReservationPresenterTest {
    private static final int YEAR = 2021;
    private static final int MONTH = 10;
    private static final int START_DAY = 7;
    private static final int END_DAY = 20;
    private static final int HOUR = 10;
    private static final int MINUTE = 0;
    private static final int ZERO = 0;
    private static final String PARKING_LOT_STRING = "1";
    private static final String SECURITY_CODE = "1234";
    private static final String EMPTY_SECURITY_CODE = "";
    private ParkingReservationActivityContract.ParkingReservationActivityPresenter presenter;
    private ParkingReservationActivityContract.ParkingReservationActivityModel model;
    @Mock
    private ParkingReservationActivityContract.ParkingReservationActivityView view;

    @Before
    public void setUp() {
        model = new ParkingReservationModel();
        presenter = new ParkingReservationPresenter(view, model);
    }

    private Calendar getStartDate() {
        Calendar date = Calendar.getInstance();
        date.set(YEAR, MONTH, START_DAY);
        date.set(Calendar.SECOND, ZERO);
        date.set(Calendar.MILLISECOND, ZERO);
        return date;
    }

    private Calendar getEndDate() {
        Calendar date = Calendar.getInstance();
        date.set(YEAR, MONTH, END_DAY);
        date.set(Calendar.SECOND, ZERO);
        date.set(Calendar.MILLISECOND, ZERO);
        return date;
    }

    private Calendar getStartDateTime() {
        Calendar dateTime = getStartDate();
        dateTime.set(Calendar.HOUR_OF_DAY, HOUR);
        dateTime.set(Calendar.MINUTE, MINUTE);
        return dateTime;
    }

    private Calendar getEndDateTime() {
        Calendar dateTime = getEndDate();
        dateTime.set(Calendar.HOUR_OF_DAY, HOUR);
        dateTime.set(Calendar.MINUTE, MINUTE);
        return dateTime;
    }

    private String getDateAsString(Calendar date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(ConstantUtils.DATE_FORMAT_STRING, Locale.US);
        return dateFormat.format(date);
    }

    @Test
    public void onCancelButtonPressed() {
        presenter.onCancelButtonPressed();
        verify(view).returnMainActivity();
    }

    @Test
    public void onStartDateButtonPressed() {
        presenter.onStartDateButtonPressed();
        model.setStartDateType();
        verify(view).showDatePicker();
    }

    @Test
    public void onEndDateButtonPressed() {
        presenter.onEndDateButtonPressed();
        model.setEndDateType();
        verify(view).showDatePicker();
    }

    @Test
    public void onSetStartDate() {
        model.setStartDateType();
        presenter.onSetDate(YEAR, MONTH, START_DAY);
        assertEquals(getStartDate().get(Calendar.YEAR), model.getStartDate().get(Calendar.YEAR));
        assertEquals(getStartDate().get(Calendar.MONTH), model.getStartDate().get(Calendar.MONTH));
        assertEquals(getStartDate().get(Calendar.DAY_OF_MONTH), model.getStartDate().get(Calendar.DAY_OF_MONTH));
        verify(view).showTimePicker();
    }

    @Test
    public void onSetEndDate() {
        model.setEndDateType();
        presenter.onSetDate(YEAR, MONTH, END_DAY);
        assertEquals(getEndDate().get(Calendar.YEAR), model.getEndDate().get(Calendar.YEAR));
        assertEquals(getEndDate().get(Calendar.MONTH), model.getEndDate().get(Calendar.MONTH));
        assertEquals(getEndDate().get(Calendar.DAY_OF_MONTH), model.getEndDate().get(Calendar.DAY_OF_MONTH));
        verify(view).showTimePicker();
    }

    @Test
    public void onSetStartDateTime() {
        model.setStartDateType();
        presenter.onSetDate(YEAR, MONTH, START_DAY);
        presenter.onSetTime(HOUR, MINUTE);
        assertEquals(getStartDateTime().get(Calendar.HOUR_OF_DAY), model.getStartDate().get(Calendar.HOUR));
        assertEquals(getStartDateTime().get(Calendar.MINUTE), model.getStartDate().get(Calendar.MINUTE));
        verify(view).showStartDateTime(Matchers.anyString());
    }

    @Test
    public void onSetEndDateTime() {
        presenter.onSetDate(YEAR, MONTH, END_DAY);
        presenter.onSetTime(HOUR, MINUTE);
        assertEquals(getEndDateTime().get(Calendar.HOUR_OF_DAY), model.getEndDate().get(Calendar.HOUR));
        assertEquals(getEndDateTime().get(Calendar.MINUTE), model.getEndDate().get(Calendar.MINUTE));
        verify(view).showEndDateTime(Matchers.anyString());
    }

    @Test
    public void onSubmitButtonPressedError() {
        when(view.getParkingLot()).thenReturn(PARKING_LOT_STRING);
        when(view.getSecurityCode()).thenReturn(EMPTY_SECURITY_CODE);
        presenter.onSubmitButtonPressed();
        verify(view).showErrorMessage();
    }

    @Test
    public void onSubmitButtonPressedOk() {
        when(view.getParkingLot()).thenReturn(PARKING_LOT_STRING);
        when(view.getSecurityCode()).thenReturn(SECURITY_CODE);
        presenter.onSubmitButtonPressed();
        verify(view).returnMainActivity();
        verify(view).showSuccessMessage();
    }
}
