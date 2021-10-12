package com.mobile.tandil.javabaseproject.mvp.presenter;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import com.mobile.tandil.javabaseproject.mvp.contract.MainActivityContract;
import com.mobile.tandil.javabaseproject.mvp.model.SelectParkingModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SelectParkingPresenterTest {
    private static final int PARKING_LOT_TEST = 5;
    private MainActivityContract.MainActivityModel model;
    private MainActivityContract.MainActivityPresenter presenter;
    @Mock
    private MainActivityContract.MainActivityView view;

    @Before
    public void setUp() {
        model = new SelectParkingModel();
        presenter = new SelectParkingPresenter(model, view);
    }

    @Test
    public void onSetParkingLotsButtonPressedTest() {
        presenter.onSetParkingLotsButtonPressed();
        verify(view).showSelectParkingLotsDialogFragment();
    }

    @Test
    public void setParkingLotsTest() {
        presenter.setParkingLots(PARKING_LOT_TEST);
        assertEquals(PARKING_LOT_TEST, model.getParkingLots());
    }

    @Test
    public void onNewParkingReservationButtonPressedTest() {
        presenter.onNewParkingReservationButtonPressed();
        verify(view).showNewParkingReservationActivity();
    }
}
