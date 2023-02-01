package com.example.supermarket;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRateButton();
    }

    private void initRateButton() {
        Button rate = findViewById(R.id.button2);
        rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText marketName = findViewById(R.id.marketNameField);
                EditText marketAddress = findViewById(R.id.marketAddressField);
                Editable name = marketName.getText();
                Editable address = marketAddress.getText();

                if (name.toString().length() > 0 && address.toString().length() > 0) {
                    RatingDatabase ratingDatabase = new RatingDatabase(MainActivity.this);

                    RatingModel ratingModel = new RatingModel();

                    DialogFragment rateDialog = new RateActivity();
                    rateDialog.setCancelable(true);
                    rateDialog.show(getSupportFragmentManager(), "Market Rater Dialog");
                }
            }
        });
    }


}