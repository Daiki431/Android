package android.wings.websarva.kadai2_3b11ks;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bList[]={findViewById(R.id.nameBtn),
                findViewById(R.id.dateBtn),
                findViewById(R.id.timeBtn)};
        HelloListener listener = new HelloListener();
        for(Button b:bList)
            b.setOnClickListener(listener);
    }

    private class HelloListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            SimpleDateFormat sTime = new SimpleDateFormat("HH時mm分ss秒", Locale.JAPANESE);
            SimpleDateFormat sDate = new SimpleDateFormat("yyyy年MM月dd日(E)", Locale.JAPANESE);
            Date d = new Date();
            TextView output = findViewById(R.id.mainTv);
            if (view.getId() == R.id.nameBtn)
                output.setText("名前：竹中大貴");
            else if (view.getId() == R.id.dateBtn)
                output.setText("現在の日付：" + sDate.format(d));
            else
                output.setText("現在の時刻：" + sTime.format(d));
        }
    }

}
