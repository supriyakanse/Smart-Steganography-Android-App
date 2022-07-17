package com.example.smartstegno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.smartstegno.encodedecode.Decode;

public class KeyActivity extends AppCompatActivity {
    Button btnencrypt,btndecrypt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_key);
        btnencrypt=(Button)findViewById(R.id.buttonencrypt);
        btndecrypt=(Button)findViewById(R.id.buttondecrypt);
        btnencrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), EncryptKey.class);
                startActivity(intent);
            }
        });
        btndecrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), DecryptKey.class);
                startActivity(intent);
            }
        });
    }
}