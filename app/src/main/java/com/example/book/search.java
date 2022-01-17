package com.example.book;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.nio.file.Paths;

public class search extends AppCompatActivity {



    Button btnviewAll;
    DatabaseHelper mydb;
    EditText nam,aut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        mydb = new DatabaseHelper(this);
        btnviewAll=(Button)findViewById(R.id.button_viewAll);
        nam=(EditText)findViewById(R.id.srName);
        aut=(EditText)findViewById(R.id.srAuthor);

        btnviewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n=nam.getText().toString();
                String au=aut.getText().toString();
                SQLiteDatabase sd = getApplicationContext().openOrCreateDatabase("Details.db", Context.MODE_PRIVATE,null);
                Cursor c=sd.rawQuery("select * from details_table where BOOK_NAME='"+n+"' and AUTHOR='"+au+"'",null);
                if(c.getCount()==0)
                {
                    Toast.makeText(getApplicationContext(),"no records",Toast.LENGTH_LONG).show();
                    return;
                }

                StringBuffer buffer= new StringBuffer();
                while (c.moveToNext()){
                    buffer.append("ID :"+c.getString(0)+"\n");
                    buffer.append("NAME :"+c.getString(1)+"\n");
                    buffer.append("EMAILID :"+c.getString(2)+"\n");
                    buffer.append("BOOK_NAME :"+c.getString(3)+"\n");
                    buffer.append("AUTHOR :"+c.getString(4)+"\n");
                    buffer.append("PRICE :"+c.getString(5)+"\n\n");
                }
                showMessage("Data",buffer.toString());


            }
        });
    }

    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();

    }



}