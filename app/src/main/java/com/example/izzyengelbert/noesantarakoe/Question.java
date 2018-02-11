package com.example.izzyengelbert.noesantarakoe;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.icu.text.IDNA;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class Question extends AppCompatActivity {

    Button map,answerBtn,infoBtn;
    int key;
    Map<Integer,Integer> src = new HashMap<Integer,Integer>();
    TextView questionText;
    ImageView island;
    CheckBox check1,check2,check3;
    String[][] choices = new String[8][3];
    String[] answer = question = new String[8];
    String[] question = new String[8];
    int index=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_question);
        initVariables();
        questionText.setText(question[key]);
        island.setImageResource(src.get(key));
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        answerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(index==1){
                    if(check1.getText().equals(answer[key])&&check1.isChecked()){
                        Toast.makeText(getApplicationContext(),"Anda benar!",Toast.LENGTH_SHORT).show();
                        infoBtn.setEnabled(true);
                    }else if(check2.getText().equals(answer[key])&&check2.isChecked()){
                        Toast.makeText(getApplicationContext(),"Anda benar!",Toast.LENGTH_SHORT).show();
                        infoBtn.setEnabled(true);
                    }else if(check3.getText().equals(answer[key])&&check3.isChecked()){
                        Toast.makeText(getApplicationContext(),"Anda benar!",Toast.LENGTH_SHORT).show();
                        infoBtn.setEnabled(true);
                    }else{
                        Toast.makeText(getApplicationContext(),"Salah!!!",Toast.LENGTH_SHORT).show();
                    }

                }else{
                    Toast.makeText(getApplicationContext(),"Pilih salah satu jawaban!",Toast.LENGTH_SHORT).show();
                }
            }
        });
        infoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent info = new Intent(Question.this, IslandImage.class);
                info.putExtra("key",key);
                startActivity(info);
            }
        });
    }

    public void initVariables(){
        key = getIntent().getExtras().getInt("key");

        check1 = (CheckBox) findViewById(R.id.answer0);
        check2 = (CheckBox) findViewById(R.id.answer1);
        check3 = (CheckBox) findViewById(R.id.answer2);

        map = (Button) findViewById(R.id.mapbtn);
        answerBtn = (Button) findViewById(R.id.answerbtn);
        infoBtn = (Button) findViewById(R.id.info);
        infoBtn.setEnabled(false);
        questionText = (TextView) findViewById(R.id.question);
        island = (ImageView) findViewById(R.id.island);
        setSourceImage();
        setQuestionAndAnswer();
        setChoicesPossibility();
        setChoices();
    }

    public void setChoicesPossibility(){
        if(key==0||key==1||key==2){
            choices[key][0]=answer[0];
            choices[key][1]=answer[1];
            choices[key][2]=answer[2];
        }
        if(key==3||key==4||key==6) {
            choices[key][0] = answer[3];
            choices[key][1] = answer[4];
            choices[key][2] = answer[6];
        }
        if(key==5){
            choices[key][0] = answer[6];
            choices[key][1] = answer[5];
            choices[key][2] = answer[4];
        }
        if(key==7){
            choices[key][0] = answer[5];
            choices[key][1] = answer[0];
            choices[key][2] = answer[7];
        }
    }

    public void setChoices(){
            check1.setText(choices[key][0]);
            check2.setText(choices[key][1]);
            check3.setText(choices[key][2]);
    }

    public void setQuestionAndAnswer(){
        for(int i=0;i<8;++i){
            if (i==3||i==4||i==6) {
                question[i] = getString(R.string.question1);
            }else{
                question[i] = getString(R.string.question2);
            }
        }
        answer[0]=getString(R.string.sumatera);
        answer[1]=getString(R.string.kalimantan);
        answer[2]=getString(R.string.jawa);
        answer[3]=getString(R.string.bali_lombok);
        answer[4]=getString(R.string.kepulauan_nusa_tenggara);
        answer[5]=getString(R.string.sulawesi);
        answer[6]=getString(R.string.kepulauan_maluku);
        answer[7]=getString(R.string.irian_jaya);
    }

    public void setSourceImage(){
        src.put(0,R.drawable.sumatera);
        src.put(1,R.drawable.kalimantan);
        src.put(2,R.drawable.jawa);
        src.put(3,R.drawable.bali_lombok);
        src.put(4,R.drawable.kepulauan_nusa_tenggara);
        src.put(5,R.drawable.sulawesi);
        src.put(6,R.drawable.kepulauan_maluku);
        src.put(7,R.drawable.irian_jaya);
    }
    public void checkOne(View v){
        CheckBox c = (CheckBox)v;
        if(c.isChecked()){
            ++index;
        }else{
            if(index!=0){
                --index;
            }else {
                index = 0;
            }
        }
    }

    public void checkTwo(View v){
        CheckBox c = (CheckBox)v;
        if(c.isChecked()){
            ++index;
        }else{
            if(index!=0){
                --index;
            }else{
                index=0;
            }
        }
    }

    public void checkThree(View v){
        CheckBox c = (CheckBox)v;
        if(c.isChecked()){
            ++index;
        }else{
            if(index!=0){
                --index;
            }else{
                index=0;
            }
        }
    }

}
