package com.example.ecommerce;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class Categories extends AppCompatActivity  implements View.OnClickListener{

    private CardView clothes, footwear, belts, watches, artwork, sunglasses, others;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        clothes = (CardView) findViewById(R.id.clothes);
        footwear = (CardView) findViewById(R.id.footwears);
        belts = (CardView) findViewById(R.id.belts);
        watches = (CardView) findViewById(R.id.watches);
        artwork = (CardView) findViewById(R.id.artwork);
        sunglasses = (CardView) findViewById(R.id.sunglasses);
        others = (CardView) findViewById(R.id.others);

        clothes.setOnClickListener(this);
        footwear.setOnClickListener(this);
        belts.setOnClickListener(this);
        watches.setOnClickListener(this);
        artwork.setOnClickListener(this);
        sunglasses.setOnClickListener(this);
        others.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()) {

            case R.id.clothes:
                i = new Intent(this, Clothes.class);
                startActivity(i);
                break;
            case R.id.footwears:
                i = new Intent(this, Footwears.class);
                startActivity(i);
                break;
            case R.id.belts:
                i = new Intent(this, Belts.class);
                startActivity(i);
                break;
            case R.id.watches:
                i = new Intent(this, Watches.class);
                startActivity(i);
                break;
            case R.id.artwork:
                i = new Intent(this, Artwork.class);
                startActivity(i);
                break;
            case R.id.sunglasses:
                i = new Intent(this, Sunglasses.class);
                startActivity(i);
                break;
            case R.id.others:
                i = new Intent(this, Others.class);
                startActivity(i);
                break;
            default:
                break;
        }

    }
}
