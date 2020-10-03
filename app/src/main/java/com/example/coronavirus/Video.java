package com.example.coronavirus;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Video extends AppCompatActivity {

    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        BottomNavigationView bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        Intent intent = new Intent(Video.this,MainActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.health:
                        Intent intent1 = new Intent(Video.this,HealthCare.class);
                        startActivity(intent1);
                        break;
                    case R.id.image:
                        Intent intent2 = new Intent(Video.this,Image.class);
                        startActivity(intent2);
                        break;
                    case R.id.chat:
                        Intent intent4 = new Intent(Video.this,Chat.class);
                        startActivity(intent4);
                        break;
                }
                return true;
            }
        });


        MediaController mediaController = new MediaController(this);

        videoView = findViewById(R.id.vid);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

        Uri uri = Uri.parse("https://firebasestorage.googleapis.com/v0/b/corona-virus-8063d.appspot.com/o/coronavirus.mp4?alt=media&token=6cffad0a-a713-4867-a7e5-8c89dbf76c90");
        videoView.setVideoURI(uri);
        videoView.start();

    }
}
