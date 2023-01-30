package com.example.supermarket;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class RateActivity extends DialogFragment {

    public interface SaveRatingListener {
        void didFinishRateActivity();
    }

    public RateActivity() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.rate_activity, container);

        getDialog().setTitle("Rate the Following:");

        Button submit = view.findViewById(R.id.buttonSubmit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveRatings();
            }
        });
    }

    private void saveRatings() {
        SaveRatingListener activity = (SaveRatingListener) getActivity();
        activity.didFinishRateActivity();
        getDialog().dismiss();
    }
}
