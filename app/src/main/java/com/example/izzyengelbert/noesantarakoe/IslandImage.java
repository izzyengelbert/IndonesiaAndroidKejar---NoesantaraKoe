package com.example.izzyengelbert.noesantarakoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class IslandImage extends AppCompatActivity {

    Map<Integer,Integer> src = new HashMap<Integer,Integer>();
    ImageView img;
    TextView title;
    String[] titles = new String[8];
    int key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_island_image);
        initVariables();
        title.setText(titles[key]);
        img.setImageResource(src.get(key));
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent info = new Intent(IslandImage.this,Information.class);
                info.putExtra("key",key);
                startActivity(info);
            }
        });

    }

    public void initVariables(){
        key = getIntent().getExtras().getInt("key");
        img = (ImageView) findViewById(R.id.img);
        title = (TextView) findViewById(R.id.title);
        setSources();
    }

    public void setSources(){
        titles[0]=getString(R.string.sumatera);
        titles[1]=getString(R.string.kalimantan);
        titles[2]=getString(R.string.jawa);
        titles[3]=getString(R.string.bali_lombok);
        titles[4]=getString(R.string.kepulauan_nusa_tenggara);
        titles[5]=getString(R.string.sulawesi);
        titles[6]=getString(R.string.kepulauan_maluku);
        titles[7]=getString(R.string.irian_jaya);

        src.put(0,R.drawable.sumatera1);
        src.put(1,R.drawable.kalimantan1);
        src.put(2,R.drawable.jawa1);
        src.put(3,R.drawable.bali_lombok1);
        src.put(4,R.drawable.kepulauan_nusa_tenggara1);
        src.put(5,R.drawable.sulawesi1);
        src.put(6,R.drawable.kepulauan_maluku1);
        src.put(7,R.drawable.irian_jaya1);
    }
}
