package com.example.mirodone.passwordvalidator;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    EditText password;
    TextView tv1, tv2, tv3, tv4, tv5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        password = findViewById(R.id.password);
        tv1 = findViewById(R.id.tv_1);
        tv2 = findViewById(R.id.tv_2);
        tv3 = findViewById(R.id.tv_3);
        tv4 = findViewById(R.id.tv_4);
        tv5 = findViewById(R.id.tv_5);

        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String pass = password.getText().toString();
                validatePassword(pass);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    public void validatePassword(String password) {
        Pattern upperCase =Pattern.compile("[A-Z]");
        Pattern lowerCase = Pattern.compile("[a-z]");
        Pattern digitCase = Pattern.compile("[0-9]");
        Pattern symbolCase = Pattern.compile("[^a-zA-Z0-9]");



        if(lowerCase.matcher(password).find()){
            tv1.setTextColor(Color.GREEN);
        }else {
            tv1.setTextColor(Color.RED);
        }


        if (!upperCase.matcher(password).find()){
            tv2.setTextColor(Color.RED);
        }else {
            tv2.setTextColor(Color.GREEN);
        }

        if (!digitCase.matcher(password).find()){
            tv3.setTextColor(Color.RED);
        }else {
            tv3.setTextColor(Color.GREEN);
        }

        if (!symbolCase.matcher(password).find()){
            tv4.setTextColor(Color.RED);
        }else {
            tv4.setTextColor(Color.GREEN);
        }

        if (password.length()< 8){
            tv5.setTextColor(Color.RED);
        }else {
            tv5.setTextColor(Color.GREEN);
        }

    }
}
