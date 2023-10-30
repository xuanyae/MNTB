package com.ydlab.mntb_client.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.ydlab.mntb_client.R;

/*
    不在游戏时间内
 */
public class DialogueActivity_11 extends AppCompatActivity {
    private ImageView imageView_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogue_11);
        init();
    }

    public void init() {
        imageView_back = findViewById(R.id.imageView_back);
        imageView_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DialogueActivity_11.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
