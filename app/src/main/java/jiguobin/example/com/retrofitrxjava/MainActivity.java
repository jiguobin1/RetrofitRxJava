package jiguobin.example.com.retrofitrxjava;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import me.nereo.multi_image_selector.MultiImageSelector;
import me.nereo.multi_image_selector.MultiImageSelectorActivity;


public class MainActivity extends AppCompatActivity {

    private RecyclerView recy;

    private static final int REQUEST_IMAGE = 1001;

    private MyAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recy = (RecyclerView) findViewById(R.id.recy);
        recy.setLayoutManager(new LinearLayoutManager(MainActivity.this));

    }

    public void abc(View view) {
//
//        MultiImageSelector.create()
//                .start(MainActivity.this, REQUEST_IMAGE);
        MultiImageSelector.create()
                .showCamera(true) //显示相机or不显示相机
                .count(9) //最多显示多少照片
                .multi()//加上.single为单选，不加为多选
                .start(MainActivity.this, REQUEST_IMAGE);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE) {
            if (resultCode == RESULT_OK) {
                List<String> path = data.getStringArrayListExtra(MultiImageSelectorActivity.EXTRA_RESULT);
                adapter=new MyAdapter(MainActivity.this,path);
                recy.setAdapter(adapter);
            }
        }


    }
}
