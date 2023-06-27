package com.example.project_practico_7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initListeners();
        onCreate();
        videoConfig();

    }
    public void onCreate() {
        Toast.makeText(getBaseContext(), "Hola Don Felipes!", Toast.LENGTH_SHORT).show();
    }

    private void initListeners() {
        Button botonCalendario = findViewById(R.id.buttonCalendar);
        Switch switchNight = findViewById(R.id.switchNight);
        Button botonUrl = findViewById(R.id.buttonUrl);

        botonCalendario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirCalendario();
            }
        });

        switchNight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switchNight.isChecked()) {
                    setDayNight(0);
                    Toast.makeText(getBaseContext(), "Enable Dark Mode", Toast.LENGTH_SHORT).show();
                } else {
                    setDayNight(1);
                    Toast.makeText(getBaseContext(), "Enable Light Mode", Toast.LENGTH_SHORT).show();
                }
            }
        });
        botonUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent implicitIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://https://www.google.com/"));
                startActivity(implicitIntent);
            }
        });
    }

    public void abrirCalendario(){
        TextView textFecha = findViewById(R.id.textViewFecha);
        Calendar calendario = Calendar.getInstance();
        int year = calendario.get(Calendar.YEAR);
        int month = calendario.get(Calendar.MONTH);
        int day = calendario.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePicker = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String fecha = "Date " + dayOfMonth + "/" + month + "/" + year;
                textFecha.setText(fecha);
            }
        },year,month,day);
        datePicker.show();

    }

    public void setDayNight(int mode){
        if(mode==0){
            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }
        else{
            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }

    public void videoConfig() {
        VideoView video = findViewById(R.id.videoView);
        Uri path = Uri.parse("android.resource://com.example.project_practico_7/" + R.raw.video);
        video.setVideoURI(path);
        video.setMediaController(new MediaController(this));
        video.requestFocus();
    }
}