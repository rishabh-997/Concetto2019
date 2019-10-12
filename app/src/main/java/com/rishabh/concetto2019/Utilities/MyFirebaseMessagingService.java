package com.rishabh.concetto2019.Utilities;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.os.Build;
import android.os.SystemClock;
import android.util.Log;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.rishabh.concetto2019.HomePage.MVP.HomePageActivity;
import com.rishabh.concetto2019.R;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    private NotificationManagerCompat notifMangComp;
    public static final String CHANNEL_PAYMENT_ID = "channelPayment";
    public static final String CHANNEL_PAYMENT_DESC = "This channel receives new payment notifications";
    public static final String CHANNEL_PAYMENT_GROUPKEY = "GroupPayment";
    public static final int CHANNEL_PAYMENT_NOTIFY_ID = 1;

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        if (remoteMessage.getNotification() != null) {
            if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.O){
                NotificationChannel channelPayment = new NotificationChannel(CHANNEL_PAYMENT_ID,"Payments Channel", NotificationManager.IMPORTANCE_DEFAULT);
                channelPayment.setDescription(CHANNEL_PAYMENT_DESC);

                NotificationManager manager = getSystemService(NotificationManager.class);
                manager.createNotificationChannel(channelPayment);
            }
            notifMangComp = NotificationManagerCompat.from(this);
            Intent notificationIntent = new Intent(this, HomePageActivity.class);
            notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_SINGLE_TOP);
            PendingIntent intent = PendingIntent.getActivity(this,0,notificationIntent,0);

            Notification notification = new NotificationCompat.Builder(this, CHANNEL_PAYMENT_ID)
                    .setSmallIcon(R.mipmap.c)
                    .setContentTitle(remoteMessage.getNotification().getTitle())
                    .setContentText(remoteMessage.getNotification().getBody())
                    .setPriority(NotificationCompat.PRIORITY_HIGH)
                    .setContentIntent(intent)
                    .build();
            //notification.flags |= Notification.FLAG_AUTO_CANCEL;
            notifMangComp.notify((int) SystemClock.uptimeMillis(),notification);
            Log.d("Notification service", "showNotification: ");
        }
    }
}
