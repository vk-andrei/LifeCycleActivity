package com.example.lifecycleactivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class A1 extends AppCompatActivity {

    private final static String MY_LOGS = "LOGS";
    private final static String KEY_PUT_ARGS = "ARGS";
    private static final int SECOND_ACTIVITY_REQUEST_CODE = 0;

    private TextView tvActivityOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String instanceState;

        if (savedInstanceState == null) {
            instanceState = "Первый запуск!";
        } else {
            instanceState = "Повторный запуск!";
        }

        Log.d(MY_LOGS, "A1: onCreate: " + instanceState);

        (findViewById(R.id.btn_activity_one)).setOnClickListener(v -> {
            Intent intent = new Intent(this, A2.class);
            intent.putExtra(KEY_PUT_ARGS, "Привет, А2, I'm from A1");
            this.startActivityForResult(intent, SECOND_ACTIVITY_REQUEST_CODE);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SECOND_ACTIVITY_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                String messageFromA2 = data.getStringExtra(Intent.EXTRA_TEXT);
                Log.d(MY_LOGS, "A1: onActivityResult: messageFromA2: " + messageFromA2);
                tvActivityOne = findViewById(R.id.tv_data_one);
                tvActivityOne.setText(messageFromA2);
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(), "onStart()", Toast.LENGTH_SHORT).show();
        Log.d(MY_LOGS, "A1: onStart:");
    }

    @Override
    protected void onRestoreInstanceState(Bundle saveInstanceState) {
        super.onRestoreInstanceState(saveInstanceState);
        Toast.makeText(getApplicationContext(), "Повторный запуск!! - onRestoreInstanceState()", Toast.LENGTH_SHORT).show();
        Log.d(MY_LOGS, "A1: onRestoreInstanceState: Повторный запуск!!");


    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(), "onResume()", Toast.LENGTH_SHORT).show();
        Log.d(MY_LOGS, "A1: onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(), "onPause()", Toast.LENGTH_SHORT).show();
        Log.d(MY_LOGS, "A1: onPause");
    }

    @Override
    protected void onSaveInstanceState(Bundle saveInstanceState) {
        super.onSaveInstanceState(saveInstanceState);
        Toast.makeText(getApplicationContext(), "onSaveInstanceState()", Toast.LENGTH_SHORT).show();
        Log.d(MY_LOGS, "A1: onSaveInstanceState");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(), "onStop()", Toast.LENGTH_SHORT).show();
        Log.d(MY_LOGS, "A1: onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext(), "onRestart()", Toast.LENGTH_SHORT).show();
        Log.d(MY_LOGS, "A1: onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "onDestroy()", Toast.LENGTH_SHORT).show();
        Log.d(MY_LOGS, "A1: onDestroy");
    }
}