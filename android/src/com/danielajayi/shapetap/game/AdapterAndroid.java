package com.danielajayi.shapetap.game;

import android.app.Activity;

import android.app.Notification;

import android.app.NotificationManager;
import android.os.Build;
import android.support.annotation.RequiresApi;

import com.danielajayi.shapetap.game.NotificationHandler;

public class AdapterAndroid implements NotificationHandler {

    private Activity gameActivity;

    public AdapterAndroid(Activity gameActivity) {
        this.gameActivity = gameActivity;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)

    //@Override

    public void showNotification(String title, String text) {

        Notification.Builder mBuilder = new Notification.Builder(gameActivity)
                .setSmallIcon(R.drawable.ic_launcher)
                .setContentTitle(title + "asdf")
                .setContentText(text + "asdf");


        int notificationId = 1;
        // Gets an instance of the NotificationManager service
        NotificationManager notificationManager = (NotificationManager) gameActivity.getSystemService(gameActivity.NOTIFICATION_SERVICE);
        // Builds the notification and issues it.
        notificationManager.notify(notificationId, mBuilder.build());
    }

}
