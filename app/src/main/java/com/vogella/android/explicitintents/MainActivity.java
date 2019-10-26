package com.vogella.android.explicitintents;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    Button btnAct2, btnAct3;
    TextView tvResults;

    final int ACTIVITY3 = 3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        btnAct2 = findViewById(R.id.btnAct2);
        btnAct3 = findViewById(R.id.btnAct3);
        tvResults = findViewById(R.id.tvResults);

        btnAct2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (etName.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                }
                else {
                    String name = etName.getText().toString().trim();

                    // Open up Activity 2 (new activity) & send name to it
                    // context: where are we currently (we're in main activity)
                    // Intent(where we are, where we want to go)
                    Intent intent = new Intent(MainActivity.this, com.vogella.android.explicitintents.Activity2.class);

                    // sending data to intent through putExtra(name of data passing through, actual data being passed)
                    intent.putExtra("name", name);
                    // starting intent
                    startActivity(intent);
                }

            }
        });

        btnAct3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, com.vogella.android.explicitintents.Activity3.class);
                // You can start an activity and receive a result back. For example, you can start the camera app and
                // receive the captured photo as a result. It sends back the result as another Intent object
                startActivityForResult(intent, ACTIVITY3);
            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

         if (requestCode == ACTIVITY3) {

             if (resultCode == RESULT_OK) {
                 tvResults.setText(data.getStringExtra("surname"));
             }
             // ex. user goes to activity 3 but presses the back button, thus cancelling
             if (resultCode == RESULT_CANCELED) {
                 tvResults.setText("No data reveived!");
              }

         }
    }

}
