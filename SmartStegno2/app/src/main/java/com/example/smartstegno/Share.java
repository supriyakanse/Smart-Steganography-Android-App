package com.example.smartstegno;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Share extends AppCompatActivity {
    EditText eTo,eSubject,eMsg;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
        SharedPreferences keyy=getSharedPreferences("enkeyy",0);
        String key=keyy.getString("encryptkey","0");
            eTo = (EditText) findViewById(R.id.txtTo);
        eSubject = (EditText) findViewById(R.id.txtSub);
        eSubject.setText("SmartStegeno Mail");
        eMsg = (EditText) findViewById(R.id.txtMsg);
        eMsg.setText("your message is just one step away"+key);
        btn = (Button) findViewById(R.id.btnSend);
    }
    public void SendEmail(View view) {


        String strTo=eTo.getText().toString();
        String strSubj=eSubject.getText().toString();

        String strMsg=eMsg.getText().toString();
        Intent it=new Intent(Intent.ACTION_SEND);
        it.putExtra(Intent.EXTRA_EMAIL,new String[]{ strTo});
        it.putExtra(Intent.EXTRA_SUBJECT,strSubj);
        it.putExtra(Intent.EXTRA_TEXT,strMsg);
        it.setType("message/rfc822");
        startActivity(Intent.createChooser(it,"Choose mail App"));

    }
}
