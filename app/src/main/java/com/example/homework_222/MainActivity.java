package com.example.homework_222;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_open_notes) {
            Intent intentNotes = new Intent(MainActivity.this, NotesActivity.class);
            startActivity(intentNotes);
        }

        if (id == R.id.action_open_plans) {
            Intent intentNotes = new Intent(MainActivity.this, PlanActivity.class);
            startActivity(intentNotes);
        }

        if (id == R.id.action_open_address) {
            Intent intentNotes = new Intent(MainActivity.this, AddressActivity.class);
            startActivity(intentNotes);
        }

        if (id == R.id.action_open_pay) {
            Intent intentNotes = new Intent(MainActivity.this, PayActivity.class);
            startActivity(intentNotes);
        }

        return super.onOptionsItemSelected(item);
    }
}
