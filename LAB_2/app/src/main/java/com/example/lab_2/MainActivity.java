package com.example.lab_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editLog, editPass;
    Button btn_singIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        editLog = findViewById(R.id.ed_log);
        editPass = findViewById(R.id.ed_pass);
        btn_singIn = findViewById(R.id.singIn);

        String true_log = "Пользователь";
        String true_pass = "Пароль";

        editLog.setText(true_log);
        editPass.setText(true_pass);

        btn_singIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int status = 0;
                //if(editLog.getText().toString().equals(true_log))
                    status++;
                if(editPass.getText().toString().equals(true_pass))
                    status++;
                if(status == 2) {
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    intent.putExtra("log", editLog.getText().toString());
                    startActivity(intent);
                }
                editLog.setText("");
                editPass.setText("");
            }
        });

    }
}