package com.bipob01.modak.companion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;


public class HolyDays extends AppCompatActivity {

    private long mBackPressTime;
    private Toast bakeToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holy_days);
        Toolbar toolbar = findViewById(R.id.holiday_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Holy Days");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    //double press
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

    //menu create
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater =getMenuInflater();
        inflater.inflate(R.menu.nab_manu, menu);
        return true;
    }
    //item select

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.holiday_profile_item:{
                Intent intent = new Intent(this,UserProfile.class);
                startActivity(intent);
                finish();
                break;
            }
            case R.id.holiday_todo_item:{
                Intent intent = new Intent(this,Todo.class);
                startActivity(intent);
                finish();
                break;
            }

            case R.id.holiday_leaveday_item:{
                Intent intent = new Intent(this,LeaveDays.class);
                startActivity(intent);
                finish();
                break;
            }
            case R.id.holiday_attendance_item:{
                Intent intent = new Intent(this,HolyDays.class);
                startActivity(intent);
                finish();
                break;
            }
            case R.id.holiday_notice_item:{
                Intent intent = new Intent(this,NoticeBoard.class);
                startActivity(intent);
                finish();
                break;
            }
            default:

                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
