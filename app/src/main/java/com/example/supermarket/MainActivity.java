package com.example.supermarket;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Rating currentRating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRateButton();

        currentRating = new Rating();
    }

    private void initRateButton() {
        Button rate = findViewById(R.id.button2);
        rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                hideKeyboard();

                EditText marketName = findViewById(R.id.marketNameField);
                EditText marketAddress = findViewById(R.id.marketAddressField);
                Editable name = marketName.getText();
                Editable address = marketAddress.getText();

                if (name.toString().length() > 0 && address.toString().length() > 0) {
                    Intent intent = new Intent(MainActivity.this, RateActivity.class);
                    intent.setFlags(intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent.putExtra("name", name.toString());
                    intent.putExtra("address", address.toString());
                    startActivity(intent);
                }
            }
        });
    }

    private void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        EditText editName = findViewById(R.id.marketNameField);
        imm.hideSoftInputFromWindow(editName.getWindowToken(), 0);
        EditText editAddress = findViewById(R.id.marketAddressField);
        imm.hideSoftInputFromWindow(editAddress.getWindowToken(), 0);
    }
}