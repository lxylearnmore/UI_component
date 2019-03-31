package com.example.myapplication;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Listview extends AppCompatActivity {

    private ListView listView;//定义ListView对象，用来获取布局文件中的ListView控件
    private String[] name={"Lion","Tiger","Monkey","Dog","Cat","Elephant"};
    private int[] images={R.drawable.lion,R.drawable.tiger,R.drawable.monkey,R.drawable.dog,R.drawable.cat,R.drawable.elephant};

    private List<Map<String,Object>> list_map=new ArrayList<Map<String,Object>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        listView=(ListView)findViewById(R.id.listView);

        for(int i=0;i<6;i++){
            Map<String,Object> items=new HashMap<String,Object>();

            items.put("name",name[i]);
            items.put("pic",images[i]);

            list_map.add(items);
        }

        SimpleAdapter simpleAdapter=new SimpleAdapter(Listview.this,list_map,R.layout.itemslayout,new String[]{"name","pic"},new int[]{R.id.items_textView1,R.id.items_imageview1});
        listView.setAdapter(simpleAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast toast=Toast.makeText(Listview.this,name[position],Toast.LENGTH_LONG);
                toast.show();
                for(int i=0;i<parent.getCount();i++){
                    View v=parent.getChildAt(i);
                    if(position==i){
                        v.setBackgroundColor(Color.RED);
                    }else{
                        v.setBackgroundColor(Color.TRANSPARENT);
                    }
                }
            }
        });
    }


}
