package com.example.gamis214.customanimation_recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private RecyclerView myList;
    private Button btnReload;
    private Spinner spinner;
    private List<Integer> list = new ArrayList<>();

    private static final int FALL_DOWN = 0, SLIDE_FROM_RIGHT = 1, SLIDE_FROM_BOTTOM = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myList      = (RecyclerView) findViewById(R.id.myList);
        btnReload   = (Button) findViewById(R.id.btnReload);
        spinner     = (Spinner) findViewById(R.id.spinner);

        myList.setHasFixedSize(true);
        myList.setLayoutManager(new LinearLayoutManager(this));

        for (int i = 0; i < 30; i++){
            list.add(i);
        }

        myList.setAdapter(new MyAdapter(list));

        btnReload.setOnClickListener(this);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                changeAnimationRecycler(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnReload:
                myList.getAdapter().notifyDataSetChanged();
                myList.scheduleLayoutAnimation();
                break;
        }
    }

    private void changeAnimationRecycler(int type){
        int animation = 0;
        switch (type){
            case FALL_DOWN:
                animation = R.anim.layout_animation_fall_down;
                break;
            case SLIDE_FROM_RIGHT:
                animation = R.anim.layout_animation_slide_from_right;
                break;
            case SLIDE_FROM_BOTTOM:
                animation = R.anim.layout_animation_slide_from_bottom;
                break;
        }

        LayoutAnimationController animationController =
                AnimationUtils.loadLayoutAnimation(this,animation);

        myList.setLayoutAnimation(animationController);
        myList.getAdapter().notifyDataSetChanged();
        myList.scheduleLayoutAnimation();
    }
}
