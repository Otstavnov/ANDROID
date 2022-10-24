package com.example.lab_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editLog, editPass;
    Button btn_singIn;
    Button btn_lang;
    final String STATE = "state";
    final String LOGIN = "login";
    final String PASS = "pass";

    int state = 0;
    int count = 0;
    SharedPreferences preferences_main;
    private static final int PICKFILE_RESULT_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();



        editLog = findViewById(R.id.ed_log);
        editPass = findViewById(R.id.ed_pass);
        btn_singIn = findViewById(R.id.singIn);
        btn_lang = findViewById(R.id.sw_lan);

        preferences_main = getSharedPreferences("authentication", MODE_PRIVATE);

        String true_log = "Пользователь";
        String true_pass = "Пароль";


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

        btn_lang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                count  += 1;
                if(count % 2 == 0){
                    state = 0;

                }else
                    state = 1;
                setLang(state);

                Log.i("state", String.valueOf(state));
                Log.i("count", String.valueOf(count));

            }
        });
    }



    public void save(){
        SharedPreferences.Editor editor = preferences_main.edit();
        editor.putInt(STATE, state);
        editor.apply();
        Log.i("stateSave", String.valueOf(state));
        int loadState = preferences_main.getInt(STATE,3);

        Log.i("loooad", String.valueOf(loadState));

        Toast.makeText(MainActivity.this, "SaveState", Toast.LENGTH_SHORT).show();
    }
    public void load(){

        int loadState = preferences_main.getInt(STATE,3);
        state = loadState;
        Log.i("stateLoad", String.valueOf(state));
    }
    public void setLang(int stateLang){
        if(stateLang == 1){
            editLog.setHint(R.string.nameEn);
            editPass.setHint(R.string.passEn);
            btn_singIn.setText(R.string.signInEn);

        }
        if(stateLang == 0){
            editLog.setHint(R.string.name);
            editPass.setHint(R.string.pass);
            btn_singIn.setText(R.string.signIn);
        }
    }

    @Override
    protected void onPause(){
        super.onPause();
        save();
    }    @Override
    protected void onStart(){
        super.onStart();
        load();
    }


}