package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.sqlite.Database.DBcontrol;
import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;

public class TemanBaru extends AppCompatActivity {

    private TextInputEditText txtNama, txtTelepon;
    private Button simpanBtn;
    String nm, tlp;
    DBcontrol control = new DBcontrol(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teman_baru);

        txtNama = (TextInputEditText) findViewById(R.id.tietNama);
        txtTelepon = (TextInputEditText) findViewById(R.id.tietTelpon);
        simpanBtn = (Button) findViewById(R.id.buttonSave);

        simpanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtNama.getText().toString().isEmpty() || txtTelepon.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Data Belum komplit !", Toast.LENGTH_SHORT).show();

                } else {
                    nm = txtNama.getText().toString();
                    tlp = txtTelepon.getText().toString();

                    HashMap<String, String> qValues = new HashMap<>();
                    qValues.put("nama", nm);
                    qValues.put("telpon", tlp);

                    control.insertData(qValues);
                    callHome();
                }
            }
        });
    }

    public void callHome() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        finish();
    }
}