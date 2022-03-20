package com.example.sharif.onlinebooking;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UpdatOperation extends AppCompatActivity {
    EditText p,pa,e,w;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updat_operation);
        final Intent intent=getIntent();
        p=findViewById(R.id.bprice5);
        pa=findViewById(R.id.bpage5);
        e=findViewById(R.id.bedition5);
        w=findViewById(R.id.bword5);
        button=findViewById(R.id.sa1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(p.getText().toString().equals("")||e.getText().toString().equals("")||
                        pa.getText().toString().equals("")||w.getText().toString().equals("")){
                    Toast.makeText(UpdatOperation.this,"All must be filed",Toast.LENGTH_SHORT).show();
                }
                else {
                    Database database = new Database(UpdatOperation.this);
                    database.Update(intent.getStringExtra("CNIC"), p.getText().toString(),
                            e.getText().toString(), pa.getText().toString(), w.getText().toString());
                    p.setText("");
                    pa.setText("");
                    w.setText("");
                    e.setText("");
                }
            }
        });
    }
}
