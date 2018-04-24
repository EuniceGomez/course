package com.prefs.course;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
TextView textView;
Button register;

EditText emailtext,passwordtext,usernametext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campus);
register=findViewById(R.id.loginButton);

emailtext=findViewById(R.id.email);
passwordtext=findViewById(R.id.password);

usernametext=findViewById(R.id.name);



register.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        String name=usernametext.getText().toString();
        String email=emailtext.getText().toString();
        String password=passwordtext.getText().toString();

        if (TextUtils.isEmpty(name)||TextUtils.isEmpty(email)||TextUtils.isEmpty(password)){


            Toast.makeText(RegisterActivity.this, " Add all the data", Toast.LENGTH_SHORT).show();
            return;
        }else {

            if (!EmailValidator.isValidEmailAddress(email)){
                Toast.makeText(RegisterActivity.this, "Invalid email address", Toast.LENGTH_SHORT).show();
                return;
            }
            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
            SharedPreferences.Editor editor = sharedPreferences.edit();

            editor.putString("username", name);

            editor.putString("password", password);
            editor.putString("email", email);


            editor.apply();
            Toast.makeText(RegisterActivity.this, "Data account created", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(getBaseContext(), LoginActivity.class);
            startActivity(intent);

        }

    }
});
        textView=findViewById(R.id.btn);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(),LoginActivity.class));
            }
        });
    }
}
