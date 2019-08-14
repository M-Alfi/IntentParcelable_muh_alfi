package com.example.intentparcelable;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public Button btnMoveActivity;
    public Button btnMoveWithDataActvity;
    public Button btnMoveWithObject;
    Button btnDialNumber;
    Button btnMoveResult;
    TextView tvResult;

    private int REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnMoveActivity = findViewById(R.id.btn_move_activty);
        btnMoveActivity.setOnClickListener(this);

        btnMoveWithDataActvity = findViewById(R.id.btn_move_with_data_activity);
        btnMoveWithDataActvity.setOnClickListener(this);

        btnMoveWithObject = findViewById(R.id.btn_move_activty_object);
        btnMoveWithObject.setOnClickListener(this);

        btnDialNumber = findViewById(R.id.btn_dial_number);
        btnDialNumber.setOnClickListener(this);

        btnMoveResult = findViewById(R.id.btn_move_for_result);
        btnMoveResult.setOnClickListener(this);

        tvResult = findViewById(R.id.tv_result);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_move_activty:
                Intent moveIntent = new Intent(MainActivity.this, move.class);
                startActivity(moveIntent);
                break;

            case R.id.btn_move_with_data_activity:
                Intent moveWithDataIntent = new Intent(MainActivity.this, move_with_data.class);
                moveWithDataIntent.putExtra(move_with_data.EXTRA_NAME, "Muhamad Alfi");
                moveWithDataIntent.putExtra(move_with_data.EXTRA_AGE, 17);
                startActivity(moveWithDataIntent);
                break;

            case R.id.btn_move_activty_object:
                Person mPerson = new Person();
                mPerson.setName("Muhamad Alfi");
                mPerson.setAge(17);
                mPerson.setEmail("alvirizqi0@gmail.com");
                mPerson.setCity("Bandung");
                Intent moveWithObjectIntent = new Intent(MainActivity.this, move_with_object.class);
                moveWithObjectIntent.putExtra(move_with_object.EXTRA_PERSON, mPerson);
                startActivity(moveWithObjectIntent);
                break;
            case R.id.btn_dial_number:
                String phoneNumber = "088215952753";
                Intent dialPhoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+ phoneNumber));
                startActivity(dialPhoneIntent);
                break;

            case R.id.btn_move_for_result:
                Intent moveForResultIntent = new Intent(MainActivity.this, move_for_result.class);
                startActivityForResult(moveForResultIntent, REQUEST_CODE);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE){
            if (resultCode == move_for_result.RESULT_CODE) {
                int selectedValue = data.getIntExtra(move_for_result.EXTRA_SELECTED_VALUE, 0);
                tvResult.setText(String.format("Hasil : %S", selectedValue));
            }
        }
    }
}
