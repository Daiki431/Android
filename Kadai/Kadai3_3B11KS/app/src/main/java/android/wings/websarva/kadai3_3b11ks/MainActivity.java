package android.wings.websarva.kadai3_3b11ks;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv = findViewById(R.id.mainTv);
        Spinner sp = findViewById(R.id.sp);
        String spItems[]={
                "10","11","12","13","14","15","16","17","18","19"
        };
        ArrayAdapter<String> ad = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,spItems);
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(ad);
        SimpleDateFormat sdf = new SimpleDateFormat("ahh時mm分ss秒", Locale.ENGLISH);
        Date d = new Date();
        tv.setText("現在の時刻："+sdf.format(d));
        RadioGroup radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        sp.setOnItemSelectedListener(new SampleItemSelectedListener());
        radioGroup.setOnCheckedChangeListener(new SampleCheckedChangeListener());
    }

    class SampleCheckedChangeListener implements RadioGroup.OnCheckedChangeListener{
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            SimpleDateFormat s24Time = new SimpleDateFormat("HH時mm分ss秒", Locale.JAPANESE);
            SimpleDateFormat s12Time = new SimpleDateFormat("ahh時mm分ss秒", Locale.ENGLISH);
            Date d = new Date();
            RadioButton radioButton = (RadioButton) group.findViewById(checkedId);
            TextView output = findViewById(R.id.mainTv);
            if (checkedId == R.id.h12)
                output.setText("現在の時刻："+s24Time.format(d));
            else
                output.setText("現在の時刻："+s12Time.format(d));
        }
    }

    class SampleItemSelectedListener implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            TextView tv = findViewById(R.id.mainTv);
            tv.setTextSize(Integer.parseInt(((TextView)view).getText().toString()));
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {}
    }
}
