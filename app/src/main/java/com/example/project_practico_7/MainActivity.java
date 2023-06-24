package com.example.project_practico_7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Switch;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    TextView textFecha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textFecha = findViewById(R.id.textViewFecha);
        initListeners();
    }

    private void initListeners() {
        Button botonCalendario = findViewById(R.id.buttonCalendar);
        Switch switchDayNight = findViewById(R.id.switchDayNight);
        botonCalendario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirCalendario();
            }
        });

        switchDayNight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switchDayNight.isChecked()) {
                    setDayNight(0);
                } else {
                    setDayNight(1);
                }
            }
        });
    }

    public void abrirCalendario(){
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