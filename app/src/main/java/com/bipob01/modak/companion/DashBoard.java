package com.bipob01.modak.companion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Toast;

public class DashBoard extends AppCompatActivity implements View.OnClickListener {

    private CardView mProfile;
    private CardView mTodo;
    private CardView mNotice;
    private CardView mAttendance;
    private CardView mHolidays;
    private CardView mLeaveday;

    private long mBackPressTime;
    private Toast bakeToast;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        mNotice = (CardView) findViewById(R.id.notice);
        mTodo = (CardView) findViewById(R.id.todo);
        mAttendance = (CardView) findViewById(R.id.attendance);
        mProfile = (CardView) findViewById(R.id.profile);
        mHolidays = (CardView) findViewById(R.id.holiday);
        mLeaveday = (CardView) findViewById(R.id.leaveday);

        mLeaveday.setOnClickListener(this);
        mHolidays.setOnClickListener(this);
        mProfile.setOnClickListener(this);
        mAttendance.setOnClickListener(this);
        mTodo.setOnClickListener(this);
        mNotice.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.profile:
                {
                    Intent intent = new Intent(this,UserProfile.class);
                    startActivity(intent);

                    break;
                }
            case R.id.todo:
                {
                    Intent intent = new Intent(this,Todo.class);
                    startActivity(intent);

                    break;
                }
            case R.id.notice:
                {
                    Intent intent = new Intent(this,NoticeBoard.class);
                    startActivity(intent);

                    break;
                }
            case R.id.attendance:
                {
                    Intent intent = new Intent(this,Attendance.class);
                    startActivity(intent);

                    break;
                }
            case R.id.leaveday:
                {
                    Intent intent = new Intent(this,LeaveDays.class);
                    startActivity(intent);

                    break;
                }
            case R.id.holiday:
                {
                    Intent intent = new Intent(this, HolyDays.class);
                    startActivity(intent);

                    break;
                }
            default:
                {
                    break;

                }
        }

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
}
