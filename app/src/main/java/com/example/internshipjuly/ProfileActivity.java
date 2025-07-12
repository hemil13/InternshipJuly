package com.example.internshipjuly;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    Button edit, update;
    EditText name, email, contact, password, cnfpassword;

    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        sp = getSharedPreferences(ConstantSp.pref, MODE_PRIVATE);

        edit = findViewById(R.id.profile_edit);
        update = findViewById(R.id.profile_update);
        name = findViewById(R.id.profile_name);
        email = findViewById(R.id.profile_email);
        contact = findViewById(R.id.profile_contact);
        password = findViewById(R.id.profile_password);
        cnfpassword = findViewById(R.id.profile_cnfpassword);


        setData(false);


        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cnfpassword.setVisibility(View.VISIBLE);
                edit.setVisibility(View.GONE);
                update.setVisibility(View.VISIBLE);

                setData(true);
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cnfpassword.setVisibility(View.GONE);
                edit.setVisibility(View.VISIBLE);
                update.setVisibility(View.GONE);

                setData(false);
            }
        });


    }

    private void setData(boolean b) {
        name.setText(sp.getString(ConstantSp.name, ""));
        email.setText(sp.getString(ConstantSp.email, ""));
        contact.setText(sp.getString(ConstantSp.contact, ""));
        password.setText(sp.getString(ConstantSp.password, ""));


        name.setEnabled(b);
        email.setEnabled(b);
        contact.setEnabled(b);
        password.setEnabled(b);


    }
}