package com.mobile.tandil.javabaseproject.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import com.mobile.tandil.javabaseproject.R;
import com.mobile.tandil.javabaseproject.databinding.DialogFragmentSetParkingLotsBinding;
import com.mobile.tandil.javabaseproject.listener.ParkingLotsInputListener;
import com.mobile.tandil.javabaseproject.mvp.contract.SetParkingLotsContract;
import com.mobile.tandil.javabaseproject.mvp.presenter.SetParkingLotsPresenter;
import com.mobile.tandil.javabaseproject.mvp.view.SetParkingLotsView;

public class SetParkingLotsFragmentDialog extends DialogFragment {
    private SetParkingLotsContract.SetParkingLotsPresenter presenter;
    private DialogFragmentSetParkingLotsBinding binding;
    private ParkingLotsInputListener parkingLotsInputListener;

    public static SetParkingLotsFragmentDialog newInstance() {
        return new SetParkingLotsFragmentDialog();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DialogFragmentSetParkingLotsBinding.inflate(getLayoutInflater());
        presenter = new SetParkingLotsPresenter(new SetParkingLotsView(this, binding), parkingLotsInputListener);
        setListeners();
        return binding.getRoot();
    }

    private void setListeners() {
        binding.buttonFragmentSetParkingLotsSubmit.setOnClickListener(view -> presenter.onSubmitButtonPressed());
        binding.buttonFragmentSetParkingLotsCancel.setOnClickListener(view -> presenter.onCancelButtonPressed());
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            parkingLotsInputListener = (ParkingLotsInputListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.getString(R.string.text_class_cast_exception, getActivity().toString()));
        }
    }
}
