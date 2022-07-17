package com.example.smartstegno;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
//import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.smartstegno.encodedecode.Decode;
import com.example.smartstegno.encodedecode.Encode;

public class HomeActivity extends AppCompatActivity {

    Button btnencode,btndecode,btnkey;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        btnencode=(Button)findViewById(R.id.buttonencode);
        btndecode=(Button)findViewById(R.id.buttondecode);
        btnkey=(Button)findViewById(R.id.buttonkey);
        btnencode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), Encode.class);
                startActivity(intent);
            }
        });
        btndecode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), Decode.class);
                startActivity(intent);
            }
        });
        btnkey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), KeyActivity.class);
                startActivity(intent);

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.info){
            Intent i=new Intent(getApplicationContext(),info.class);
            startActivity(i);
        }
        else if(id==R.id.about){
            Intent i=new Intent(getApplicationContext(),aboutus.class);
            startActivity(i);
        }
        return true;
    }
}