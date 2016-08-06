package com.test.hlinjue.hlinjueservice;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class SignUpActivity extends AppCompatActivity {

    //Explicit
    private EditText nameEditText, userEditText,passwordEditText;
    private RadioGroup radioGroup;
    private RadioButton avatar0RadioButton,avatar1RadioButton,
            avatar2RadioButton,avatar3RadioButton, avatar4RadioButton;
    private  String nameString, userString,passwordString, avatarString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        // Bind Widget
        nameEditText = (EditText)findViewById(R.id.editText);
        userEditText = (EditText)findViewById(R.id.editText2);
        passwordEditText = (EditText)findViewById(R.id.editText3);
        radioGroup = (RadioGroup) findViewById(R.id.ragAvatar);
        avatar0RadioButton = (RadioButton)findViewById(R.id.radioButton);
        avatar1RadioButton = (RadioButton) findViewById(R.id.radioButton2);
        avatar2RadioButton = (RadioButton) findViewById(R.id.radioButton3);
        avatar3RadioButton = (RadioButton) findViewById(R.id.radioButton4);
        avatar4RadioButton = (RadioButton) findViewById(R.id.radioButton5);

    } // Main Method

    public void clickSignUpSign(View view) {

        // Get Value from Edit Text
        nameString = nameEditText.getText().toString().trim();
        userString = userEditText.getText().toString().trim();
        passwordString = passwordEditText.getText().toString().trim();

        // check space
        if (nameString.equals("") || userString.equals("") || passwordString.equals("")) {
            MyAlert myAlert = new MyAlert();
            myAlert.myDialog(this, 0, "มีช่องว่าง", "กรุณากรอกทุกช่อง ค่ะ");


        }
    } // clickSign

}  // Main Class
