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

        // Radio Controller
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radioButton:
                        avatarString = "0";
                        break;
                    case R.id.radioButton2:
                        avatarString = "1";
                        break;
                    case R.id.radioButton3:
                        avatarString = "2";
                        break;
                    case R.id.radioButton4:
                        avatarString = "3";
                        break;
                    case R.id.radioButton5:
                        avatarString = "4";
                        break;

                }
            }
        });

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


        } else if (avatar0RadioButton.isChecked()||
                avatar1RadioButton.isChecked()||
                avatar2RadioButton.isChecked()||
                avatar3RadioButton.isChecked()||
                avatar4RadioButton.isChecked()) {
            //Have Check
        } else {
            //un check
            MyAlert myAlert = new MyAlert();
            myAlert.myDialog(this, 1, "ยังไม่ได้เลือก avatar", "กรุณาเลือก avatar ด้วยค่ะ");
        }
    } // clickSign

}  // Main Class
