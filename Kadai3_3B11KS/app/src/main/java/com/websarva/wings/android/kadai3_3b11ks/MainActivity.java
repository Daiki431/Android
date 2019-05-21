package com.websarva.wings.android.kadai3_3b11ks;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RadioGroup radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                SimpleDateFormat s24Time = new SimpleDateFormat("HH時mm分ss秒", Locale.JAPANESE);
                SimpleDateFormat s12Time = new SimpleDateFormat("hh時mm分ss秒", Locale.JAPANESE);
                Date d = new Date();
                RadioButton radioButton = (RadioButton) group.findViewById(checkedId);
                TextView output = findViewById(R.id.mainTv);
                if (checkedId == R.id.h12)
                    output.setText("現在の時刻："+s24Time.format(d));
                else
                    output.setText("現在の時刻："+s12Time.format(d));
            }
        });
    }
}
