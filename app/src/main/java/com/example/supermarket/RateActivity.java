package com.example.supermarket;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;


public class RateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rate_activity);
        //Unwraps bundle from intent
        Bundle extras = getIntent().getExtras();
        //Need key set string
        String supermarketName = extras.getString("marketName");
        String supermarketAddress = extras.getString("marketAddress");

        RatingBar liquor = findViewById(R.id.liquorRating);
        RatingBar produce = findViewById(R.id.produceRating);
        RatingBar meat = findViewById(R.id.meatRating);
        RatingBar cheese = findViewById(R.id.cheeseRating);
        RatingBar checkout = findViewById(R.id.checkoutRating);
        Button submitButton = findViewById(R.id.buttonSubmit);
        TextView averageRating = findViewById(R.id.average);

        produce.setRating(3f);
        cheese.setRating(3f);
        meat.setRating(3f);
        liquor.setRating(3f);
        checkout.setRating(3f);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Rating supermarket = new Rating();
                supermarket.setName(supermarketName);
                supermarket.setAddress(supermarketAddress);

                float produceRating = produce.getRating();
                float cheeseRating = cheese.getRating();
                float meatRating = meat.getRating();
                float liquorRating = liquor.getRating();
                float checkoutRating = checkout.getRating();

                supermarket.setProduce(produceRating);
                supermarket.setCheese(cheeseRating);
                supermarket.setMeat(meatRating);
                supermarket.setLiquor(liquorRating);
                supermarket.setCheckout(checkoutRating);
                System.out.println(supermarket.toString());

                Float average = (liquorRating + produceRating + cheeseRating + meatRating + checkoutRating)/5;

                averageRating.setText("Average Rating: " + average);

                RatingDBHelper db = new RatingDBHelper(RateActivity.this);
                db.addRating(supermarket);
            }
        });
    }


    private void launchMain(View v){
        Intent i = new Intent(RateActivity.this, MainActivity.class);
        i.setFlags(i.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }
}
