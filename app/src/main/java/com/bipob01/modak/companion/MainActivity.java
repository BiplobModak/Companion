package com.bipob01.modak.companion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login=(Button) findViewById(R.id.login);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == login){
            try {
                Intent intent = new Intent(this,DashBoard.class);
                startActivity(intent);
                finish();
            }
            catch (Exception e){
                Toast.makeText(this, "Some thing worng", Toast.LENGTH_SHORT).show();
            }

        }

    }
}
