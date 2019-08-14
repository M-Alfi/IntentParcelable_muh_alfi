package com.example.intentparcelable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class move_with_object extends AppCompatActivity {

    public static String EXTRA_PERSON = "extra person";
    public TextView tvObject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_with_object);
        tvObject = findViewById(R.id.tv_object_received);
        Person mPerson = getIntent().getParcelableExtra(EXTRA_PERSON);
        String text = "Name : " +mPerson.getName() + ", Email : " +mPerson.getEmail() + ", Age : " +mPerson.getAge()+ ", Location : "+ mPerson.getCity();
        tvObject.setText(text);
    }
}
