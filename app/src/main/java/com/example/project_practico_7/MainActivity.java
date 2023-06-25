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
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initListeners();
    }

    private void initListeners() {
        Button botonCalendario = findViewById(R.id.buttonCalendar);
        Switch switchNight = findViewById(R.id.switchNight);

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
}