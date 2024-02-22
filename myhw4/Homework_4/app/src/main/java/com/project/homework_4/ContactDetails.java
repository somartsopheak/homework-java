package com.project.homework_4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ContactDetails extends AppCompatActivity {
    EditText fistNameEditText;
    EditText lastNameEditText;
    EditText editTextPhone;
    EditText editTextTextEmailAddress;
    EditText editTextTextPostalAddress;
    EditText editTextTextPostalAddress2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_details);
         fistNameEditText = (EditText) findViewById(R.id.firstNameEditText);
         lastNameEditText = (EditText) findViewById(R.id.lastNameEditText);
         editTextPhone = (EditText) findViewById(R.id.editTextPhone);
         editTextTextEmailAddress = (EditText) findViewById(R.id.editTextTextEmailAddress);
         editTextTextPostalAddress = (EditText) findViewById(R.id.editTextTextPostalAddress);
         editTextTextPostalAddress2 = (EditText) findViewById(R.id.editTextTextPostalAddress2);
        Button contactBackButton = (Button) findViewById(R.id.backbutton);

        contactBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("firstnameValue", fistNameEditText.getText().toString());
                intent.putExtra("lastnameValue", lastNameEditText.getText().toString());
                intent.putExtra("editTextPhone", editTextPhone.getText().toString());
                intent.putExtra("editTextTextEmailAddress", editTextTextEmailAddress.getText().toString());
                intent.putExtra("editTextTextPostalAddress", editTextTextPostalAddress.getText().toString());
                intent.putExtra("editTextTextPostalAddress2", editTextTextPostalAddress2.getText().toString());
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }

    public void onBackPressed(){
        Log.i("Result Detail", "Back Button Pressed");
        fistNameEditText = (EditText) findViewById(R.id.firstNameEditText);
        lastNameEditText = (EditText) findViewById(R.id.lastNameEditText);
        editTextPhone = (EditText) findViewById(R.id.editTextPhone);
        editTextTextEmailAddress = (EditText) findViewById(R.id.editTextTextEmailAddress);
        editTextTextPostalAddress = (EditText) findViewById(R.id.editTextTextPostalAddress);
        editTextTextPostalAddress2 = (EditText) findViewById(R.id.editTextTextPostalAddress2);
        Intent intent = new Intent();
        intent.putExtra("firstnameValue", fistNameEditText.getText().toString());
        intent.putExtra("lastnameValue", lastNameEditText.getText().toString());
        intent.putExtra("editTextPhone", editTextPhone.getText().toString());
        intent.putExtra("editTextTextEmailAddress", editTextTextEmailAddress.getText().toString());
        intent.putExtra("editTextTextPostalAddress", editTextTextPostalAddress.getText().toString());
        intent.putExtra("editTextTextPostalAddress2", editTextTextPostalAddress2.getText().toString());
        setResult(RESULT_OK,intent);

        super.onBackPressed();
    }
}