package com.ydlab.mntb_client.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.ydlab.mntb_client.R;
import com.ydlab.mntb_client.utils.SwitchUtils;

/*
    询问是否已有中意的志愿
 */
public class DialogueActivity_08 extends AppCompatActivity {
    private TextView textView_next_1, textView_next_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogue_08);
        init(getIntent());
    }

    private void init(Intent intent) {
        textView_next_1 = findViewById(R.id.textView_next_1);
        textView_next_2 = findViewById(R.id.textView_next_2);

        textView_next_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SwitchUtils.toSwitch(getApplicationContext(), intent.getStringExtra("next_dialogue_id_1"));
                overridePendingTransition(R.anim.activity_open_in_anim, R.anim.activity_close_out_anim);
            }
        });

        textView_next_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SwitchUtils.toSwitch(getApplicationContext(), intent.getStringExtra("next_dialogue_id_2"));
                overridePendingTransition(R.anim.activity_open_in_anim, R.anim.activity_close_out_anim);
            }
        });
    }
}
