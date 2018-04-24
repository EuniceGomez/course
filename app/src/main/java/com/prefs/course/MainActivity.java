package com.prefs.course;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
Toolbar toolbar;
RelativeLayout relativeLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.maint);
        relativeLayout=findViewById(R.id.relative);

        loadprefs();

        setSupportActionBar(toolbar);
    }

    private void loadprefs() {
        SharedPreferences preferenceManager=PreferenceManager.getDefaultSharedPreferences(this);

        String color=preferenceManager.getString("color","white");

        switch (color){
            case "Black":
            relativeLayout.setBackgroundColor(Color.BLACK);

            break;
            case "white":
                relativeLayout.setBackgroundColor(Color.WHITE);

                break;

            case "Red":
                relativeLayout.setBackgroundColor(Color.RED);

                break;

            case "Green":
                relativeLayout.setBackgroundColor(Color.GREEN);

                break;
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId()==R.id.settings){
            startActivity(new Intent(this,SettingsActivity.class));
        }else if (item.getItemId()==R.id.profile){
            startActivity(new Intent(this,ProfileActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }
}
