package com.example.ecommerce;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class Toplist extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toplist);
        getWindow().setFlags(512, 512);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_list);
        List<item> mlist = new ArrayList();
        mlist.add(new item(R.drawable.shop8, "Shop1", R.drawable.own6, 9));
        mlist.add(new item(R.drawable.shop8, "Shop2", R.drawable.own6, 7));
        mlist.add(new item(R.drawable.shop8, "Shop3", R.drawable.own6, 9));
        mlist.add(new item(R.drawable.shop8, "Shop4", R.drawable.own6, 6));
        mlist.add(new item(R.drawable.shop8, "Shop5", R.drawable.own6, 10));
        mlist.add(new item(R.drawable.shop8, "Shop6", R.drawable.own6, 8));
        mlist.add(new item(R.drawable.shop8, "Shop7", R.drawable.own6, 9));
        mlist.add(new item(R.drawable.shop8, "Shop8", R.drawable.own6, 9));
        mlist.add(new item(R.drawable.shop8, "Shop9", R.drawable.own6, 7));
        mlist.add(new item(R.drawable.shop8, "Shop10", R.drawable.own6, 10));
        recyclerView.setAdapter(new Adapter(this, mlist));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
