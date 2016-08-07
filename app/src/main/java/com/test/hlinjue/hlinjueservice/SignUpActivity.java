package com.test.hlinjue.hlinjueservice;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;

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
            confirmValue();
        } else {
            //un check
            MyAlert myAlert = new MyAlert();
            myAlert.myDialog(this, 1, "ยังไม่ได้เลือก avatar", "กรุณาเลือก avatar ด้วยค่ะ");
        }
    } // clickSign

    private void confirmValue() {

        MyAlert myAlert = new MyAlert();

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setIcon(myAlert.findAvatar(Integer.parseInt(avatarString)));
        builder.setTitle("โปรดตรวจสอบข้อมูล");
        builder.setMessage("Name = "+ nameString+"\n"+"User="+ userString + "\n" + "Password = " + passwordString);
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                uploadNewValueToServer();
                dialog.dismiss();
            }
        });
        builder.show();

    } // Confirm Value

    private void uploadNewValueToServer() {
        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody requestBody = new FormEncodingBuilder()
                .add("isAdd", "true")
                .add("Name", nameString)
                .add("User", userString)
                .add("Password", passwordString)
                .add("Avatar", avatarString)
                .build();

        Request.Builder builder = new Request.Builder();
        Request request = builder
                .url("http://swiftcodingthai.com/6aug/add_user_master.php")
                .post(requestBody)
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                Log.d("test123", "e==> " + e.toString());
            }

            @Override
            public void onResponse(Response response) throws IOException {
                finish();
            }
        });



    } // uploadNewValue

}  // Main Class
