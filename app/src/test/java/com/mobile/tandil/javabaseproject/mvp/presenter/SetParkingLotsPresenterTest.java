package com.mobile.tandil.javabaseproject.mvp.presenter;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.mobile.tandil.javabaseproject.mvp.contract.SetParkingLotsContract;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SetParkingLotsPresenterTest {
    private static final String PARKING_LOT_STRING = "5";
    private static final String PARKING_LOT_EMPTY_STRING = "";
    private static final int PARKING_LOT = 5;
    private SetParkingLotsContract.SetParkingLotsPresenter presenter;
    @Mock
    private SetParkingLotsContract.SetParkingLotsView view;
    @Mock
    private ParkingLotsInputListener parkingLotsInputListener;

    @Before
    public void setUp() {
        presenter = new SetParkingLotsPresenter(view);
    }

    @Test
    public void onSubmitButtonPressedTestSuccess() {
        when(view.getParkingLots()).thenReturn(PARKING_LOT_STRING);
        presenter.onSubmitButtonPressed();
        verify(view).showParkingLots(PARKING_LOT);
        verify(view).closeSetParkingLotsDialog();
    }

    @Test
    public void onSubmitButtonPressedTestEmpty() {
        when(view.getParkingLots()).thenReturn(PARKING_LOT_EMPTY_STRING);
        presenter.onSubmitButtonPressed();
        verify(view).showErrorMessage();
    }

    @Test
    public void onCancelButtonPressedTest() {
        presenter.onCancelButtonPressed();
        verify(view).closeSetParkingLotsDialog();
    }
}
