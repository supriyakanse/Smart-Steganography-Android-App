package com.example.smartstegno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class DecryptKey extends AppCompatActivity {
    Button decrypt;

    String dekey;
    EditText ekey,edecrypt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decrypt_key);
        ekey=(EditText)findViewById(R.id.editkey2);
        edecrypt=(EditText)findViewById(R.id.editdecrypt);
        decrypt=(Button)findViewById(R.id.btnde);
        decrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 dekey=decrypt();
                edecrypt.setText(dekey);
                Toast.makeText(DecryptKey.this, "Key Decrypted Successfully!", Toast.LENGTH_SHORT).show();

            }
        });
    }
    public String decrypt()
    {
        String Newstr=" ";
        String str=ekey.getText().toString();
        try {
            for (int i=0;i<str.length();i++)
            {
                char ch=Character.toLowerCase(str.charAt(i));
                switch (ch)
                {
                    case '{':
                        Newstr=Newstr+"a";
                        break;
                    case '}':
                        Newstr=Newstr+"b";
                        break;
                    case '#':
                        Newstr=Newstr+"c";
                        break;
                    case '~':
                        Newstr=Newstr+"d";
                        break;
                    case '+':
                        Newstr=Newstr+"e";
                        break;
                    case '-':
                        Newstr=Newstr+"f";
                        break;
                    case '*':
                        Newstr=Newstr+"g";
                        break;
                    case '@':
                        Newstr=Newstr+"h";
                        break;
                    case '/':
                        Newstr=Newstr+"i";
                        break;
                    case '\\':
                        Newstr=Newstr+"j";
                        break;
                    case '?':
                        Newstr=Newstr+"k";
                        break;
                    case '$':
                        Newstr=Newstr+"l";
                        break;
                    case '!':
                        Newstr=Newstr+"m";
                        break;
                    case '^':
                        Newstr=Newstr+"n";
                        break;
                    case '(':
                        Newstr=Newstr+"o";
                        break;
                    case ')':
                        Newstr=Newstr+"p";
                        break;
                    case '<':
                        Newstr=Newstr+"q";
                        break;
                    case '>':
                        Newstr=Newstr+"r";
                        break;
                    case '=' :
                        Newstr=Newstr+"s";
                        break;
                    case ';':
                        Newstr=Newstr+"t";
                        break;
                    case ',':
                        Newstr=Newstr+"u";
                        break;
                    case '_' :
                        Newstr=Newstr+"v";
                        break;
                    case '[':
                        Newstr=Newstr+"w";
                        break;
                    case ']' :
                        Newstr=Newstr+"x";
                        break;
                    case ':':
                        Newstr=Newstr+"y";
                        break;
                    case '\"' :
                        Newstr=Newstr+"z";
                        break;
                    case ' ' :
                        Newstr=Newstr+" ";
                        break;

                    case 'r':
                        Newstr=Newstr+"1";
                        break;
                    case 'k':
                        Newstr=Newstr+"2";
                        break;
                    case 'b':
                        Newstr=Newstr+"3";
                        break;
                    case 'e':
                        Newstr = Newstr+"4";
                        break;
                    case 'q':
                        Newstr = Newstr+"5";
                        break;
                    case 'h':
                        Newstr = Newstr+"6";
                        break;
                    case 'u':
                        Newstr = Newstr+"7";
                        break;
                    case 'y' :
                        Newstr= Newstr+"8";
                        break;
                    case 'w':
                        Newstr = Newstr+"9";
                        break;
                    case 'z':
                        Newstr = Newstr+"0";
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