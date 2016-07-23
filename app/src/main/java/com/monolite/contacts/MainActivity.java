package com.monolite.contacts;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.monolite.contacts.database.DBAdapter;
import com.monolite.contacts.model.Contact;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvContacts;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        lvContacts = (ListView) findViewById(R.id.lvContacts);

        setupFab();
        showData();

    }

    public void setupFab(){
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/

                Intent intent = new Intent(getBaseContext(), ContactEditActivity.class);
                startActivity(intent);
            }
        });
    }

    public void showData(){
        DBAdapter adapter = new DBAdapter(MainActivity.this, "myDB", null, 1);

        SQLiteDatabase acts = adapter.getReadableDatabase();

        ArrayList<Contact> contacts = new ArrayList<Contact>();

        Cursor regs = acts.rawQuery("SELECT * FROM user", null);

        while (regs.moveToNext()){
            int id = regs.getInt(0);
            String name = regs.getString(1);
            String mail = regs.getString(2);
            String twitter = regs.getString(3);

            Contact c = new Contact(id, name,mail, twitter);

            contacts.add(c);
        }

        acts.close();
        regs.close();

        ArrayAdapter<Contact> arrayAdapter = new ArrayAdapter<Contact>(MainActivity.this, android.R.layout.simple_list_item_1, contacts);

        lvContacts.setAdapter(arrayAdapter);
    }
}
