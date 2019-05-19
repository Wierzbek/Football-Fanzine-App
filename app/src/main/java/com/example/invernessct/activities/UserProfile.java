package com.example.invernessct.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.braintreepayments.api.dropin.DropInActivity;
import com.braintreepayments.api.dropin.DropInRequest;
import com.braintreepayments.api.dropin.DropInResult;
import com.example.invernessct.R;
import com.example.invernessct.activities.MainActivity;
import com.example.invernessct.storage.SharedPreferenceManager;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;

import okhttp3.internal.http2.Header;

public class UserProfile extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private static final String PATH_TO_SERVER = "http://kamilwierzbicki.com/androidApi/public/getbraintreetoken";
    private String clientToken;
    private static final int BRAINTREE_REQUEST_CODE = 4949;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        TextView textViewFirstName, textViewLastName, textViewEmail, textViewID, textViewReg, textViewType;
        Button buttonBuyPremum;

        textViewFirstName = findViewById(R.id.textViewUserFirstName);
        textViewLastName = findViewById(R.id.textViewUserLastName);
        textViewEmail = findViewById(R.id.textViewUserEmail);
        textViewReg = findViewById(R.id.textViewUserRegistered);
        textViewType = findViewById(R.id.textViewUseType);

        buttonBuyPremum = findViewById(R.id.buttonBuyPremium);

        textViewFirstName.setText(SharedPreferenceManager.getInstance(this).getUser().getFirst_name());
        textViewLastName.setText(SharedPreferenceManager.getInstance(this).getUser().getLast_name());
        textViewEmail.setText(SharedPreferenceManager.getInstance(this).getUser().getEmail());
        textViewReg.setText(SharedPreferenceManager.getInstance(this).getUser().getReg_date());
        textViewType.setText(SharedPreferenceManager.getInstance(this).getUser().getUser_type());


        getClientTokenFromServer();
        buttonBuyPremum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBraintreeSubmit(v);
            }
        });
    }
    public void onBraintreeSubmit(View view){
        DropInRequest dropInRequest = new DropInRequest().clientToken(clientToken);
        startActivityForResult(dropInRequest.getIntent(this), BRAINTREE_REQUEST_CODE);
    }

    private void getClientTokenFromServer(){
        AsyncHttpClient androidClient = new AsyncHttpClient();
        androidClient.get(PATH_TO_SERVER, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, cz.msebera.android.httpclient.Header[] headers, String responseString, Throwable throwable) {
                Log.d(TAG, getString(R.string.token_failed) + responseString);
            }

            @Override
            public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, String responseString) {
                Log.d(TAG, "Client token: " + responseString);
                clientToken = responseString;
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == BRAINTREE_REQUEST_CODE){
            if (RESULT_OK == resultCode){
                DropInResult result = data.getParcelableExtra(DropInResult.EXTRA_DROP_IN_RESULT);
                String paymentNonce = result.getPaymentMethodNonce().getNonce();
                //send to your server
                Log.d(TAG, "Testing the app here");
                sendPaymentNonceToServer(paymentNonce);
            }else if(resultCode == Activity.RESULT_CANCELED){
                Log.d(TAG, "User cancelled payment");
            }else {
                Exception error = (Exception)data.getSerializableExtra(DropInActivity.EXTRA_ERROR);
                Log.d(TAG, " error exception");
            }
        }
    }

    private void sendPaymentNonceToServer(String paymentNonce){
        RequestParams params = new RequestParams("NONCE", paymentNonce);
        AsyncHttpClient androidClient = new AsyncHttpClient();
        androidClient.post(PATH_TO_SERVER, params, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, cz.msebera.android.httpclient.Header[] headers, String responseString, Throwable throwable) {
                Log.d(TAG, "Error: Failed to create a transaction");
            }

            @Override
            public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, String responseString) {
                Log.d(TAG, "Output " + responseString);
            }
        });
    }
}
