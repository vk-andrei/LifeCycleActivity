package com.example.lifecycleactivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class A2 extends AppCompatActivity {

    private final static String MY_LOGS = "LOGS";
    private final static String KEY_PUT_ARGS = "ARGS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        String instanceState;

        if (savedInstanceState == null) {
            instanceState = "Первый запуск!";
        } else {
            instanceState = "Повторный запуск!";
        }

        Log.d(MY_LOGS, "A2: onCreate: " + instanceState);

        String incomingMessage = getIntent().getStringExtra(KEY_PUT_ARGS);
        Log.d(MY_LOGS, "A2: onCreate: incomingMessage: " + incomingMessage);

        ((TextView) findViewById(R.id.tv_data_two)).setText(incomingMessage);

        (findViewById(R.id.btn_activity_two)).setOnClickListener(v -> {

            String messageToA1 = "Andrei!!!";
            Intent intentAnswer = new Intent();
            intentAnswer.putExtra(Intent.EXTRA_TEXT, messageToA1);
            setResult(RESULT_OK, intentAnswer);
            finish();
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(), "onStart()", Toast.LENGTH_SHORT).show();
        Log.d(MY_LOGS, "A2: onStart:");
    }

    @Override
    protected void onRestoreInstanceState(Bundle saveInstanceState) {
        super.onRestoreInstanceState(saveInstanceState);
        Toast.makeText(getApplicationContext(), "Повторный запуск!! - onRestoreInstanceState()", Toast.LENGTH_SHORT).show();
        Log.d(MY_LOGS, "A2: onRestoreInstanceState: Повторный запуск!!");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(), "onResume()", Toast.LENGTH_SHORT).show();
        Log.d(MY_LOGS, "A2: onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(), "onPause()", Toast.LENGTH_SHORT).show();
        Log.d(MY_LOGS, "A2: onPause");
    }

    @Override
    protected void onSaveInstanceState(Bundle saveInstanceState) {
        super.onSaveInstanceState(saveInstanceState);
        Toast.makeText(getApplicationContext(), "onSaveInstanceState()", Toast.LENGTH_SHORT).show();
        Log.d(MY_LOGS, "A2: onSaveInstanceState");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(), "onStop()", Toast.LENGTH_SHORT).show();
        Log.d(MY_LOGS, "A2: onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext(), "onRestart()", Toast.LENGTH_SHORT).show();
        Log.d(MY_LOGS, "A2: onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "onDestroy()", Toast.LENGTH_SHORT).show();
        Log.d(MY_LOGS, "A2: onDestroy");
    }
}