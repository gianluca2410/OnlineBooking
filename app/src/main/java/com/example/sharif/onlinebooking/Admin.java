package com.example.sharif.onlinebooking;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

public class Admin extends AppCompatActivity {
    public static final String NOTIFICATION_CHANNEL_ID = "10001" ;
    private final static String default_notification_channel_id = "default" ;
          EditText B_name,A_name,B_page,B_words,B_price,B_edition,B_code;
          Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        B_name=findViewById(R.id.Bname);
        A_name=findViewById(R.id.aname);
        B_page=findViewById(R.id.bpage);
        B_words=findViewById(R.id.bword);
        B_price=findViewById(R.id.bprice);
        B_edition=findViewById(R.id.bedition);
        B_code=findViewById(R.id.code);
        button=findViewById(R.id.sa);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             if(B_name.getText().toString().equals("")||A_name.getText().toString().equals("")||
                     B_page.getText().toString().equals("")||B_words.getText().toString().equals("")||
                     B_price.getText().toString().equals("")||B_edition.getText().toString().equals("")
                     ||B_code.getText().toString().equals("")){
                 Toast.makeText(Admin.this,"Enter data in all fields",Toast.LENGTH_SHORT).show();
             }
             else {
                 Book book=new Book(B_name.getText().toString(),A_name.getText().toString(),
                         B_page.getText().toString(),B_words.getText().toString(),B_price.getText().toString(),
                         B_edition.getText().toString(),B_code.getText().toString());
                 // add data into database
                 Database database=new Database(Admin.this);
                 database.Add(book);
                 B_name.setText("");
                 A_name.setText("");
                 B_page.setText("");
                 B_words.setText("");
                 B_price.setText("");
                 B_edition.setText("");
                 B_code.setText("");
                 // call the notification function
                 scheduleNotification(getNotification("Data added into database"),1000);
                 startActivity(new Intent(Admin.this,Operation.class));
                 finish();
             }
            }
        });
    }
    // notification function
    private Notification getNotification (String content) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder( this, default_notification_channel_id ) ;
        builder.setContentTitle( "Local Notification" ) ;
        builder.setContentText(content) ;
        builder.setSmallIcon(R.drawable. ic_launcher_foreground ) ;
        builder.setAutoCancel( true ) ;
        builder.setChannelId( NOTIFICATION_CHANNEL_ID ) ;
        return builder.build() ;
    }
    // create notification after 1 second
    private void scheduleNotification (Notification notification , int delay) {
        Intent notificationIntent = new Intent( this, NotificationService. class ) ;
        notificationIntent.putExtra(NotificationService. NOTIFICATION_ID , 1 ) ;
        notificationIntent.putExtra(NotificationService. NOTIFICATION , notification) ;
        PendingIntent pendingIntent = PendingIntent. getBroadcast ( this, 0 , notificationIntent , PendingIntent. FLAG_UPDATE_CURRENT ) ;
        long futureInMillis = SystemClock. elapsedRealtime () + delay ;
        AlarmManager alarmManager = (AlarmManager) getSystemService(Admin.this. ALARM_SERVICE ) ;
        assert alarmManager != null;
        alarmManager.set(AlarmManager. ELAPSED_REALTIME_WAKEUP , futureInMillis , pendingIntent) ;
    }
}
