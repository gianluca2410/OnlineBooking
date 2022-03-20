package com.example.sharif.onlinebooking;

import static com.example.sharif.onlinebooking.Constant.ADMIN;
import static com.example.sharif.onlinebooking.Constant.CONTACT;
import static com.example.sharif.onlinebooking.Constant.DELETE;
import static com.example.sharif.onlinebooking.Constant.INSERT;
import static com.example.sharif.onlinebooking.Constant.UPDATE;
import static com.example.sharif.onlinebooking.Constant.USER;
import static com.example.sharif.onlinebooking.Constant.getSelectedLanguage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Operation extends AppCompatActivity {
   Button b1,b2,b3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operation);
        b1=findViewById(R.id.upp);
        b2=findViewById(R.id.ne);
        b3=findViewById(R.id.del);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Operation.this,Update.class);
                startActivity(intent);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Operation.this,Admin.class);
                startActivity(intent);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Operation.this,Deletion.class);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onStart() {
        if(getSelectedLanguage(this).equals("English")){
            b1.setText(getResources().getString(R.string.update));
            b2.setText(getResources().getString(R.string.insert));
            b3.setText(getResources().getString(R.string.delete));
        }
        else{
            b1.setText(UPDATE);
            b2.setText(INSERT);
            b3.setText(DELETE);
        }
        super.onStart();
    }
}
