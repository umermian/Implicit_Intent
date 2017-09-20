package com.example.popie.implicit_intent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void process(View view){
        Intent intent = null , chooser = null;

        if(view.getId()==R.id.launchMap){
            intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("geo:31.4181610 , 74.1865580"));
            startActivity(intent);
        }

        if(view.getId()==R.id.launchMarket){
            intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("market://details?id=com.sticksports.stickcricket2&hl=en"));
            startActivity(intent);
        }

        if(view.getId()==R.id.sendEmail){
            intent = new Intent(Intent.ACTION_SEND);
            intent.setData(Uri.parse("mailto:"));
            String[] to = {"umermian93@gmai.com" };
            intent.putExtra(Intent.EXTRA_EMAIL , to);
            intent.putExtra(Intent.EXTRA_SUBJECT , "send from umers app");
            intent.putExtra(Intent.EXTRA_TEXT , "This app is just for testing purpose");
            intent.setType("message/rfc822");
            chooser = Intent.createChooser(intent, "Send Email using");
            startActivity(chooser);
        }
    }
}
