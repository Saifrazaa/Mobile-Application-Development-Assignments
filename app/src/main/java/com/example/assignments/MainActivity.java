package com.example.assignments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText username;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.editText3);
        password = findViewById(R.id.editText4);
    }
    public void onClickSubmitButton(View v){
        String name = username.getText().toString();
        String pass = password.getText().toString();
        boolean isError= false;
        if(name != null && name.equalsIgnoreCase("") && usernameValidation(name)==false){
            username.setError("Please enter CORRECT USERNAME ");
            isError = true;
        }
        if(pass != null && pass.equalsIgnoreCase("")&& passwordValidation(pass)==false){
            password.setError("Please enter correct password");
            isError = true;
        }
        if(!isError && usernameValidation(name) && passwordValidation(pass)) {

            Intent intent = new Intent(this, Main3Activity.class);

            startActivity(intent);


        }





    }

    public void onClickSubmitButton1(View v){
        Intent intent = new Intent(this, Main2Activity.class);

        startActivity(intent);


    }

    private boolean usernameValidation(String str){
        boolean isValid = true;

        if(str.contains("@") && str.contains("!") && str.contains("&"))
        {   isValid = false;}
        if(str.length() < 5)
        {isValid = false;}
        return isValid;
    }

    private boolean passwordValidation(String str){
        boolean isValid = true;

        if(str.length() < 5)
            isValid = false;
        return isValid;
    }
}
