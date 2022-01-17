package com.example.book;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;

public class about extends AppCompatActivity {



    private ImageButton imageButton;
    private ImageButton imageButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);


        imageButton = (ImageButton) findViewById(R.id.imageButton3);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opensearch();
            }
        });


        imageButton2 = (ImageButton) findViewById(R.id.imageButton4);
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opensell();
            }
        });



    }

    public void opensearch() {
        Intent intent = new Intent(this, search.class);
        startActivity(intent);
    }

    public void opensell() {
        Intent intent = new Intent(about.this, sell.class);
        startActivity(intent);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater =getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.settings:
                Intent i =new Intent(about.this,settings.class);
                startActivity(i);
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }

    }

}