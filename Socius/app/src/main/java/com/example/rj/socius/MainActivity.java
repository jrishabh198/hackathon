package com.example.rj.socius;



import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.TrafficStats;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Method;
import java.util.List;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final String result = String.valueOf(TrafficStats.getTotalRxBytes());
        final Button b = (Button)(findViewById(R.id.button));
        final TextView t = (TextView)findViewById(R.id.textView);
        b.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                t.setText("yes");
//                Log.v("result ","teri maa ka");
                System.out.println(result+" teri maa ka");
            }
        });

        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread me");
                while(true){
                   boolean mobileDataEnabled = false; // Assume disabled
        ConnectivityManager cm = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        try {

            Class cmClass = Class.forName(cm.getClass().getName());
            Method method = cmClass.getDeclaredMethod("getMobileDataEnabled");
            method.setAccessible(true); // Make the method callable
                                        // get the setting for "mobile data
            mobileDataEnabled = (Boolean)method.invoke(cm);

            if(mobileDataEnabled){
                t.setText("hai");
                System.out.println("hai");
            }
            else{
                t.setText("nh h usme");
                System.out.println("nh h");
            }
        } catch (Exception e) {
            // Some problem accessible private API
            System.out.println(e.getMessage() + " \n ");
            e.printStackTrace();
        }
                }
            }
        });
    }
}
