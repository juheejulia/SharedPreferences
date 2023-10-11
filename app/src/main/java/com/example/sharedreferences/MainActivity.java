package com.example.sharedreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText inputField;
    TextView displayText;
    Button saveButton;
    Button loadButton;
    DataManager dataManager;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputField = findViewById(R.id.et_input);
        displayText = findViewById(R.id.textView);
        loadButton = findViewById(R.id.btn_load);
        saveButton = findViewById(R.id.btn_save);

        dataManager = new DataManager(this);

        //sp = getSharedPreferences("com.example.sharedreferences", MODE_PRIVATE);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataManager.saveDataToFile(inputField.getText().toString());
                    /* file
                    SharedPreferences.Editor editor = sp.edit();

                    String s = inputField.getText().toString();

                    editor.putString("saved", s);

                    editor.apply();
                    */
            }
        });

        loadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = dataManager.loadFromFile();
                displayText.setText(text);
            }
                /*
                String s = sp.getString("saved", "no key found");

                displayText.setText(s);

                */
        });
    }
}