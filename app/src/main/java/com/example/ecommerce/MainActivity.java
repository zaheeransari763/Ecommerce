package com.example.ecommerce;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity
{

    ImageView bgapp;
    LinearLayout textsplash, texthome, menus;
    Animation frombottom;

    TextView t;
    private LinearLayout mPhone;
    private LinearLayout mCode;

    private EditText mPhoneText;
    private EditText mCodeText;

    private ProgressBar mPhoneBar;
    private ProgressBar mCodeBar;

    private Button mSendButton;

    private FirebaseAuth mAuth;

    PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallBacks;
    private String mVerificationId;
    private PhoneAuthProvider.ForceResendingToken mResendToken;
    private int btnType = 0;

    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frombottom = AnimationUtils.loadAnimation(this, R.anim.frombottom);


        bgapp = (ImageView) findViewById(R.id.bgapp);
        textsplash = (LinearLayout) findViewById(R.id.textsplash);
        texthome = (LinearLayout) findViewById(R.id.texthome);
        menus = (LinearLayout) findViewById(R.id.menus);

        bgapp.animate().translationY(-1900).setDuration(800).setStartDelay(300);
        textsplash.animate().translationY(140).alpha(0).setDuration(800).setStartDelay(300);

        texthome.startAnimation(frombottom);
        menus.startAnimation(frombottom);


        t=(TextView)findViewById(R.id.logo_text2);
        Typeface myCustomFont= Typeface.createFromAsset(getAssets(),"fonts/HulaHoop.ttf");
        t.setTypeface(myCustomFont);

        mAuth = FirebaseAuth.getInstance();

        mPhone = (LinearLayout) findViewById(R.id.linear_phone);
        mCode = (LinearLayout) findViewById(R.id.linear_otp);

        mPhoneText = (EditText) findViewById(R.id.phone_text);
        mCodeText = (EditText) findViewById(R.id.code_text);

        mPhoneBar = (ProgressBar) findViewById(R.id.progress_phone);
        mCodeBar = (ProgressBar) findViewById(R.id.progress_otp);

        mSendButton = (Button) findViewById(R.id.SendButton);



        mSendButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                if(btnType == 0)
                {
                    mPhoneBar.setVisibility(View.VISIBLE);
                    mPhoneText.setEnabled(false);
                    mSendButton.setEnabled(false);
                    String phoneNo = mPhoneText.getText().toString();
                    String phonenumber = "+91" + phoneNo;
                    PhoneAuthProvider.getInstance().verifyPhoneNumber(
                            phonenumber,
                            60,
                            TimeUnit.SECONDS,
                            MainActivity.this,
                            mCallBacks
                    );
                }
                else
                {
                    mSendButton.setEnabled(false);
                    mCodeBar.setVisibility(View.VISIBLE);
                    String verificationCode = mCodeText.getText().toString();
                    PhoneAuthCredential credential = PhoneAuthProvider.getCredential(mVerificationId,verificationCode);
                    signInWithPhoneAuthCredential(credential);
                }
            }
        });
        mCallBacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks()
        {
            @Override
            public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential)
            {
                signInWithPhoneAuthCredential(phoneAuthCredential);
            }

            @Override
            public void onVerificationFailed(FirebaseException e)
            {
                Toast.makeText(MainActivity.this, "Error Occurred: Verification Failed...", Toast.LENGTH_SHORT).show();
                mPhoneBar.setVisibility(View.INVISIBLE);
                mPhoneText.setEnabled(true);
                mSendButton.setEnabled(true);
            }

            @Override
            public void onCodeSent(String verificationId, PhoneAuthProvider.ForceResendingToken token)
            {
                mVerificationId = verificationId;
                mResendToken = token;

                btnType = 1;

                mPhoneBar.setVisibility(View.INVISIBLE);
                mCode.setVisibility(View.VISIBLE);

                mSendButton.setText("Verify Code");
                mSendButton.setEnabled(true);
            }
        };
    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential)
    {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful())
                        {
                            FirebaseUser user = task.getResult().getUser();
                            Intent mainintent = new Intent(MainActivity.this,Dashboard.class);
                            startActivity(mainintent);
                            finish();
                        }
                        else
                        {
                            String message = task.getException().getMessage();
                            Toast.makeText(MainActivity.this, "Error Occurred:" + message, Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
