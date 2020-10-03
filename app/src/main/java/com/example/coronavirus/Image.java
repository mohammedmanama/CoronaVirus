package com.example.coronavirus;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class Image extends AppCompatActivity {

    ListView listImg;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        BottomNavigationView bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        Intent intent = new Intent(Image.this,MainActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.health:
                        Intent intent1 = new Intent(Image.this,HealthCare.class);
                        startActivity(intent1);
                        break;
                    case R.id.video:
                        Intent intent3 = new Intent(Image.this,Video.class);
                        startActivity(intent3);
                        break;
                    case R.id.chat:
                        Intent intent4 = new Intent(Image.this,Chat.class);
                        startActivity(intent4);
                        break;
                }
                return true;
            }
        });

        listImg = findViewById(R.id.listImg);

        List<ImagePreventionMethods> imagePreventionMethods = new ArrayList<>();
        imagePreventionMethods.add(new ImagePreventionMethods("1","https://firebasestorage.googleapis.com/v0/b/corona-virus-8063d.appspot.com/o/image%201.jpg?alt=media&token=7d1c4a89-eac9-4f63-b909-80ee89f9f856"));
        imagePreventionMethods.add(new ImagePreventionMethods("2","https://firebasestorage.googleapis.com/v0/b/corona-virus-8063d.appspot.com/o/image%202.jpg?alt=media&token=566b1902-017e-40fd-993f-4e600a3820f0"));
        imagePreventionMethods.add(new ImagePreventionMethods("3","https://firebasestorage.googleapis.com/v0/b/corona-virus-8063d.appspot.com/o/image%203.png?alt=media&token=bbe2eecd-b0fc-45a6-bd2b-3418f23aeb04"));
        imagePreventionMethods.add(new ImagePreventionMethods("4","https://firebasestorage.googleapis.com/v0/b/corona-virus-8063d.appspot.com/o/image%204.jpg?alt=media&token=43aa51a9-fadb-47b9-a4d8-3d185a571aef"));
        imagePreventionMethods.add(new ImagePreventionMethods("5","https://firebasestorage.googleapis.com/v0/b/corona-virus-8063d.appspot.com/o/image%205.jpg?alt=media&token=b714302b-158e-4258-90da-f9838cd2df8d"));
        imagePreventionMethods.add(new ImagePreventionMethods("6","https://firebasestorage.googleapis.com/v0/b/corona-virus-8063d.appspot.com/o/image%206.jpg?alt=media&token=e41f7b6b-cc12-41e6-b71d-a09de63720f0"));
        imagePreventionMethods.add(new ImagePreventionMethods("7","https://firebasestorage.googleapis.com/v0/b/corona-virus-8063d.appspot.com/o/image%207.jpg?alt=media&token=67c0232a-7a60-4f99-8d79-ce68987640aa"));
        imagePreventionMethods.add(new ImagePreventionMethods("8","https://firebasestorage.googleapis.com/v0/b/corona-virus-8063d.appspot.com/o/image%208.jpg?alt=media&token=54f5f5be-0d63-4b2a-b305-3d6adbdab75d"));
        imagePreventionMethods.add(new ImagePreventionMethods("9","https://firebasestorage.googleapis.com/v0/b/corona-virus-8063d.appspot.com/o/image%209.jpg?alt=media&token=47a0ed02-a574-41c1-bca1-f98b7b299457"));
        imagePreventionMethods.add(new ImagePreventionMethods("10","https://firebasestorage.googleapis.com/v0/b/corona-virus-8063d.appspot.com/o/image%2010.jpg?alt=media&token=afbd41dd-15b6-4c00-b3e1-a67cca228022"));
        imagePreventionMethods.add(new ImagePreventionMethods("11","https://firebasestorage.googleapis.com/v0/b/corona-virus-8063d.appspot.com/o/image%2011.jpeg?alt=media&token=ac6b5b57-573c-4c51-bb76-18ff7a5e8e3e"));
        imagePreventionMethods.add(new ImagePreventionMethods("12","https://firebasestorage.googleapis.com/v0/b/corona-virus-8063d.appspot.com/o/image%2012.jpg?alt=media&token=95ef9f3d-0aa7-4f0a-a059-6c95d3836711"));
        imagePreventionMethods.add(new ImagePreventionMethods("13","https://firebasestorage.googleapis.com/v0/b/corona-virus-8063d.appspot.com/o/image%2013.jpg?alt=media&token=d7098f7d-6695-4994-900f-38e401b9d9bb"));


        MyImageAdapter myImageAdapter = new MyImageAdapter(getApplicationContext(),imagePreventionMethods);
        listImg.setAdapter(myImageAdapter);
        myImageAdapter.notifyDataSetChanged();

    }
}
