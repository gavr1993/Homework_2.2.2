package com.example.homework_222;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class NotesActivity extends AppCompatActivity {

    private EditText noteEdtx;
    private Button saveBtn;
    private SharedPreferences noteSharedPref;
    private static String NOTE_TEXT = "note_text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        init();
        noteSharedPref = getSharedPreferences("my_prefs", MODE_PRIVATE);
        getDateFromSharedPref();
    }

    private void init() {
        noteEdtx = findViewById(R.id.noteEdtx);
        saveBtn = findViewById(R.id.saveBtn);


        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor myEditor = noteSharedPref.edit();
                String noteTxt = noteEdtx.getText().toString();
                myEditor.putString(NOTE_TEXT, noteTxt);
                myEditor.apply();
                Toast.makeText(NotesActivity.this, R.string.saveData, Toast.LENGTH_LONG).show();

            }
        });
    }

    private void getDateFromSharedPref() {
        String noteTxt = noteSharedPref.getString(NOTE_TEXT, "");
        noteEdtx.setText(noteTxt);
    }
}