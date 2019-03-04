package com.bipob01.modak.companion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Attendance extends AppCompatActivity implements View.OnClickListener {
    private long mBackPressTime;
    private Toast bakeToast;
    private TextView date,time,statusSignIn,statusSignOut;
    private CardView signInTime, signOutTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);
        Toolbar toolbar = findViewById(R.id.attendance_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Attendance");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        statusSignOut =(TextView) findViewById(R.id.status_signout);
        statusSignIn =(TextView) findViewById(R.id.status_signin);
        date = (TextView) findViewById(R.id.date);
        time = (TextView) findViewById(R.id.time);
        signInTime = (CardView) findViewById(R.id.att_signin);
        signOutTime = (CardView) findViewById(R.id.att_signout);

        Calendar calendar = Calendar.getInstance();
        String date_n = DateFormat.getDateInstance().format(calendar.getTime());
        date.setText(date_n);
        SimpleDateFormat time_m = new SimpleDateFormat("HH:mm aa");
        String time_n = time_m.format(calendar.getTime());
        time.setText(time_n);


        signInTime.setOnClickListener(this);
        signOutTime.setOnClickListener(this);


    }

    @Override
    public void onBackPressed() {

        if(mBackPressTime +2000 > System.currentTimeMillis())
        {
            bakeToast.cancel();
            super.onBackPressed();
            return;
        }
        else {
            bakeToast = Toast.makeText(getBaseContext(),"Press back again to exit",Toast.LENGTH_SHORT);
            bakeToast.show();
        }

        mBackPressTime = System.currentTimeMillis();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.attendance_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.attendance_profile_item:{
                Intent intent = new Intent(this,UserProfile.class);
                startActivity(intent);
                finish();
                break;
            }
            case R.id.attendance_todo_item:{
                Intent intent = new Intent(this,Todo.class);
                startActivity(intent);
                finish();
                break;
            }

            case R.id.attendance_leaveday_item:{
                Intent intent = new Intent(this,LeaveDays.class);
                startActivity(intent);
                finish();
                break;
            }
            case R.id.attendance_holiday_item:{
                Intent intent = new Intent(this,HolyDays.class);
                startActivity(intent);
                finish();
                break;
            }
            case R.id.attendance_notice_item:{
                Intent intent = new Intent(this,NoticeBoard.class);
                startActivity(intent);
                finish();
                break;
            }
            case R.id.attendance_history_item:

                break;

            default:

                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.att_signin:
            {
                Intent intent = new Intent(this,GiveAttendance.class);
                startActivity(intent);
                break;
            }
            case R.id.att_signout:
            {
                Intent intent = new Intent(this,GiveAttendance.class);
                startActivity(intent);
                break;
            }
            default:

                break;
        }
    }
}
