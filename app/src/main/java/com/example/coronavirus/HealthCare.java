package com.example.coronavirus;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class HealthCare extends AppCompatActivity {

    TextView textView;
    FirebaseFirestore firestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_care);

        BottomNavigationView bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        Intent intent = new Intent(HealthCare.this,MainActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.image:
                        Intent intent2 = new Intent(HealthCare.this,Image.class);
                        startActivity(intent2);
                        break;
                    case R.id.video:
                        Intent intent3 = new Intent(HealthCare.this,Video.class);
                        startActivity(intent3);
                        break;
                    case R.id.chat:
                        Intent intent4 = new Intent(HealthCare.this,Chat.class);
                        startActivity(intent4);
                        break;
                }
                return true;
            }
        });

        textView = findViewById(R.id.healthTv);
        firestore = FirebaseFirestore.getInstance();

        CollectionReference reference1 = firestore.collection("information");
        Task<QuerySnapshot> q1 = reference1.get();
        q1.addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                for (QueryDocumentSnapshot queryDocumentSnapshot : queryDocumentSnapshots) {
                    HealthItem t = queryDocumentSnapshot.toObject(HealthItem.class);
                    textView.setText(t.getHealthcare());
                }
            }
        });
    }
}
