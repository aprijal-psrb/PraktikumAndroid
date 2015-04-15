package com.hasyim.pertemuanpertama;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import yuku.ambilwarna.AmbilWarnaDialog;

/**
 * Created by APRIJAL_PASARIBU on 15/04/2015.
 */
public class SettingActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.setting);

        final ImageButton bckColor = (ImageButton)findViewById(R.id.bckColor);
        bckColor.setBackgroundColor(MainActivity.color.getInt("bckColor",0));
        bckColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AmbilWarnaDialog(SettingActivity.this, MainActivity.color.getInt("bckColor",0), new AmbilWarnaDialog
                        .OnAmbilWarnaListener() {
                    @Override
                    public void onCancel(AmbilWarnaDialog ambilWarnaDialog) {

                    }

                    @Override
                    public void onOk(AmbilWarnaDialog ambilWarnaDialog, int i) {
                        bckColor.setBackgroundColor(i);
                        MainActivity.mainBackG.setBackgroundColor(i);
                        MainActivity.colorEditor.putInt("bckColor", i);
                        MainActivity.colorEditor.apply();
                    }
                }).show();
            }
        });
    }
}
