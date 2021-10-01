package com.example.sunshine;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    EditText checkInDate_input ,  checkOutDate_input, packag_input, number_input, preference_input;
    Button add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        checkInDate_input = findViewById(R.id.checkInDate_input);
       checkOutDate_input = findViewById(R.id.checkOutDate_input);
        packag_input = findViewById(R.id.packag_input);
        number_input = findViewById(R.id.number_input);
        preference_input = findViewById(R.id.preference_input);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(AddActivity.this);
                myDB.bookroom(checkInDate_input.getText().toString().trim(),
                        checkOutDate_input.getText().toString().trim(),
                        packag_input.getText().toString().trim(),
                        number_input.getText().toString().trim(),
                        preference_input.getText().toString().trim());

            }
        });
    }
}