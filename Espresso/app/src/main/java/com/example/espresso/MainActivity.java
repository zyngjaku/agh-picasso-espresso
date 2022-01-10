package com.example.espresso;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText editTextTextPersonName;
    private Button button;
    private TextView textViewValidation;
    private TextView textViewHello;

    private String blockCharacterSet = " ";
    private InputFilter filter = (charSequence, i, i1, spanned, i2, i3) -> {
        if (charSequence != null && blockCharacterSet.contains(("" + charSequence))) {
            return "";
        }

        return null;
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextTextPersonName = findViewById(R.id.editTextTextPersonName);
        editTextTextPersonName.setFilters(new InputFilter[] { filter });
        button = findViewById(R.id.button);
        textViewValidation = findViewById(R.id.textViewValidation);
        textViewHello = findViewById(R.id.textViewHello);

        button.setOnClickListener(v -> {
            textViewValidation.setVisibility(View.INVISIBLE);

            String name = editTextTextPersonName.getText().toString();
            if (name.isEmpty()) {
                textViewValidation.setVisibility(View.VISIBLE);
                textViewHello.setText("Hello World!");
            } else {
                name = name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase();
                textViewHello.setText("Hello " + name + "!");
                editTextTextPersonName.setText("");
            }
        });
    }
}