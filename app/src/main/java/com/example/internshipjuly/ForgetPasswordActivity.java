package com.example.internshipjuly;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ForgetPasswordActivity extends AppCompatActivity {
    EditText email, password, cnfpassword;
    Button update_password;
    String email_pattern = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        email = findViewById(R.id.change_email);
        password = findViewById(R.id.new_password);
        cnfpassword = findViewById(R.id.new_cnfpassword);
        update_password = findViewById(R.id.update_password);

        update_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(email.getText().toString().trim().equals("")){
                    email.setError("Enter Email");
                }
                else if (!email.getText().toString().matches(email_pattern)){
                    email.setError("Enetr A Valid Email");
                }

                else if (password.getText().toString().trim().equals("")) {
                    password.setError("Enter Password");
                }
                else if (password.getText().toString().trim().length()<6){
                    password.setError("Minimum length 6");
                } else if (cnfpassword.getText().toString().trim().equals("")) {
                    cnfpassword.setError("Enter Confirm Password");
                } else if (!cnfpassword.getText().toString().trim().matches(password.getText().toString().trim())) {
                    cnfpassword.setError("Password Not Matched");
                }
                else {
                    Toast.makeText(ForgetPasswordActivity.this, "Password Changed Successful", Toast.LENGTH_LONG).show();
                    onBackPressed();
//                    Intent intent = new Intent(SignupActivity.this, MainActivity.class);
//                    startActivity(intent);
                }
            }
        });
    }
}