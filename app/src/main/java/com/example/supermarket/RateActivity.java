package com.example.supermarket;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import androidx.fragment.app.DialogFragment;


public class RateActivity extends DialogFragment {

    RatingBar liquor;
    RatingBar produce;
    RatingBar meat;
    RatingBar cheese;
    RatingBar checkout;

    public interface SaveRatingListener {
        void didFinishRateActivity(float a, float b, float c, float d, float e);
    }

    public RateActivity() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.rate_activity, container);

        getDialog().setTitle("Rate the Following:");

        final RatingBar lq = view.findViewById(R.id.liquorRating);
        lq.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                liquor.setRating(v);
            }
        });

        final RatingBar pd = view.findViewById(R.id.produceRating);
        pd.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                produce.setRating(v);
            }
        });

        final RatingBar md = view.findViewById(R.id.meatRating);
        md.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                meat.setRating(v);
            }
        });

        final RatingBar cs = view.findViewById(R.id.cheeseRating);
        cs.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                cheese.setRating(v);
            }
        });

        final RatingBar ec = view.findViewById(R.id.checkoutRating);
        ec.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                checkout.setRating(v);
            }
        });

        Button submit = view.findViewById(R.id.buttonSubmit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveRatings(liquor.getRating(), produce.getRating(), meat.getRating(), cheese.getRating(), checkout.getRating());
            }
        });
        return view;
    }

    private void saveRatings(float a, float b, float c, float d, float e) {
        SaveRatingListener activity = (SaveRatingListener) getActivity();
        activity.didFinishRateActivity(a, b, c, d, e);
        getDialog().dismiss();
    }
}
