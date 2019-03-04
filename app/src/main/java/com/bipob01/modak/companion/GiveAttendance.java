package com.bipob01.modak.companion;


import android.app.TimePickerDialog;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class GiveAttendance extends AppCompatActivity implements View.OnClickListener, TimePickerDialog.OnTimeSetListener {
    private Button done;
    private ImageButton cancel;
    private TextView editTime;
    private TextView showDate;
    private TextView showTime;
    private TextView dutyEnds;

    public String datepasser;

    protected  static final String Tag = "Attendance";

    DatabaseHelper mDatabaseHelper;
    int dutyTime;
    String time_n;
    String time_duty;
    String edit_timing;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_give_attendance);

        dutyTime = 8;
        dutyEnds =(TextView) findViewById(R.id.duty_end_time_show);
        showDate = (TextView) findViewById(R.id.current_date);
        cancel = (ImageButton) findViewById(R.id.cancel_att_button);
        done = (Button) findViewById(R.id.submit_attendance);
        editTime = (TextView) findViewById(R.id.edit_time);
        showTime = (TextView) findViewById(R.id.show_time);
        //database helper


        cancel.setOnClickListener(this);
        done.setOnClickListener(this);
        editTime.setOnClickListener(this);

        //show date and time to top of the leayout
        Calendar calendar = Calendar.getInstance();
        String date_n = DateFormat.getDateInstance().format(calendar.getTime());
        datepasser = date_n;
        showDate.setText(date_n);

        //current time

        SimpleDateFormat time = new SimpleDateFormat("HH:mm aa");
        time_n = time.format(calendar.getTime());
        showTime.setText(time_n);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cancel_att_button: {
                Toast.makeText(this,"You haven't give your attendance",Toast.LENGTH_SHORT).show();
                finish();
                break;
            }
            case R.id.submit_attendance:{
                mDatabaseHelper = new DatabaseHelper(this);
                boolean check = mDatabaseHelper.addData(datepasser,edit_timing,time_n,time_duty);
                if(check){
                    Toast.makeText(this,"Sucess full",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(this,"Some thing wrong",Toast.LENGTH_SHORT).show();
                }

                break;
            }
            case R.id.edit_time:{
                DialogFragment timePiker = new TimePikerFragment();
                timePiker.show(getSupportFragmentManager(),"Time Piker");
                break;
            }
            default:
                break;
        }

    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        int duty;
        duty = dutyTime+hourOfDay;
        time_duty = duty+":"+minute;
        if(duty > 24){
            duty = duty - 24;
        }
        else {

        }


        dutyEnds.setText("Duty ends at: "+duty+":"+minute);
        edit_timing= hourOfDay+":"+minute;
        editTime.setText(hourOfDay+":"+minute);
    }
}
