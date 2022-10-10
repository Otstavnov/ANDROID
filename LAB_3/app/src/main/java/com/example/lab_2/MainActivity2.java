package com.example.lab_2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;


public class MainActivity2 extends AppCompatActivity {

    private final static String TAG = "MainActivity";

    ListView listView;
    ArrayList<String> addString;
    ArrayAdapter<String> adapter;
    ArrayList<String> selectedString;

    //private static final int PICKFILE_RESULT_CODE = 1;

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }
    @Override
    protected void onStop(){
        super.onStop();
        Toast.makeText(MainActivity2.this,"onStop", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onStop");
    }
    @Override
    protected void onStart(){
        super.onStart();
        Toast.makeText(MainActivity2.this,"onStart", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onStart");
    }
    @Override
    protected void onPause(){
        super.onPause();
        Toast.makeText(MainActivity2.this,"onPause", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onPause");
    }
    @Override
    protected void onResume(){
        super.onResume();
        Toast.makeText(MainActivity2.this,"onResume", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Toast.makeText(MainActivity2.this,"onRestart", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onRestart");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();

        Bundle arguments = getIntent().getExtras();
        addString = new ArrayList<>();
        adapter = new ArrayAdapter <>(this, android.R.layout.simple_list_item_multiple_choice, addString);
        selectedString = new ArrayList<>();
        EditText editText = findViewById(R.id.ed_txt);
        Button buttonAdd =  findViewById(R.id.btn_add);
        Button buttonRem =  findViewById(R.id.btn_rem);
        listView = findViewById(R.id.list);

        String loginExtra = arguments.get("log").toString();

        TextView Name =  findViewById(R.id.txt_name);
        Name.setText(loginExtra);

        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText("");
            }
        });



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id)
            {
                // получаем нажатый элемент
                String res = adapter.getItem(position);

                buttonRem.setVisibility(View.VISIBLE);
                if(listView.isItemChecked(position))
                    selectedString.add(res);

                else
                    selectedString.remove(res);
            }
        });

    }

    public void add(View view){
        EditText editText = findViewById(R.id.ed_txt);
        listView = findViewById(R.id.list);
        String res = editText.getText().toString();
        if(res.isEmpty()){

        }
        else{
            editText.setHintTextColor(Color.rgb(146, 49, 5));
            addString.add(res);
            adapter.notifyDataSetChanged();
            listView.setAdapter(adapter);
            editText.setText("");
        }
    }

    public void remove(View view){
        // получаем и удаляем выделенные элементы
        Button buttonRem =  findViewById(R.id.btn_rem);
        for(int i=0; i< selectedString.size();i++){
            adapter.remove(selectedString.get(i));
        }
        // снимаем все ранее установленные отметки
        listView.clearChoices();
        // очищаем массив выбраных объектов
        selectedString.clear();

        adapter.notifyDataSetChanged();
        buttonRem.setVisibility(View.INVISIBLE);
    }
}