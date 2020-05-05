package com.example.th92;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText location;
    EditText day;
    EditText open;
    EditText close;
    Spinner spinner;
    TextView textView;
    Button button;
    readXML xml = readXML.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        location = (EditText) findViewById(R.id.editTextL);
        day = (EditText) findViewById(R.id.editTextD);
        open = (EditText) findViewById(R.id.editTextT1);
        close = (EditText) findViewById(R.id.editTextT2);
        spinner = (Spinner) findViewById(R.id.spinner);
        button = findViewById(R.id.button);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);


     /*   //////////////  Spinneri (tulee myöhemmin) -> ////////////////////////////////////////////////////////////////////////////////////////////////

        //Luodaan ArrayAdapter sijainnille//
        ArrayAdapter<String> adapterLocation = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, criteria_list_location);
        //Määritellään spinnerin asettelutyyli//
        adapterLocation.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //lisätään adapteri spinneriin//
        spinner.setAdapter(adapterLocation);

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
            if (){
                System.out.println("Toimii");
            } else {
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
        }
    }); */
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////// button ////////////////////////////////////////////////////////////////////////////////////////

    public void readXML(View v) {
        xml.getPosts();
    }
}

