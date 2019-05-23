package android.wings.websarva.kadai1_3b11ks;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView dateText = findViewById(R.id.dateTv);
        TextView timeText = findViewById((R.id.timeTv));
        Date d = new Date();
        SimpleDateFormat sTime = new SimpleDateFormat("HH時mm分ss秒", Locale.JAPANESE);
        SimpleDateFormat sDate = new SimpleDateFormat("yyyy年MM月dd日(E)",Locale.JAPANESE);
        timeText.setText("現在の時刻："+sTime.format(d));
        dateText.setText("今日の日付："+sDate.format(d));
    }
}
