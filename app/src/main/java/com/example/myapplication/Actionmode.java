package com.example.myapplication;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Actionmode extends AppCompatActivity {

    private ListView listView2;
    private String[] name={"One","Two","Three","Four","Five","Six"};
    private int[] images={R.drawable.sculpture,R.drawable.sculpture,R.drawable.sculpture,R.drawable.sculpture,R.drawable.sculpture,R.drawable.sculpture};


    private List<Map<String,Object>> list_map=new ArrayList<Map<String, Object>>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actionmode);

        listView2=findViewById(R.id.listView2);

        for(int i=0;i<6;i++){
            Map<String,Object> items=new HashMap<String,Object>();
            items.put("pic",images[i]);
            items.put("name",name[i]);
            items.put("checked",false);
            list_map.add(items);
        }

        final SimpleAdapter simpleAdapter=new SimpleAdapter(Actionmode.this,list_map,R.layout.itemslayout2,new String[]{"pic","name"},new int[]{R.id.items_imageview2,R.id.items_textView2});
        listView2.setAdapter(simpleAdapter);
        listView2.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);

        listView2.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            int i=0;
            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
                list_map.get(position).put("checked",checked);
                if(checked){
                    View v=listView2.getChildAt(position);
                    v.setBackgroundColor(Color.GREEN);
                    i++;
                }
                else{
                    View v=listView2.getChildAt(position);
                    v.setBackgroundColor(Color.WHITE);
                    i--;
                }
                mode.setTitle(i+" selected");

            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                mode.getMenuInflater().inflate(R.menu.actionnode_menu,menu);
//                simpleAdapter.notifyDataSetChanged();

                mode.setTitle(i+" selected");
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                if(item.getItemId()==R.id.delete){
                    int num=0;
                    Iterator it=list_map.iterator();
                    while(it.hasNext()){
                        Map map=(Map) it.next();
                        if((Boolean)map.get("checked")){
                            View v=listView2.getChildAt(num);
                            v.setBackgroundColor(Color.WHITE);
                            i--;
                            it.remove();
                        }
                        num++;
                    }
                   simpleAdapter.notifyDataSetChanged();
                }
                mode.finish();
                return true;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {
                simpleAdapter.notifyDataSetChanged();
            }
        });


    }
}
