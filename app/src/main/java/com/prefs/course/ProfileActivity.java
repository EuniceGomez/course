package com.prefs.course;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SimpleCursorTreeAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {
TextView name,email;
Button delete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        final SharedPreferences.Editor editor = sharedPreferences.edit();


        String namee= sharedPreferences.getString("username","");
        String emil= sharedPreferences.getString("email","");

        name=findViewById(R.id.name);
        delete=findViewById(R.id.delete);
        email=findViewById(R.id.email);
        name.setText(namee);
        email.setText(emil);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.clear();
                editor.apply();

                Toast.makeText(ProfileActivity.this, "Account deleted", Toast.LENGTH_SHORT).show();
              Intent i=new Intent(ProfileActivity.this,LoginActivity.class);
              i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
            }
        });





    }
}
