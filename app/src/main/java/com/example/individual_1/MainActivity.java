package com.example.individual_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.icu.text.TimeZoneNames;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {

    //Calendar current;
    TextView timezone_time,dubai_time,la_time,tokyo_time,london_time,paris_time,beijing_time;
    Long miliSecondsDubai,miliSecondsLosAngeles,miliSecondsTokyo,miliSecondsLondon,miliSecondsParis,miliSecondsBeijing;
    Date date,dubaiD,laD,tokyoD,londonD,parisD,beijingD;
    SimpleDateFormat sdf;
    Thread thread;
    Button btn12, btn24;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn12 = findViewById(R.id.btn_12h);
        btn24 = findViewById(R.id.btn_24H);
        dubai_time = findViewById(R.id.dubai_time);
        la_time = findViewById(R.id.la_time);
        tokyo_time = findViewById(R.id.tokyo_time);
        london_time = findViewById(R.id.london_time);
        paris_time = findViewById(R.id.paris_time);
        beijing_time = findViewById(R.id.beijing_time);


        sdf = new SimpleDateFormat("HH:mm:ss aa");
        //thread to update time every second
        thread = new Thread() {
            @Override
            public void run() {
                try {
                    while (!thread.isInterrupted()) {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                                dubaiD = new Date(calculate("Asia/Dubai"));
                                laD = new Date(calculate("America/Los_Angeles"));
                                tokyoD = new Date(calculate("Asia/Tokyo"));
                                londonD = new Date(calculate("Europe/London"));
                                parisD = new Date(calculate("Europe/Paris"));
                                beijingD = new Date(calculate("Asia/Shanghai"));


                                dubai_time.setText(sdf.format(dubaiD));
                                la_time.setText(sdf.format(laD));
                                tokyo_time.setText(sdf.format(tokyoD));
                                london_time.setText(sdf.format(londonD));
                                paris_time.setText(sdf.format(parisD));
                                beijing_time.setText(sdf.format(beijingD));

                                miliSecondsDubai = miliSecondsLosAngeles = miliSecondsTokyo = miliSecondsLondon = miliSecondsParis = miliSecondsBeijing = 0L;


                            }
                        });
                    }
                } catch (InterruptedException e) {
                }
            }
        };

        thread.start();

        ConstraintLayout hideUnhide = findViewById(R.id.dubai);
        btn12.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                sdf = new SimpleDateFormat("h:mm:ss aa");
                //thread to update time every second
                thread = new Thread() {
                    @Override
                    public void run() {
                        try {
                            while (!thread.isInterrupted()) {
                                Thread.sleep(1000);
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {

                                        dubaiD = new Date(calculate("Asia/Dubai"));
                                        laD = new Date(calculate("America/Los_Angeles"));
                                        tokyoD = new Date(calculate("Asia/Tokyo"));
                                        londonD = new Date(calculate("Europe/London"));
                                        parisD = new Date(calculate("Europe/Paris"));
                                        beijingD = new Date(calculate("Asia/Shanghai"));


                                        dubai_time.setText(sdf.format(dubaiD));
                                        la_time.setText(sdf.format(laD));
                                        tokyo_time.setText(sdf.format(tokyoD));
                                        london_time.setText(sdf.format(londonD));
                                        paris_time.setText(sdf.format(parisD));
                                        beijing_time.setText(sdf.format(beijingD));

                                        miliSecondsDubai = miliSecondsLosAngeles = miliSecondsTokyo = miliSecondsLondon = miliSecondsParis = miliSecondsBeijing = 0L;


                                    }
                                });
                            }
                        } catch (InterruptedException e) {
                        }
                    }
                };

                thread.start();
            }
        });

        btn24.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                sdf = new SimpleDateFormat("HH:mm:ss");
                //thread to update time every second
                thread = new Thread() {
                    @Override
                    public void run() {
                        try {
                            while (!thread.isInterrupted()) {
                                Thread.sleep(1000);
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {

                                        dubaiD = new Date(calculate("Asia/Dubai"));
                                        laD = new Date(calculate("America/Los_Angeles"));
                                        tokyoD = new Date(calculate("Asia/Tokyo"));
                                        londonD = new Date(calculate("Europe/London"));
                                        parisD = new Date(calculate("Europe/Paris"));
                                        beijingD = new Date(calculate("Asia/Shanghai"));


                                        dubai_time.setText(sdf.format(dubaiD));
                                        la_time.setText(sdf.format(laD));
                                        tokyo_time.setText(sdf.format(tokyoD));
                                        london_time.setText(sdf.format(londonD));
                                        paris_time.setText(sdf.format(parisD));
                                        beijing_time.setText(sdf.format(beijingD));

                                        miliSecondsDubai = miliSecondsLosAngeles = miliSecondsTokyo = miliSecondsLondon = miliSecondsParis = miliSecondsBeijing = 0L;


                                    }
                                });
                            }
                        } catch (InterruptedException e) {
                        }
                    }
                };

                thread.start();
            }
        });
        /*hideUnhide.setOnClickListener({
                hideUnhide.setVisibility(hideUnhide.INVISIBLE);


        });*/

    }
    private long calculate(String timeZone){
        TimeZone tz = TimeZone.getTimeZone(timeZone);
        Calendar current = Calendar.getInstance();
        Long miliSeconds = current.getTimeInMillis();
        TimeZone tzCurr = current.getTimeZone();
        int offset = tzCurr.getRawOffset();
        if(tzCurr.inDaylightTime(new Date())){
            offset = offset + tzCurr.getDSTSavings();
        }
        miliSeconds = miliSeconds - offset + tz.getRawOffset();
        return miliSeconds;
    }


}
