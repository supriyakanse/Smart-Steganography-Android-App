package com.example.smartstegno;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.smartstegno.encodedecode.Encode;

public class EncryptKey extends AppCompatActivity {
    EditText ekey,eencrypt;
    Button encrypt;
    String enkey;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encrypt_key);
        ekey=(EditText)findViewById(R.id.editkey);
        eencrypt=(EditText)findViewById(R.id.editencryptkey);
        encrypt=(Button)findViewById(R.id.btnen);
        encrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enkey= encrypt();
               eencrypt.setText(enkey);
               String demo=eencrypt.getText().toString();
                Toast.makeText(EncryptKey.this, "Key Encrypted Successfully!", Toast.LENGTH_SHORT).show();
                SharedPreferences keyy=getSharedPreferences("enkeyy",0);
                SharedPreferences.Editor editor=keyy.edit();
                editor.putString("encryptkey",eencrypt.getText().toString());
                editor.commit();
            }
        });
    }
    public String encrypt()
    {
        String Newstr=" ";
        String str=ekey.getText().toString();
        try {
            for (int i = 0; i < str.length(); i++) {
                char ch=Character.toLowerCase(str.charAt(i));
                switch (ch)
                {
                    case 'a':
                        Newstr=Newstr+"{";
                        break;
                    case 'b':
                        Newstr=Newstr+"}";
                        break;
                    case 'c':
                        Newstr=Newstr+"#";
                        break;
                    case 'd':
                        Newstr=Newstr+"~";
                        break;
                    case 'e':
                        Newstr=Newstr+"+";
                        break;
                    case 'f':
                        Newstr=Newstr+"-";
                        break;
                    case 'g':
                        Newstr=Newstr+"*";
                        break;
                    case 'h':
                        Newstr=Newstr+"@";
                        break;
                    case 'i':
                        Newstr=Newstr+"/";
                        break;
                    case 'j':
                        Newstr=Newstr+"\\";
                        break;
                    case 'k':
                        Newstr=Newstr+"?";
                        break;
                    case 'l':
                        Newstr=Newstr+"$";
                        break;
                    case 'm':
                        Newstr=Newstr+"!";
                        break;
                    case 'n':
                        Newstr=Newstr+"^";
                        break;
                    case 'o':
                        Newstr=Newstr+"(";
                        break;
                    case 'p':
                        Newstr=Newstr+")";
                        break;
                    case 'q':
                        Newstr=Newstr+"<";
                        break;
                    case 'r':
                        Newstr=Newstr+">";
                        break;
                    case 's' :
                        Newstr=Newstr+"=";
                        break;
                    case 't':
                        Newstr=Newstr+";";
                        break;
                    case 'u':
                        Newstr=Newstr+",";
                        break;
                    case 'v' :
                        Newstr=Newstr+"_";
                        break;
                    case 'w':
                        Newstr=Newstr+"[";
                        break;
                    case 'x' :
                        Newstr=Newstr+"]";
                        break;
                    case 'y':
                        Newstr=Newstr+":";
                        break;
                    case 'z' :
                        Newstr=Newstr+"\"";
                        break;
                    case ' ' :
                        Newstr=Newstr+" ";
                        break;
                    case '.':
                        Newstr=Newstr+'3';
                        break;
                    case ',':
                        Newstr=Newstr+"1";
                        break;
                    case '(':
                        Newstr=Newstr+'4';
                        break;
                    case '\"':
                        Newstr=Newstr+'5';
                        break;
                    case ')' :
                        Newstr=Newstr+"7";
                        break;
                    case '?' :
                        Newstr= Newstr+"2";
                        break;
                    case '!':
                        Newstr= Newstr+"8";
                        break;
                    case '-' :
                        Newstr= Newstr+"6";
                        break;
                    case '%' :
                        Newstr = Newstr+"9";
                        break;
                    case '1':
                        Newstr=Newstr+"r";
                        break;
                    case '2':
                        Newstr=Newstr+"k";
                        break;
                    case '3':
                        Newstr=Newstr+"b";
                        break;
                    case '4':
                        Newstr = Newstr+"e";
                        break;
                    case '5':
                        Newstr = Newstr+"q";
                        break;
                    case '6':
                        Newstr = Newstr+"h";
                        break;
                    case '7':
                        Newstr = Newstr+"u";
                        break;
                    case '8' :
                        Newstr= Newstr+"y";
                        break;
                    case '9':
                        Newstr = Newstr+"w";
                        break;
                    case '0':
                        Newstr = Newstr+"z";
                        break;
                    default:
                        Newstr=Newstr+"0";
                        break;
                }
            }
        }
        catch(Exception ioe)
        {
            ioe.printStackTrace();
        }
       return Newstr;
    }
}