package com.dtech.lklearning;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class Payment_one extends AppCompatActivity {

    ImageView drawer_paymentone, back_paymentone;
    NavigationView navigation_paymentone;
    DrawerLayout drawerLayout_paymentone;
    Button proceed_paymentone, upi_paymentone;
    TextView text, amount_paymentone;
    EditText upi_address_paymentone;
    final int UPI_PAYMENT = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_one);

        drawer_paymentone = findViewById(R.id.drawer_paymentone_id);
        drawerLayout_paymentone = findViewById(R.id.drawerLayout_paymentone_id);
        navigation_paymentone = findViewById(R.id.nav_paymentone_menu);
        back_paymentone = findViewById(R.id.back_paymentone_id);
        upi_paymentone = findViewById(R.id.upi_button_paymentone_id);
        text = findViewById(R.id.textView12);
        upi_address_paymentone = findViewById(R.id.upi_address_paymentone_id);
        proceed_paymentone = findViewById(R.id.proceed_btn_paymentone_id);
        amount_paymentone = findViewById(R.id.amount_paymentone_id);


        drawer_paymentone.setOnClickListener(v -> {
            drawerLayout_paymentone.openDrawer(GravityCompat.START);

        });

        back_paymentone.setOnClickListener(v -> {
            finish();
        });

        upi_paymentone.setOnClickListener(v -> {
            text.setVisibility(View.VISIBLE);
            upi_address_paymentone.setVisibility(View.VISIBLE);


        });

        proceed_paymentone.setOnClickListener(v -> {
            String upi_address1 = upi_address_paymentone.getText().toString();
            String amounttxt = "1";

            String upi_address="paytmqr2810050501011edjp1ep5zb0@paytm";

            String notetxt = "";

            String upitxt = upi_address;

            String nametxt = "Saman Optics";


            if (!upi_address1.isEmpty()) {
                payUsingupi(amounttxt, notetxt, nametxt, upitxt);
            }
        });


    }

    private void payUsingupi(String amounttxt, String notetxt, String nametxt, String upitxt) {

        Uri uri = Uri.parse("upi://pay").buildUpon().appendQueryParameter("pa", upitxt)
                .appendQueryParameter("pn", nametxt)
                .appendQueryParameter("tn", notetxt)
                .appendQueryParameter("am", amounttxt)
                .appendQueryParameter("mc","")
                .appendQueryParameter("tr","123456")
                .appendQueryParameter("cu", "INR").build();

        Intent upi_payment = new Intent(Intent.ACTION_VIEW);
        upi_payment.setData(uri);
        Intent chooser = Intent.createChooser(upi_payment, "Pay with");
        if (null != chooser.resolveActivity(getPackageManager())) {
            startActivityForResult(chooser, UPI_PAYMENT);
        } else {
            Toast.makeText(this, "No UPI app found!", Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case UPI_PAYMENT:
                if (RESULT_OK == resultCode || (resultCode == 11)) {
                    if (data != null) {
                        String txt = data.getStringExtra("response");
                        Log.d("UPI", "onAtcivityResult :" + txt);
                        ArrayList<String> dataList = new ArrayList<>();
                        dataList.add("Nothing");
                        upipaymentoperation(dataList);
                    } else {
                        Log.d("UPI", "onAtcivityResult : Return data is null");
                        ArrayList<String> dataList = new ArrayList<>();
                        dataList.add("Nothing");
                        upipaymentoperation(dataList);
                    }

                } else {
                    Log.d("UPI", "onAtcivityResult : Return data is null");
                    ArrayList<String> dataList = new ArrayList<>();
                    dataList.add("Nothing");
                    upipaymentoperation(dataList);
                }
                break;
        }

    }

    private void upipaymentoperation(ArrayList<String> data) {

        if (isConectionAvailable(Payment_one.this)) {
            String str = data.get(0);
            Log.d("UPIPAY","upipaymentoperation:"+str);
            String paymentCancel="";
            if (str==null)str="discard";
            String status="";
            String approvalref="";
            String response[]=str.split("&");
            for (int i=0;i<response[i].length();i++){
                String equalStr[]=response[i].split("=");
                if(equalStr.length>=2){
                    if (equalStr[0].toLowerCase().equals("Status".toLowerCase())){
                        status=equalStr[1].toLowerCase();

                    }
                    else if (equalStr[0].toLowerCase().equals("approval Ref".toLowerCase())||
                            equalStr[0].toLowerCase().equals("txnRef".toLowerCase())){
                        approvalref=equalStr[1];

                    }
                }
                else{
                    paymentCancel="Payment cancel by user";
                    if (status.equals("success")){
                        Toast.makeText(this, "Transaction success", Toast.LENGTH_SHORT).show();
                        Log.d("UPI","responsestr:"+approvalref);

                    }

                    else if ("Payment cancel by user".equals(paymentCancel)){
                        Toast.makeText(this, "Payment cancel by user", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(this, "Transaction failed", Toast.LENGTH_SHORT).show();
                    }

                }


            }

        }
        else {
            Toast.makeText(this, "no internet connection", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isConectionAvailable(Context context) {
        ConnectivityManager connectivityManager= (ConnectivityManager)context.getSystemService(context.CONNECTIVITY_SERVICE);

        if(connectivityManager!=null){
            NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();
            if (networkInfo!=null && networkInfo.isConnected() && networkInfo.isConnectedOrConnecting() && networkInfo.isAvailable()){
                return true;

            }
        }
        return false;



    }

}