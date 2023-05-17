package com.example.producto1;

import static android.os.Build.*;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
@RequiresApi(api = VERSION_CODES.O)

public class MediaPlayerService  extends Service{
    MediaPlayer mediaPlayer;
    AudioManager audioManager;

    int option;

    String CHANNEL_ID = "1";

    Uri patchSound;

    String patchSoundString;

    public IBinder onBind(Intent intent){
        return null;
    }

    public int onStartCommand(Intent intent, int flags, int startId){
        option = intent.getIntExtra ("option", option);
        Log.d("tag", String.valueOf ( option ) );
        if (option == 1) {
            mediaPlayer = MediaPlayer.create ( this, R.raw.game1 );
            mediaPlayer.setLooping ( true );

        }else if (option == 3) {
            mediaPlayer.stop();
        }else if (option == 4) {
            mediaPlayer.pause();
        }else if (option == 7) {
            onDestroy();
        }
        else if (option == 5) {
            mediaPlayer.start();
        }else if (option == 6) {

            patchSoundString = intent.getStringExtra ("cancion");
            Log.d("patch string", String.valueOf ( patchSoundString ) );
            patchSound = Uri.parse(patchSoundString);
            mediaPlayer = MediaPlayer.create ( this, patchSound);
            mediaPlayer.setLooping ( true );

        }else {
            if (mediaPlayer.isPlaying ())
                mediaPlayer.pause();
            else
                mediaPlayer.start();
        }
        return START_STICKY;
    }
    public void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
    }
}
