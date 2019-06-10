package com.example.kadai4_3b11ks;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        String name = intent.getStringExtra("Name");
        String address = intent.getStringExtra("Address");
        String tel = intent.getStringExtra("Tel");
        String mail = intent.getStringExtra("Mail");
        String hobby = intent.getStringExtra("Hobby");

        TextView tvName = findViewById(R.id.tvName);
        TextView tvAddress = findViewById(R.id.tvAddress);
        TextView tvTel = findViewById(R.id.tvTel);
        TextView tvMail = findViewById(R.id.tvE_Mail);
        TextView tvHobby = findViewById(R.id.tvHobby);

        tvName.setText("名前："+name);
        tvAddress.setText("住所："+address);
        tvTel.setText("電話"+tel);
        tvMail.setText("E-Mail："+mail);
        tvHobby.setText("趣味："+hobby);
    }

    public void onBackButtonClick(View view){
        finish();
    }
}
