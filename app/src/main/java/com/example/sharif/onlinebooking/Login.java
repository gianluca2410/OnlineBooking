package com.example.sharif.onlinebooking;

import static com.example.sharif.onlinebooking.Constant.ADMIN;
import static com.example.sharif.onlinebooking.Constant.CONTACT;
import static com.example.sharif.onlinebooking.Constant.USER;
import static com.example.sharif.onlinebooking.Constant.getSelectedLanguage;
import static com.example.sharif.onlinebooking.Constant.setSelectedLanguage;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {
   Button user,admin,contact;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        user=findViewById(R.id.user);
        admin=findViewById(R.id.admin);
        contact=findViewById(R.id.contact);
        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Login.this,MainActivity.class);
                startActivity(intent);
            }
        });
        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
       Intent intent=new Intent(Login.this, AdminLogin.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        if(getSelectedLanguage(this).equals("English")){
            user.setText(getResources().getString(R.string.user));
            admin.setText(getResources().getString(R.string.admin));
            contact.setText(getResources().getString(R.string.contact));
        }
        else{
            user.setText(USER);
            admin.setText(ADMIN);
            contact.setText(CONTACT);
        }
        super.onStart();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.item1:
                setSelectedLanguage(Login.this,"English");
                user.setText(getResources().getString(R.string.user));
                admin.setText(getResources().getString(R.string.admin));
                contact.setText(getResources().getString(R.string.contact));
                return true;
            case R.id.item2:
                setSelectedLanguage(Login.this,"Italian");
                user.setText(USER);
                admin.setText(ADMIN);
                contact.setText(CONTACT);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }



    @Override
    public void onActivityResult(int reqCode, int resultCode, Intent data) {
        super.onActivityResult(reqCode, resultCode, data);

        switch (reqCode) {
            case (1) :
                if (resultCode == Activity.RESULT_OK) {
                    Uri contactData = data.getData();
                    Cursor c =  managedQuery(contactData, null, null, null, null);
                    if (c.moveToFirst()) {
                        @SuppressLint("Range") String name = c.getString(c.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                        // TODO Fetch other Contact details as you want to use

                    }
                }
                break;
        }
    }
    public void openContact(View view) {

        Intent intent= new Intent(Intent.ACTION_PICK,  ContactsContract.Contacts.CONTENT_URI);

        startActivityForResult(intent, 1);
    }
}
