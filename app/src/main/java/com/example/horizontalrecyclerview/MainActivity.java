package com.example.horizontalrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Adapter adapter;
    RecyclerView recyclerView;
    ArrayList<String> arrayList;

    String title[] = {"Discover Recommended Games 1","Discover Recommended Games 2","Discover Recommended Games 3","Discover Recommended Games 4"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayList=new ArrayList<>();
        recyclerView=findViewById(R.id.recyclerview);


        for (int i=0;i<title.length;i++){

            arrayList.add(title[i]);

        }
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        adapter=new Adapter(this,arrayList);
        recyclerView.setAdapter(adapter);

        adapter.notifyDataSetChanged();
    }
}
