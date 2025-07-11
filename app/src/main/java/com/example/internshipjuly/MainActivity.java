package com.example.internshipjuly;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    EditText email, password;
    Button signin;

    TextView create_account, forget_password;

    SQLiteDatabase db;
    SharedPreferences sp;

    String email_pattern = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp = getSharedPreferences(ConstantSp.pref, MODE_PRIVATE);

        db = openOrCreateDatabase("InternshipJuly.db", MODE_PRIVATE, null);
        String userTable = "CREATE TABLE IF NOT EXISTS user(userid INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR(50), email VARCHAR(100), contact VARCHAR(15), password VARCHAR(10))";
        db.execSQL(userTable);

        email = findViewById(R.id.main_email);
        password = findViewById(R.id.main_password);
        signin = findViewById(R.id.main_signin);
        create_account = findViewById(R.id.main_create_account);
        forget_password = findViewById(R.id.forget_password);



        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(email.getText().toString().trim().equals("")){
                    email.setError("Enter Email");
                } else if(password.getText().toString().trim().equals("")){
                    password.setError("Enter Password");
                } else if (password.getText().toString().length()<6) {
                    password.setError("Minimum 6 Characters");
                } else{

                    String checkUser = "SELECT * FROM user WHERE (email = '"+email.getText().toString()+"' OR contact = '"+email.getText().toString()+"') AND password = '"+password.getText().toString()+"'";
                    Cursor cursor = db.rawQuery(checkUser, null);

                    if(cursor.getCount()>0){
                        while(cursor.moveToNext()){
                            sp.edit().putString(ConstantSp.userid, cursor.getString(0)).commit();
                            sp.edit().putString(ConstantSp.name, cursor.getString(1)).commit();
                            sp.edit().putString(ConstantSp.email, cursor.getString(2)).commit();
                            sp.edit().putString(ConstantSp.contact, cursor.getString(3)).commit();
                            sp.edit().putString(ConstantSp.password, cursor.getString(4)).commit();
                        }
                        Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(MainActivity.this, DashboardActivity.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Invalid Credentials", Toast.LENGTH_LONG).show();
//                        Intent intent = new Intent(MainActivity.this, SignupActivity.class);
//                        startActivity(intent);
                    }




//                    Snackbar.make(view, "Login Successful", Snackbar.LENGTH_LONG).show();
                }
            }
        });



        create_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });

        forget_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ForgetPasswordActivity.class);
                startActivity(intent);
            }
        });

    }
}