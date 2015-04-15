package com.hasyim.pertemuanpertama;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;


public class MainActivity extends ActionBarActivity {
    public static SharedPreferences color;
    public static SharedPreferences.Editor colorEditor;
    public static LinearLayout mainBackG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        color = getApplicationContext().getSharedPreferences("color", MODE_PRIVATE);
        colorEditor = color.edit();

        mainBackG = (LinearLayout)findViewById(R.id.mainBackground);
        mainBackG.setBackgroundColor(color.getInt("bckColor",0));

        final Button btnPersamaan = (Button) findViewById(R.id.btnPersamaan);
        final Button btnInput = (Button) findViewById(R.id.btnInPutApp);
        final Button btnBmi = (Button)findViewById(R.id.btnBmi);

        btnPersamaan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(btnPersamaan.getContext(), PersamaanActivity.class);
                startActivity(i);
            }
        });

        btnInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(btnInput.getContext(), InputActivity.class);
                startActivity(i);
            }
        });

        btnBmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(btnBmi.getContext(), BmiActivity.class);
                startActivity(i);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent setting = new Intent(getApplicationContext(),SettingActivity.class);
            startActivity(setting);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
