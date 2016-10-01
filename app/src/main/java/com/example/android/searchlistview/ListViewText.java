package com.example.android.searchlistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class ListViewText extends AppCompatActivity {
    String[] items;
    ArrayList<String> listItems;
    ArrayAdapter<String> adapter;
    ListView listView;
   EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        listView = (ListView) findViewById(R.id.listview_ps);
        editText=(EditText)findViewById(R.id.txtsearch);
        initList();
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.toString().equals("")){
                    //reset listview
                    initList();
                }else {
                    searchItem(s.toString());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
    public void searchItem(String testToSearch){
        for(String item:items){
            if(!item.toLowerCase().startsWith(testToSearch.toLowerCase())){
                listItems.remove(item);
            }
        }
        adapter.notifyDataSetChanged();

    }

    public void initList(){
        items= new  String[]{"Canaa","China","Japan","Suomi","Ruotsi"};
        listItems=new ArrayList<>(Arrays.asList(items));
        adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.txt_item, listItems);
        listView.setAdapter(adapter);

    }
}
