package jp.techacademy.yumie.minakami.aisatsuapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.app.TimePickerDialog;
import android.widget.TimePicker;
import android.util.Log;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView    text;
    int         aisatsu = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button  button1 = (Button) findViewById(R.id.button1);  // button
        button1.setOnClickListener(this);

        Button  button2 = (Button) findViewById(R.id.button2);  // timepickerdialog button
        button2.setOnClickListener(this);

        text = (TextView)   findViewById(R.id.textView);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.button1){
            if(aisatsu == 1)    text.setText("おはよう");
            else if(aisatsu == 2)   text.setText("こんにちは");
            else if(aisatsu == 3)   text.setText("こんばんは");
            else    text.setText("TIMEPICKERDIALOGを押して、任意の時間を設定してください。");
        } else if (v.getId() == R.id.button2){
            setTimePickerDialog();
        }
    }

    private void setTimePickerDialog(){
        final TimePickerDialog timePickerDialog = new TimePickerDialog(
                this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Log.d("UI_PARTS", String.valueOf(hourOfDay) + ":" + String.valueOf(minute));
                        if((2 <= hourOfDay && hourOfDay <= 9) && (0 <= minute && minute < 60))    aisatsu = 1;
                        else if((10 <= hourOfDay && hourOfDay <= 17) && (0 <= minute && minute < 60))   aisatsu = 2;
                        else if (((18 <= hourOfDay && hourOfDay <= 23) || (0 <= hourOfDay && hourOfDay <=1)) && (0 <= minute && minute < 60))  aisatsu = 3;
                     }
                },
                15,
                0,
                true);
        timePickerDialog.show();

    }
}
