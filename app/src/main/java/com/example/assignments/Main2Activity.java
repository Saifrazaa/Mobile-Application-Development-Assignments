package com.example.assignments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {

    EditText username;
    EditText password;
    EditText email;
    EditText phone;
    CheckBox cb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        username = findViewById(R.id.editText11);
        password = findViewById(R.id.editText2);
        email = findViewById(R.id.editText1);
        phone = findViewById(R.id.editText);
        cb = findViewById(R.id.checkBox);
    }

    public void onClickSubmitButton(View v){
        String name = username.getText().toString();
        String pass = password.getText().toString();
        String email1=email.getText().toString();
        String phone1 = phone.getText().toString();
        boolean isError= false;
        if(name != null && name.equalsIgnoreCase("")){
            username.setError("Please enter Valid name");
            isError = true;
        }
        if(pass != null && pass.equalsIgnoreCase("")){
            password.setError("Please enter Valid password");
            isError = true;
        }
        if(email1 != null && email1.equalsIgnoreCase("")&& emailValidation(email1)){
            email.setError("Please enter Valid emailaddress");
            isError = true;
        }
        if(phone1 != null && phone1.equalsIgnoreCase("") ){
            phone.setError("Please enter Valid phone number");
            isError = true;
        }
        if(!cb.isChecked()){
            cb.setTextColor(Color.RED);
            isError = true;
        }

        if(!isError){
            Intent intent = new Intent(this, Main3Activity.class);

            startActivity(intent);

        }

    }

    private boolean emailValidation(String str){
        boolean isValid = false;

        if(str.contains("@"))
            isValid = true;

        if(str.contains(".com")|| str.contains(".edu")|| str.contains(".org") )
            isValid = true;
        return isValid;
    }
}
