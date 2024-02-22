package com.project.homework_4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button getContactButton = (Button) findViewById(R.id.getContactbuttons);
        getContactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ContactDetails.class);
                startActivityForResult(intent,1);
            }
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        TextView contactTextView = (TextView) findViewById(R.id.contacttextView2);
        if (requestCode == 1){
            if(resultCode == RESULT_OK){
                String strGetContact = data.getStringExtra("lastnameValue")
                        + " " +data.getStringExtra("firstnameValue")
                        + " " + data.getStringExtra("editTextPhone")
                        + " " + data.getStringExtra("editTextTextEmailAddress")
                        + " " + data.getStringExtra("editTextTextPostalAddress")
                        + " " + data.getStringExtra("editTextTextPostalAddress2");
                contactTextView.setText(strGetContact);

            }
        }
    }
}