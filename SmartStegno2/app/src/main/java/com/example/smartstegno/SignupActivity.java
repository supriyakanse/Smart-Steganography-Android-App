package com.example.smartstegno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.smartstegno.database.DatabaseHelper;

public class SignupActivity extends AppCompatActivity {
    EditText username,password,repassword;
    Button signup,signin;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        getWindow().setStatusBarColor(Color.TRANSPARENT);
        setContentView(R.layout.activity_signup);

        username=(EditText)findViewById(R.id.edittext_username);
        password=(EditText)findViewById(R.id.edittext_password);
        repassword=(EditText)findViewById(R.id.edittext_con_password);
        signup=(Button)findViewById(R.id.btnsignup);
        signin=(Button)findViewById(R.id.btnsignin);
        db=new DatabaseHelper(this);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user= username.getText().toString();
                String pass=password.getText().toString();
                String repass=repassword.getText().toString();

                if (user.equals("")||pass.equals("")||repass.equals(""))
                    Toast.makeText(SignupActivity.this,"Please enter all the fields",Toast.LENGTH_SHORT).show();
                else
                if (pass.equals(repass))
                {
                    Boolean checkuser=db.checkusername(user);  //user already exits or not
                    if (checkuser==false)
                    {
                        Boolean insert=db.insertuser(user,pass); //inserting data in table
                        if (insert==true) //database has been wriiten
                        {
                            Toast.makeText(SignupActivity.this,"Registered successfully",Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(getApplicationContext(),HomeActivity.class);
                            startActivity(intent);
                        }
                        else
                            Toast.makeText(SignupActivity.this," Opps..Registeration failed!",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(SignupActivity.this,"User already exists,please sign in.",Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(SignupActivity.this,"Password Not Matching",Toast.LENGTH_SHORT).show();
                }


            }
        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
            }
        });

    }



}
