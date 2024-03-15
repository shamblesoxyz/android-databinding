package com.assignment.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.assignment.databinding.R;

import java.util.ArrayList;

public class NoteActivity extends AppCompatActivity {

    DatabaseHandler databaseHandler;
    ListView noteListView;
    ArrayList<NoteModel> notes;
    NoteAdapter noteAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        notes = new ArrayList<>();
        noteListView = (ListView) findViewById(R.id.list_view_note);
        noteAdapter = new NoteAdapter(this, R.layout.item_list_note, notes);
        noteListView.setAdapter(noteAdapter);

        InitDatabaseSQLite();
        createDatabaseSQLite();
        databaseSQLite();

    }

    private void createDatabaseSQLite() {
        databaseHandler.queryData("INSERT INTO notes VALUES(null, 'SQLite Example 1')");
        databaseHandler.queryData("INSERT INTO notes VALUES(null, 'SQLite Example 2')");
    }

    private void databaseSQLite() {
        Cursor cursor = databaseHandler.getData("SELECT * FROM notes");
        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            String task = cursor.getString(1);
            notes.add(new NoteModel(id, task));
        }
        noteAdapter.notifyDataSetChanged();
    }

    private void InitDatabaseSQLite() {
        databaseHandler = new DatabaseHandler(this, "notes", null, 1);
        databaseHandler.queryData("CREATE TABLE IF NOT EXISTS notes(id INTEGER PRIMARY KEY, task VARCHAR(120))");
    }
}