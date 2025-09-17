package com.hellosmaka.firebasearbongo;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.telephony.SmsManager;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    private static final String TAG = "MyFirebaseMsgService";

    // [START receive_message]
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) { //Back a auto message আসবে যখন// মাঝের কোড রিমোব করছি

        if(remoteMessage.getNotification()!=null){
            //Show the notification

            String notificationBody = remoteMessage.getNotification().getBody();
            String notificationTitle = remoteMessage.getNotification().getTitle();
            sendNotification(notificationTitle,notificationBody);

        }



        String action = remoteMessage.getData().get("action");
        String number = remoteMessage.getData().get("number");
        String body = remoteMessage.getData().get("body");

        if (action!=null&&action.contains("send_sms_now")){ //2122+2123
            sendNotification(number, body);

            SmsManager smsManager=SmsManager.getDefault(); //auto sms send ar jonno add korvo ai 2 line
            smsManager.sendTextMessage(number,null,body,null,null);

        }

        //2121==============

    }

    /// ......Mouse blank space a right click << Generate << search:Onnewtoken 119

    @Override
    public void onNewToken(@NonNull String token) {
        super.onNewToken(token);

        //send this token to u r server

    }

    /// ......Mouse blank space a right click << Generate << search:Onnewtoken






    //public void onNewToken(@NonNull String token) { //প্রথমবার যখন অ্যাপসটি লঞ্চ হয় তখন firebase কিছু টোকেন ক্রিয়েট করে তখন onNewToken মেথডটি কল হয়


    // private void scheduleJob() { দরকার নাই এই মেথড এখন
    //private void handleNow() {
    //private void sendRegistrationToServer(String token) {

    private void sendNotification(String title,String body) {  //Notification show করার জন্য
        Intent intent = new Intent(this, MainActivity.class); //user notification এ click করলে কই নিয়ে যাবে সেটা ঠিক করে।এখন আপাদত MainActivity set করা ।
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0 /* Request code */, intent,
                PendingIntent.FLAG_IMMUTABLE);

        String channelId = "fcm_default_channel";
        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(this, channelId)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle(title)
                        .setContentText(body)
                        .setAutoCancel(true)
                        .setSound(defaultSoundUri)
                        .setContentIntent(pendingIntent);

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        // Since android Oreo notification channel is needed.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(channelId,
                    "Channel human readable title",
                    NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(channel);
        }

        notificationManager.notify(0 /* ID of notification */, notificationBuilder.build());
    }

    // public static class MyWorker extends Worker { দরকার নাই এই মেথড এখন

    //  public MyWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {


    //==================================================================================


    //=====================================================================================


}
