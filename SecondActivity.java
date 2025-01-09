package com.example.testshared;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private EditText editTextName, editTextSurname;
    private static final String SHARED_PREFS_NAME = "MySharedPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        editTextName = findViewById(R.id.editTextName);
        editTextSurname = findViewById(R.id.editTextSurname);
        Button buttonSaveData = findViewById(R.id.buttonSaveData);

        // Zapisz dane w SharedPreferences i wróć do MainActivity
        buttonSaveData.setOnClickListener(v -> {
            saveDataToSharedPreferences();
            finish(); // Zamknij drugą aktywność
        });
    }

    private void saveDataToSharedPreferences() {
        // Pobierz dane wprowadzone przez użytkownika
        String name = editTextName.getText().toString();
        String surname = editTextSurname.getText().toString();

        // Zapisz dane do SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name", name);
        editor.putString("surname", surname);
        editor.apply();
    }
}
