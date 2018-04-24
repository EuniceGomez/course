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

public class LoginActivity extends AppCompatActivity {
TextView textView;
Button reg;

    Button register;

    EditText passwordtext,usernametext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout.activity_login);

        register=findViewById(R.id.loginButton);
        passwordtext=findViewById(R.id.password);

        usernametext=findViewById(R.id.name);
        register.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        login(passwordtext,usernametext);
    }
});
        textView=findViewById(R.id.btn);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(),RegisterActivity.class));
            }
        });
    }

    private void login(EditText passwordtext, EditText usernametext) {

        String name= this.usernametext.getText().toString();
        String password= this.passwordtext.getText().toString();

        if (TextUtils.isEmpty(name)||TextUtils.isEmpty(password)){


            Toast.makeText(getBaseContext(), " Add all the data", Toast.LENGTH_SHORT).show();
            return;
        }else {

            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
            SharedPreferences.Editor editor = sharedPreferences.edit();


           String namee= sharedPreferences.getString("username","");
            String pwd= sharedPreferences.getString("password","");


if (!namee.equals(name)){
    Toast.makeText(this, "Name doesnt exist", Toast.LENGTH_SHORT).show();
    return;
}

            if (!pwd.equals(password)){
                Toast.makeText(this, "Password doesnt exist", Toast.LENGTH_SHORT).show();
                return;
            }

            if (name.equals(namee)&&password.equals(pwd)){
                Intent intent=new Intent(getBaseContext(),MainActivity.class);
                Toast.makeText(this, "Correct credentials Login successfull", Toast.LENGTH_SHORT).show();
            startActivity(intent);
            }

            editor.apply();
            Toast.makeText(LoginActivity.this, "Data account created", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(getBaseContext(), MainActivity.class);
            startActivity(intent);

        }


    }
}
