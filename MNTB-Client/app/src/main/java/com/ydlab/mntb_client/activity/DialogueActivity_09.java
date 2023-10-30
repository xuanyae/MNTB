package com.ydlab.mntb_client.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.ydlab.mntb_client.R;
import com.ydlab.mntb_client.utils.HTTPUtils;
import com.ydlab.mntb_client.utils.SharedPreferencesUtils;
import com.ydlab.mntb_client.utils.SwitchUtils;

/*
    咨询选择界面
 */
public class DialogueActivity_09 extends AppCompatActivity {
    private TextView textView_question_1, textView_question_2, textView_question_3, textView_question_4;
    private ImageView imageView_next;
    private String collegeName, majorName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogue_09);
        init(getIntent());
    }

    private void init(Intent intent) {
        textView_question_1 = findViewById(R.id.textView_question_1);
        textView_question_2 = findViewById(R.id.textView_question_2);
        textView_question_3 = findViewById(R.id.textView_question_3);
        textView_question_4 = findViewById(R.id.textView_question_4);
        imageView_next = findViewById(R.id.imageView_next);

        textView_question_1.setVisibility(View.GONE);
        textView_question_2.setVisibility(View.GONE);
        textView_question_3.setVisibility(View.GONE);
        textView_question_4.setVisibility(View.GONE);

        new Thread(new Runnable() {
            @Override
            public void run() {
                String stage_id = SharedPreferencesUtils.getString(getApplicationContext(), "stage_id", "2");
                String user_id = SharedPreferencesUtils.getString(getApplicationContext(), "user_id", "1");
                JSONObject jsonObject_AdmissionInfo = HTTPUtils.doGet("/majorScoreInfo/getAdmissionInfo?stage_id=" + stage_id + "&user_id=" + user_id);
                collegeName = (String) jsonObject_AdmissionInfo.get("collegeName");
                majorName = (String) jsonObject_AdmissionInfo.get("majorName");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textView_question_1.setVisibility(View.VISIBLE);
                        textView_question_2.setVisibility(View.VISIBLE);
                        textView_question_3.setVisibility(View.VISIBLE);
                        textView_question_4.setVisibility(View.VISIBLE);
                    }
                });
            }
        }).start();

        textView_question_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_1 = new Intent(DialogueActivity_09.this, DialogueActivity_10.class);
                intent_1.putExtra("question", "100字内介绍一下" + collegeName);
                intent_1.putExtra("npc_id", "6");
                startActivity(intent_1);
            }
        });

        textView_question_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_2 = new Intent(DialogueActivity_09.this, DialogueActivity_10.class);
                intent_2.putExtra("question", "假设你是一名" + collegeName + majorName + "专业的学生，请你介绍一下你四年的学习经历");
                intent_2.putExtra("npc_id", "5");
                startActivity(intent_2);
            }
        });

        textView_question_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_3 = new Intent(DialogueActivity_09.this, DialogueActivity_10.class);
                intent_3.putExtra("question", "假设你是一名已经毕业三年的大学生，大学学的是" + majorName + "专业，谈一谈这个专业的就业前景");
                intent_3.putExtra("npc_id", "4");
                startActivity(intent_3);
            }
        });

        textView_question_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_3 = new Intent(DialogueActivity_09.this, DialogueActivity_10.class);
                intent_3.putExtra("question", "介绍一下" + majorName + "专业未来的发展趋势");
                intent_3.putExtra("npc_id", "6");
                startActivity(intent_3);
            }
        });

        imageView_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SwitchUtils.toSwitch(getApplicationContext(), intent.getStringExtra("next_dialogue_id"));
                overridePendingTransition(R.anim.activity_open_in_anim, R.anim.activity_close_out_anim);
            }
        });
    }

}
