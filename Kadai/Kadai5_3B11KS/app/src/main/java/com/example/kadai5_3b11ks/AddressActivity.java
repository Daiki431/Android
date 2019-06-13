package com.example.kadai5_3b11ks;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddressActivity extends AppCompatActivity {
    private ListView _lvAdd;
    private List<Map<String,Object>> _addList;
    private static final String[] FROM = {"Name"};
    private static final int[] TO = {R.id.tvName};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);

        Button btAddressAdd = findViewById(R.id.addressAddOption);
        AddItemClickListener addListener = new AddItemClickListener();
        //btAddressAdd.setOnClickListener(addListener);
        _lvAdd = findViewById(R.id.lvAddress);
        _addList = createAddList();
        SimpleAdapter adapter = new SimpleAdapter(AddressActivity.this,_addList,R.layout.row,FROM,TO);
        _lvAdd.setAdapter(adapter);
        _lvAdd.setOnItemClickListener(new ListItemClickListener());

    }

    class AddItemClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {

        }
    }

    public boolean onOptionsItemSelected(MenuItem item){
        Intent intent = new Intent(AddressActivity.this,AddActivity.class);
        startActivity(intent);
        return true;
    }

    private List<Map<String,Object>> createAddList(){
        List<Map<String,Object>> addList = new ArrayList<>();
        Map<String,Object> add = new HashMap<>();

        add.put("Name","大阪太郎");
        add.put("Address","大阪府");
        add.put("Tel","1234-12-1234");
        add.put("E-Mail","osaka@osaka.jp");
        add.put("Hobby","運動");
        addList.add(add);

        add = new HashMap<>();
        add.put("Name","大阪太郎1");
        add.put("Address","大阪府");
        add.put("Tel","1234-12-1234");
        add.put("E-Mail","osaka1@osaka.jp");
        add.put("Hobby","運動");
        addList.add(add);
        return addList;
    }

    private class ListItemClickListener implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> parent,View view,int position,long id){
            Map<String,String> item = (Map<String,String>) parent.getItemAtPosition(position);
            String name = item.get("Name");
            String address = item.get("Address");
            String tel = item.get("Tel");
            String mail = item.get("E-Mail");
            String hobby = item.get("Hobby");

            Intent intent = new Intent(AddressActivity.this,ResultActivity.class);
            intent.putExtra("Name",name);
            intent.putExtra("Address",address);
            intent.putExtra("Tel",tel);
            intent.putExtra("Mail",mail);
            intent.putExtra("Hobby",hobby);

            startActivity(intent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_options_menu_list,menu);
        return  super.onCreateOptionsMenu(menu);
    }

}
