package com.example.book;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class sell extends AppCompatActivity {



    DatabaseHelper mydb;
    EditText editName,editEmail,editBookname,editAutor,editPrice;
    Button btnAddData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell);
        mydb = new DatabaseHelper(this);

        editName = (EditText)findViewById(R.id.editText_name);
        editEmail = (EditText)findViewById(R.id.editText_email);
        editBookname = (EditText)findViewById(R.id.editText_book);
        editAutor = (EditText)findViewById(R.id.editText_author);
        editPrice = (EditText)findViewById(R.id.editText_price);
        btnAddData = (Button)findViewById(R.id.button_add);

        AddData();

    }

    public void AddData()
    {
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = mydb.insertData(
                                editName.getText().toString(),
                                editEmail.getText().toString(),
                                editBookname.getText().toString(),
                                editAutor.getText().toString(),
                                editPrice.getText().toString());
                        if(isInserted = true)
                            Toast.makeText(sell.this,"Data Inserted",Toast.LENGTH_LONG).show();
                        else

                            Toast.makeText(sell.this,"Data Not Inserted",Toast.LENGTH_LONG).show();

                    }
                }
        );
    }



}