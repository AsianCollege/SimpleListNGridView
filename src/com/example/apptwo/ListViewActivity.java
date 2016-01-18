package com.example.apptwo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListViewActivity extends Activity{
	
	private ListView listview;
	private String[] items;

	@Override
	public void onCreate(Bundle savedInstaneState){
		super.onCreate(savedInstaneState);
		setContentView(R.layout.activity_listview);
		listview = (ListView)findViewById(R.id.listView);
		items = new String[]{
				"Item 1",
				"Item 2",
				"Item 3",
				"Item 4",
				"Item 5",
				"Item 6",
				"Item 7",
				"Item 8",
				"Item 9",
				"Item 10",
				"Item 11",
				"Item 12"
		};
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, items);
		listview.setAdapter(adapter);
		

  
	}
}
