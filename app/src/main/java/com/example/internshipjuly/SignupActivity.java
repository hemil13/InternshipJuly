package com.example.internshipjuly;

import android.content.Intent;
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

public class SignupActivity extends AppCompatActivity {

    EditText name, email, contact, password, cnfpassowrd;
    TextView alredy_account;
    Button signup;

    String email_pattern = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$";

    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_signup);

        db = openOrCreateDatabase("InternshipJuly.db", MODE_PRIVATE, null);
        String userTable = "CREATE TABLE IF NOT EXISTS user(userid INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR(50), email VARCHAR(100), contact VARCHAR(15), password VARCHAR(10))";
        db.execSQL(userTable);

        name = findViewById(R.id.signup_name);
        email = findViewById(R.id.signup_email);
        contact = findViewById(R.id.signup_contact);
        password = findViewById(R.id.signup_password);
        cnfpassowrd = findViewById(R.id.signup_cnfpassword);
        alredy_account = findViewById(R.id.signup_already_account);
        signup = findViewById(R.id.signup_button);
        
        
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(name.getText().toString().trim().equals("")){
                    name.setError("Enter Name");
                } 
                else if (email.getText().toString().trim().equals("")) {
                    email.setError("Enter Email");
                } 
                else if (!email.getText().toString().matches(email_pattern)) {
                    email.setError("Enter A Valid Email");
                } 
                else if (contact.getText().toString().trim().equals("")) {
                    contact.setError("Enter Contact Number");
                }
                else if (contact.getText().toString().trim().length()<10){
                    contact.setError("Enter A Valid Contact Number");
                } else if (password.getText().toString().trim().equals("")) {
                    password.setError("Enter Password");
                }
                else if (password.getText().toString().trim().length()<6){
                    password.setError("Minimum length 6");
                } else if (cnfpassowrd.getText().toString().trim().equals("")) {
                    cnfpassowrd.setError("Enter Confirm Password");
                } else if (!cnfpassowrd.getText().toString().trim().matches(password.getText().toString().trim())) {
                    cnfpassowrd.setError("Password Not Matched");
                }
                else {

                    String insertUser = "INSERT INTO user VALUES (NULL, '"+name.getText().toString()+"', '"+email.getText().toString()+"', '"+contact.getText().toString()+"', '"+password.getText().toString()+"')";
                    db.execSQL(insertUser);


                    Toast.makeText(SignupActivity.this, "Signup Successful", Toast.LENGTH_LONG).show();
                    onBackPressed();
//                    Intent intent = new Intent(SignupActivity.this, MainActivity.class);
//                    startActivity(intent);
                }
            }
        });

    }
}