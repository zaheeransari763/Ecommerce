package com.example.ecommerce;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Contact extends AppCompatActivity {

    private  ImageView mail,call;
    private ImageView facebook;
    private ImageView instagram;
    private ImageView twitter;
    private ImageView website;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        mail = (ImageView) findViewById(R.id.mail);
        call = (ImageView) findViewById(R.id.call);
        facebook = (ImageView) findViewById(R.id.facebook);
        instagram = (ImageView) findViewById(R.id.Instagram);
        twitter = (ImageView) findViewById(R.id.twitter);
        website = (ImageView) findViewById(R.id.website);

        mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendmail();
            }
        });
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contactEcom();
            }
        });



        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bnnLink = new Intent(Intent.ACTION_VIEW);
                bnnLink.setData(Uri.parse("https://www.facebook.com/zaheer.ansari.399"));
                startActivity(bnnLink);
            }
        });

        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bnnLink = new Intent(Intent.ACTION_VIEW);
                bnnLink.setData(Uri.parse("https://www.instagram.com/_flirty.insane"));
                startActivity(bnnLink);
            }
        });

        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bnnLink = new Intent(Intent.ACTION_VIEW);
                bnnLink.setData(Uri.parse("https://twitter.com/AnsariZaheerAh2"));
                startActivity(bnnLink);
            }
        });

        website.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bnnLink = new Intent(Intent.ACTION_VIEW);
                bnnLink.setData(Uri.parse("https://facebook.com"));
                startActivity(bnnLink);
            }
        });


    }


    private void contactEcom() {
        String number = "9999999999";
        Uri call = Uri.parse("tel:" + number);
        Intent contactIntent = new Intent(Intent.ACTION_DIAL,call);
        startActivity(Intent.createChooser(contactIntent,"Choose Calling Client"));
    }

    private void sendmail() {
        Uri uri = Uri.parse("mailto:ecommerce@gmail.com");
        Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
        startActivity(Intent.createChooser(intent,"Choose Mailing Client"));
    }
}