package com.dtech.lklearning;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.TimeUnit;

public class OtpVerification extends AppCompatActivity {

    String mob,verificationCodesent;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.otp_verification);

        mob = getIntent().getStringExtra("mob_no");
        mAuth=FirebaseAuth.getInstance();

        //remember the user after first sign in
        SharedPreferences preferences=getSharedPreferences("checkbox", MODE_PRIVATE);
        String checkbox = preferences.getString("remember","");




        sendVerificationCodeTOUser(mob);

    }

    private void sendVerificationCodeTOUser(String mob){

        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                "+91" + mob,
                60,
                TimeUnit.SECONDS,
                this,
                mCallbacks
        );

    }

    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

        @Override
        public void onCodeSent(@NonNull @NotNull String s, @NonNull @NotNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);

            verificationCodesent=s;
        }

        @Override
        public void onVerificationCompleted(@NonNull @NotNull PhoneAuthCredential phoneAuthCredential) {
            String code = phoneAuthCredential.getSmsCode();

            if (code!=null) {
                verifycode(code);
            }
        }

        @Override
        public void onVerificationFailed(@NonNull @NotNull FirebaseException e) {

            Toast.makeText(OtpVerification.this, e.getMessage(), Toast.LENGTH_SHORT).show();

        }
    };

    private void verifycode(String codeByUser) {

        PhoneAuthCredential credential=PhoneAuthProvider.getCredential(verificationCodesent,codeByUser);

        Toast.makeText(this, credential.toString(), Toast.LENGTH_SHORT).show();

        signInTheUserByCredentials(credential);





    }

    private void signInTheUserByCredentials(PhoneAuthCredential credential) {
        FirebaseAuth firebaseAuth=FirebaseAuth.getInstance();

        firebaseAuth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(OtpVerification.this, "Verified", Toast.LENGTH_SHORT).show();

                    SharedPreferences preferences = getSharedPreferences("checkbox",MODE_PRIVATE);
                    SharedPreferences.Editor editor=preferences.edit();
                    editor.putString("remember","true");
                    editor.apply();

                    startActivity(new Intent(OtpVerification.this,Home.class));
                    finish();
                }
                else{
                    Toast.makeText(OtpVerification.this, "Try again!", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }


}
