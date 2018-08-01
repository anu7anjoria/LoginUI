package com.example.user.spotifyclone;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;
import android.net.Uri;

public class MainActivity extends AppCompatActivity {
    private Button loginButton;
    private Button signButton;
    public void openloginscreen(){
        Intent intent = new Intent(this,loginscreen.class);
        startActivity(intent);
    }
    public void opensign(){
        Intent intent = new Intent(this,signup.class);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // initiate a video view
        final VideoView simpleVideoView = (VideoView) findViewById(R.id.simpleVideoView);

        simpleVideoView.setVideoURI(Uri.parse("android.resource://" + getPackageName()+"/"+R.raw.verticalvideo));
        simpleVideoView.start();

        simpleVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                simpleVideoView.start();

            }
        });

        loginButton = (Button) findViewById(R.id.login);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openloginscreen();
            }
        });

        signButton = (Button)findViewById(R.id.signup);
        signButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opensign();
            }
        });

        }
}
