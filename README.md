# UI_component
实验三：UI组件

## 1）ListView的用法

利用SimpleAdapter实现界面效果，使用Toast显示按钮信息

### 截图

![](https://i.loli.net/2019/03/31/5ca04829e4b94.png)

### 相关步骤及代码

``

```
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
```

``

```
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="horizontal"
    tools:context=".Listview">

    <ListView
        android:id="@+id/listView"
        android:layout_width="match_parent"
        android:layout_height="match_parent">

    </ListView>



</LinearLayout>
```

``

```
<RelativeLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:paddingLeft="20dp"
    android:paddingRight="20dp"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="horizontal">

    <TextView
        android:layout_marginTop="10dp"
        android:layout_marginBottom="10dp"
        android:id="@+id/items_textView1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content" />

    <ImageView
        android:id="@+id/items_imageview1"
        android:layout_width="40dp"
        android:layout_height="40dp"
    android:layout_alignParentRight="true"/>
</RelativeLayout>
```

## 2）创建自定义布局的AlertDialog

### 截图

![](https://i.loli.net/2019/03/31/5ca04b1ba7f31.png)

### 相关步骤及代码

``

```
public class ADialogFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstancState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(inflater.inflate(R.layout.activity_alertdialog, null))
                // Add action buttons
                .setPositiveButton(R.string.sign_in, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // sign in the user ...
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        ADialogFragment.this.getDialog().cancel();
                    }
                });
        return builder.create();
    }
}
```

``

```
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content">
    <ImageView
        android:src="@drawable/header_logo"
        android:layout_width="match_parent"
        android:layout_height="64dp"
        android:scaleType="center"
        android:contentDescription="@string/app_name" />
    <EditText
        android:id="@+id/username"
        android:inputType="textEmailAddress"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="16dp"
        android:layout_marginLeft="4dp"
        android:layout_marginRight="4dp"
        android:layout_marginBottom="4dp"
        android:hint="@string/username"
        />
    <EditText
        android:id="@+id/password"
        android:inputType="textPassword"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="4dp"
        android:layout_marginLeft="4dp"
        android:layout_marginRight="4dp"
        android:layout_marginBottom="16dp"
        android:fontFamily="sans-serif"
        android:hint="@string/password"/>
</LinearLayout>
```

## 3）使用XML定义菜单

### 截图

![](https://i.loli.net/2019/03/31/5ca04aef5cb32.png)

### 相关步骤及代码

``

```
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
```

``

```
<android.support.constraint.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent">


    <EditText
        android:id="@+id/editText"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="16dp"
        android:layout_marginLeft="16dp"
        android:layout_marginTop="16dp"
        android:layout_marginEnd="8dp"
        android:layout_marginRight="8dp"
        android:ems="10"
        android:inputType="text"
        android:text="用于测试的内容"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.137"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
</android.support.constraint.ConstraintLayout>
```

## 4）创建上下文操作模式的上下文菜单

### 截图

![](https://i.loli.net/2019/03/31/5ca04c1d38c2c.png)![](https://i.loli.net/2019/03/31/5ca04c3858b1d.png)

### 相关步骤和代码

``

```
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
```

``

```
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="horizontal">
        <ListView
            android:id="@+id/listView2"
            android:layout_width="match_parent"
            android:layout_height="match_parent">

        </ListView>

</LinearLayout>
```

``

```
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingLeft="20dp"
    android:paddingRight="20dp"
    android:orientation="horizontal">

    <ImageView
        android:layout_marginLeft="20dp"
        android:id="@+id/items_imageview2"
        android:layout_width="80dp"
        android:layout_height="80dp"
        />

    <TextView
        android:layout_marginLeft="120dp"
        android:layout_marginTop="30dp"
        android:layout_marginBottom="30dp"
        android:id="@+id/items_textView2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content" />




</RelativeLayout>
```
