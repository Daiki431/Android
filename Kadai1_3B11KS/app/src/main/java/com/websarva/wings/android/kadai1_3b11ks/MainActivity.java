package com.websarva.wings.android.kadai1_3b11ks;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView dateText = (TextView)findViewById(R.id.date_id);
　　　　Date date = new Date();
　　　　SimpleDateFormat sdf = new SimpleDateFormat("yyyy'年'MM'月'dd'日'　kk'時'mm'分'ss'秒'");
　　　　dateText.setText(sdf.format(date));
    }
}
