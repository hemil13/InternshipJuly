package com.example.internshipjuly;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DashboardActivity extends AppCompatActivity {
    TextView name;

    Button logout, delete_profile, profile;
    SharedPreferences sp;

    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        sp = getSharedPreferences(ConstantSp.pref, MODE_PRIVATE);

        db = openOrCreateDatabase("InternshipJuly.db", MODE_PRIVATE, null);
        String userTable = "CREATE TABLE IF NOT EXISTS user(userid INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR(50), email VARCHAR(100), contact VARCHAR(15), password VARCHAR(10))";
        db.execSQL(userTable);

        name = findViewById(R.id.dashboard_name);
        logout = findViewById(R.id.dashboard_logout);
        delete_profile = findViewById(R.id.dashboard_delete);
        profile = findViewById(R.id.dashboard_profile);

        name.setText("Welcome "+sp.getString(ConstantSp.name,""));

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sp.edit().clear().commit();

                Intent intent = new Intent(DashboardActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


        delete_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String deleteProfile = "DELETE FROM user WHERE userid = '"+sp.getString(ConstantSp.userid,"")+"'";
                db.execSQL(deleteProfile);
                sp.edit().clear().commit();

                Toast.makeText(DashboardActivity.this, "Profile Deleted", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(DashboardActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashboardActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });

    }
}