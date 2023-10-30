package com.ydlab.mntb_client.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.ydlab.mntb_client.R;
import com.ydlab.mntb_client.utils.HTTPUtils;
import com.ydlab.mntb_client.utils.SharedPreferencesUtils;

public class MainActivity extends AppCompatActivity {
    private TextView textView_begin;
    private String user_id, stage_id, stage_id_now;
    private boolean is_start = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView_begin = findViewById(R.id.textView_begin);
        user_id = SharedPreferencesUtils.getString(getApplicationContext(), "user_id", "");
        stage_id = SharedPreferencesUtils.getString(getApplicationContext(), "stage_id", "");

        if (user_id.equals("")) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    JSONObject jsonObject_user_id = HTTPUtils.doGet("/userInfo/getUserId");
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            user_id = (String) jsonObject_user_id.get("data");
                            SharedPreferencesUtils.putString(getApplicationContext(), "user_id", user_id);
                        }
                    });
                }
            }).start();
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                JSONObject jsonObject_stage_id = HTTPUtils.doGet("/stageInfo/getStageId");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        stage_id_now = (String) jsonObject_stage_id.get("data");
                        SharedPreferencesUtils.putString(getApplicationContext(), "stage_id", stage_id_now);
                        if (stage_id_now != null) {
                            is_start = true;
                            if (stage_id.equals(stage_id_now)) {
                                textView_begin.setText("重玩本轮");
                            }
                        } else {
                            is_start = false;
                        }
                    }
                });
            }
        }).start();

        textView_begin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        JSONObject jsonObject_dialogueInfo = HTTPUtils.doGet("/dialogueInfo/getStageFirstDialogueInfo?stage_id=" + stage_id_now);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (is_start) {
                                    Intent intent = new Intent(MainActivity.this, DialogueActivity_01.class);
                                    JSONObject jsonObject_dialogueInfo_data = JSONObject.parseObject(jsonObject_dialogueInfo.get("data").toString());
                                    intent.putExtra("dialogue_content", (String) jsonObject_dialogueInfo_data.get("dialogueContent"));
                                    intent.putExtra("npc_id", (String) jsonObject_dialogueInfo_data.get("npcId"));
                                    intent.putExtra("loading_time", (String) jsonObject_dialogueInfo_data.get("dialogueWaitingTime"));
                                    intent.putExtra("dialogue_extras_content", (String) jsonObject_dialogueInfo_data.get("dialogueExtrasContent"));
                                    intent.putExtra("next_dialogue_id", (String) jsonObject_dialogueInfo_data.get("nextDialogueId"));
                                    intent.putExtra("dialogue_id", (String) jsonObject_dialogueInfo_data.get("dialogueId"));
                                    intent.putExtra("dialogue_flag", (String) jsonObject_dialogueInfo_data.get("dialogueFlag"));
                                    startActivity(intent);
                                    overridePendingTransition(R.anim.activity_open_in_anim, R.anim.activity_close_out_anim);
                                } else {
                                    Intent intent = new Intent(MainActivity.this, DialogueActivity_11.class);
                                    startActivity(intent);
                                    overridePendingTransition(R.anim.activity_open_in_anim, R.anim.activity_close_out_anim);
                                }
                            }
                        });
                    }
                }).start();
            }
        });
    }
}
