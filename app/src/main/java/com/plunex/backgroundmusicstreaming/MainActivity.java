package com.plunex.backgroundmusicstreaming;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        String command = intent.getStringExtra("key");
        if (command == null){
            Toast.makeText(this, "No Extra.", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, command, Toast.LENGTH_SHORT).show();
            Intent serviceIntent = new Intent(this, MainIntentService.class);
            stopService(serviceIntent);
        }

    }

    public void startStreaming(View view) {
        Intent mServiceIntent = new Intent(this, MainIntentService.class);
        mServiceIntent.putExtra("STRING_EXTRA", "OBKM EXTRA");
        startService(mServiceIntent);

    }

    public void stopStreaming(View view) {
        Intent serviceIntent = new Intent(this, MainIntentService.class);
        stopService(serviceIntent);
    }
}
