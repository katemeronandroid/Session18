package com.emarkova.session18;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.emarkova.session18.data.model.Image;
import com.emarkova.session18.data.model.ImageList;
import com.emarkova.session18.recycler.CustomAdapter;
import com.emarkova.session18.recycler.ItemType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final  String FILTER = "emarkova.GET_IMAGE";
    private static final String KEY = "image";
    private CustomBroadcastReciever mReciever;
    private IntentFilter mFilter;
    RecyclerView mRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mReciever = new CustomBroadcastReciever();
        mFilter = new IntentFilter(FILTER);
        Intent intent = new Intent(MainActivity.this, ImageService.class);
        startService(intent);
        mRecycler = (RecyclerView) findViewById(R.id.my_recycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false);
        mRecycler.setLayoutManager(linearLayoutManager);
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(mReciever,mFilter);
    }

    private class CustomBroadcastReciever extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            Bundle bundle = intent.getBundleExtra(KEY);
            ImageList imageList = (ImageList) bundle.getSerializable(KEY);
            Log.d("Logs", "get");
            List<ImageItemType> typeList = getTypeList();
            CustomAdapter adapter = new CustomAdapter(imageList.getImageList(), typeList);
            mRecycler.setAdapter(adapter);
        }
    }

    private List<ImageItemType> getTypeList() {
        Integer[] types = {1,3,2,4,2,1,3,4,1,2};//{1,3,1,1,1,1,1,1,1,1};//{4,4,4,4,4,4,4,4,4,4};//{3,3,3,3,3,3,3,3,3,3};//{2,2,2,2,2,2,2,2,2,2};
        List<Integer> preresult = Arrays.asList(types);
        List<ImageItemType> result = new ArrayList<>(10);

        for(int i = 0; i < preresult.size(); i++){
            result.add(new ImageItemType(preresult.get(i)));
        }
        return result;
    }
}
