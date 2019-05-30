package android.wings.websarva.kadai2_3b11ks

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bList = arrayOf(findViewById(R.id.nameBtn), findViewById(R.id.dateBtn), findViewById<Button>(R.id.timeBtn))
        val listener = HelloListener()
        for (b in bList)
            b.setOnClickListener(listener)
    }

    private inner class HelloListener : View.OnClickListener {
        override fun onClick(view: View) {
            val sTime = SimpleDateFormat("HH時mm分ss秒", Locale.JAPANESE)
            val sDate = SimpleDateFormat("yyyy年MM月dd日(E)", Locale.JAPANESE)
            val d = Date()
            val output = findViewById<TextView>(R.id.mainTv)
            if (view.id == R.id.nameBtn)
                output.text = "名前：竹中大貴"
            else if (view.id == R.id.dateBtn)
                output.text = "現在の日付：" + sDate.format(d)
            else
                output.text = "現在の時刻：" + sTime.format(d)
        }
    }
}
