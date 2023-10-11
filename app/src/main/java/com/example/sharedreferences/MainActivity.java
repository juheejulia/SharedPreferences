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

    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputField = findViewById(R.id.et_input);
        displayText = findViewById(R.id.textView);
        loadButton = findViewById(R.id.btn_load);
        saveButton = findViewById(R.id.btn_save);

        sp = getSharedPreferences("com.example.sharedreferences", MODE_PRIVATE);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    SharedPreferences.Editor editor = sp.edit();

                    String s = inputField.getText().toString();

                    editor.putString("saved", s);

                    editor.apply();
            }
        });

        loadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = sp.getString("saved", "no key found");
                displayText.setText(s);
            }
        });
    }
}