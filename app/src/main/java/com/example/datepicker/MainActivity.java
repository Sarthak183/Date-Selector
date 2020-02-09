package com.example.datepicker;
import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private DatePickerDialog.OnDateSetListener mlistener;
    private TextView result;
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.textresultdate);
        btn = findViewById(R.id.btnpickdate);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();

                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog Dialog = new DatePickerDialog(
                        MainActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,mlistener,year,month,day
                );

                Dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                Dialog.show();
            }
        });
     mlistener = new DatePickerDialog.OnDateSetListener() {
         @Override
         public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

             month++;
             String date = dayOfMonth + "/" +month +"/" +year;

             result.setText(date);
         }
     };

    }
}
