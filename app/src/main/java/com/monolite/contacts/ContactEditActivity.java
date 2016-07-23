package com.monolite.contacts;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import com.monolite.contacts.database.DBAdapter;

public class ContactEditActivity extends AppCompatActivity {

    EditText edtName;
    EditText edtMail;
    EditText edtTwitter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_contact_edit);
        edtName = (EditText) findViewById(R.id.edtName);
        edtMail = (EditText) findViewById(R.id.edtMail);
        edtTwitter = (EditText) findViewById(R.id.edtTwitter);

    }

    public void saveDate(View view){
        DBAdapter adapter = new DBAdapter(ContactEditActivity.this, "myDB", null, 1);

        SQLiteDatabase acts = adapter.getWritableDatabase();

        String name = edtName.getText().toString();
        String mail = edtName.getText().toString();
        String twitter = edtName.getText().toString();

        ContentValues cv = new ContentValues();
        cv.put("name", name);
        cv.put("email", mail);
        cv.put("twitter", twitter);

        acts.insert("user", null, cv);
        acts.close();
        cv.clear();

        showSnackBar(view);
    }

    public void showSnackBar(View view){
        Snackbar.make(view, "Registro almacenado", Snackbar.LENGTH_LONG)
                .setAction("Aceptar", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(ContactEditActivity.this, MainActivity.class);

                        startActivity(intent);
                    }
                }).show();
    }

}
