package com.example.lab_2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;


public class MainActivity2 extends AppCompatActivity {

    ListView listView;
    ArrayList<String> addString;
    ArrayAdapter<String> adapter;
    ArrayList<String> selectedString;

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

        for(int i=0; i< selectedString.size();i++){
            adapter.remove(selectedString.get(i));
        }
        // снимаем все ранее установленные отметки
        listView.clearChoices();
        // очищаем массив выбраных объектов
        selectedString.clear();

        adapter.notifyDataSetChanged();
    }
}