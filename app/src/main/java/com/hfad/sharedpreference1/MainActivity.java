package com.hfad.sharedpreference1;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText name;
    EditText email;
    Button save;
    Button retrieve;
    Button clear;
    public static final String mypreference = "mypref";
    public static final String Name = "nameKey";
    public static final String Email = "emailKey";

    SharedPreferences sharedPreferences = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.etName);
        email = findViewById(R.id.etEmail);
        save = findViewById(R.id.btnSave);
        retrieve = findViewById(R.id.btnRetr);
        clear = findViewById(R.id.btnClear);

        sharedPreferences = getSharedPreferences(mypreference,MODE_PRIVATE);


    }

    public void Save (View view)
    {
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(Name,name.getText().toString());
        editor.putString(Email,email.getText().toString());
        editor.commit();
    }

    public void Get (View view)
    {

        if (sharedPreferences.contains(Name)) {
            name.setText(sharedPreferences.getString(Name, ""));
        }
        if (sharedPreferences.contains(Email)) {
            email.setText(sharedPreferences.getString(Email, ""));

        }
    }

    public void clear (View view)
    {
        name.setText("");
        email.setText("");

    }
}
