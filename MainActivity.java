package com.example.testshared;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView textViewResult;
    private static final String SHARED_PREFS_NAME = "MySharedPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResult = findViewById(R.id.textViewResult);
        Button buttonOpenSecondActivity = findViewById(R.id.buttonOpenSecondActivity);

        // Ustawienie przycisku do otwarcia drugiej aktywności
        buttonOpenSecondActivity.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, SecondActivity.class));
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Odczyt danych z SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS_NAME, MODE_PRIVATE);
        String name = sharedPreferences.getString("name", "Brak imienia");
        String surname = sharedPreferences.getString("surname", "Brak nazwiska");

        // Wyświetlenie danych w TextView
        textViewResult.setText(name + " " + surname);
    }
}
