package com.test.hlinjue.hlinjueservice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class ServiceActivity extends AppCompatActivity {

    //Explicit
    private  String nameString, avatarString;
    private TextView nameTextView;
    private ImageView avatarImageView;
    private ListView serviceListView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        // bind widget
        nameTextView = (TextView) findViewById(R.id.textView8);
        avatarImageView = (ImageView) findViewById(R.id.imageView7);
        serviceListView = (ListView) findViewById(R.id.listView);


        // Get Value From Intent

        nameString = getIntent().getStringExtra("Name");
        avatarString = getIntent().getStringExtra("Avatar");

        Log.d("7AugV2", "Name ==>" + nameString);
        Log.d("7AugV2", "Avatar ==>" + avatarString);

        // show view
        nameTextView.setText(nameString);
        avatarImageView.setImageResource((new MyAlert().findAvatar(Integer.parseInt(avatarString))));

    }  // Main Method
} // Main Class
