package com.mobile.tandil.javabaseproject.mvp.presenter;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import com.mobile.tandil.javabaseproject.mvp.contract.MainContract;
import com.mobile.tandil.javabaseproject.mvp.model.MainModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MainPresenterTest {
    private static final int PARKING_LOT_TEST = 5;
    private MainContract.MainActivityModel model;
    private MainContract.MainActivityPresenter presenter;
    @Mock
    private MainContract.MainActivityView view;

    @Before
    public void setUp() {
        model = new MainModel();
        presenter = new MainPresenter(model, view);
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
