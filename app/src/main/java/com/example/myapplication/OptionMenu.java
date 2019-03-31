package com.example.myapplication;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import java.lang.reflect.Field;


public class OptionMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_menu);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.actionbar, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        EditText textView=findViewById(R.id.editText);
        switch (item.getItemId()) {
            case R.id.item1_1:
                textView.setTextSize(10);
                return true;
            case R.id.item1_2:
                textView.setTextSize(16);
                return true;
            case R.id.item1_3:
                textView.setTextSize(20);
                return true;
            case R.id.item2:
                Toast.makeText(OptionMenu.this,"普通菜单项",Toast.LENGTH_LONG).show(); ;
                return true;
            case R.id.item3_1:
                textView.setTextColor(Color.RED);
                return true;
            case R.id.item3_2:
                textView.setTextColor(Color.BLACK);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
