package com.test.hlinjue.hlinjueservice;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by Administrator on 6/8/2559.
 */
public class MyAlert {

    public void myDialog(Context context,
                         int intAvatar,
                         String strTitle,
                         String strMessage) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setCancelable(false);
        builder.setIcon(findAvatar(intAvatar));
        builder.setTitle(strTitle);
        builder.setMessage(strMessage);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }

    public int findAvatar(int intAvatar) {

        int[] resultInts = new int[]{R.drawable.rat48, R.drawable.bird48, R.drawable.doremon48, R.drawable.kon48, R.drawable.nobita48};

        return resultInts[intAvatar];
    }

}  // Main Class
