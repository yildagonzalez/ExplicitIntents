package com.vogella.android.explicitintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Activity3 extends AppCompatActivity {

    EditText etSurname;
    Button btnSubmit;
    Button btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        etSurname = findViewById(R.id.etSurname);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnCancel = findViewById(R.id.btnCancel);


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (etSurname.getText().toString().isEmpty()) {
                    Toast.makeText(Activity3.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                }
                else {
                    String surname = etSurname.getText().toString().trim();

                    // We just want to use the intent to pass through the data, not to start a new activity
                    Intent intent = new Intent();
                    intent.putExtra("surname", surname);

                    setResult(RESULT_OK, intent);
                    // .finish destroys the activity and removes it from memory
                    Activity3.this.finish();
                }

            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                setResult(RESULT_CANCELED);
            }
        });



    }
}
