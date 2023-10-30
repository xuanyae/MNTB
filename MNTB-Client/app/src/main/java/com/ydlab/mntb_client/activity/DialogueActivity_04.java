package com.ydlab.mntb_client.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ydlab.mntb_client.R;
import com.ydlab.mntb_client.adapter.DialogueActivity_04_Adapter;
import com.ydlab.mntb_client.bean.MajorInfo;
import com.ydlab.mntb_client.bean.ScoreInfo;
import com.ydlab.mntb_client.utils.HTTPUtils;
import com.ydlab.mntb_client.utils.SharedPreferencesUtils;
import com.ydlab.mntb_client.utils.SwitchUtils;

import java.util.ArrayList;
import java.util.List;

/*
    志愿推荐
 */
public class DialogueActivity_04 extends AppCompatActivity {
    private ListView listView_college;
    private ImageView imageView_next;
    private TextView textView_notes;
    private LottieAnimationView loading;
    private List<MajorInfo> recommend_major_info_list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogue_04);
        init(getIntent());
    }

    private void init(Intent intent) {
        listView_college = findViewById(R.id.listView_college);
        imageView_next = findViewById(R.id.imageView_next);
        textView_notes = findViewById(R.id.textView_notes);
        loading = findViewById(R.id.lottie_animation_view);

        imageView_next.setVisibility(View.GONE);
        loading.setVisibility(View.VISIBLE);
        textView_notes.setVisibility(View.VISIBLE);

        DialogueActivity_04_Adapter dialogueActivity_04_adapter = new DialogueActivity_04_Adapter(this, recommend_major_info_list);
        listView_college.setAdapter(dialogueActivity_04_adapter);

        new Thread(new Runnable() {
            @Override
            public void run() {
                String type = SharedPreferencesUtils.getString(getApplicationContext(), "type", "1");
                String total_score = SharedPreferencesUtils.getString(getApplicationContext(), "total_score", "540");
                String province_id = SharedPreferencesUtils.getString(getApplicationContext(), "province_id", "36");
                String major_field_code = SharedPreferencesUtils.getString(getApplicationContext(), "major_field_code", "08");

                String user_id = SharedPreferencesUtils.getString(getApplicationContext(), "user_id", "");
                String stage_id = SharedPreferencesUtils.getString(getApplicationContext(), "stage_id", "");
                String subject_score_1 = SharedPreferencesUtils.getString(getApplicationContext(), "subject_score_1", "");
                String subject_score_2 = SharedPreferencesUtils.getString(getApplicationContext(), "subject_score_2", "");
                String subject_score_3 = SharedPreferencesUtils.getString(getApplicationContext(), "subject_score_3", "");
                String subject_score_4 = SharedPreferencesUtils.getString(getApplicationContext(), "subject_score_4", "");
                String subject_score_5 = SharedPreferencesUtils.getString(getApplicationContext(), "subject_score_5", "");
                String subject_score_6 = SharedPreferencesUtils.getString(getApplicationContext(), "subject_score_6", "");
                String subject_score_7 = SharedPreferencesUtils.getString(getApplicationContext(), "subject_score_7", "");
                String subject_score_8 = SharedPreferencesUtils.getString(getApplicationContext(), "subject_score_8", "");
                String subject_score_9 = SharedPreferencesUtils.getString(getApplicationContext(), "subject_score_9", "");

                ScoreInfo scoreInfo = new ScoreInfo();
                scoreInfo.setUser_id(user_id);
                scoreInfo.setStage_id(stage_id);
                scoreInfo.setType(type);
                scoreInfo.setSubject_score_1(subject_score_1);
                scoreInfo.setSubject_score_2(subject_score_2);
                scoreInfo.setSubject_score_3(subject_score_3);
                scoreInfo.setSubject_score_4(subject_score_4);
                scoreInfo.setSubject_score_5(subject_score_5);
                scoreInfo.setSubject_score_6(subject_score_6);
                scoreInfo.setSubject_score_7(subject_score_7);
                scoreInfo.setSubject_score_8(subject_score_8);
                scoreInfo.setSubject_score_9(subject_score_9);
                scoreInfo.setTotal_score(total_score);
                HTTPUtils.doPost("/userStageScoreInfo/setUserStageScoreInfo", JSON.toJSONString(scoreInfo, true));

                JSONObject jsonObject_recommend_major_info_list = HTTPUtils.doGet("/majorScoreInfo/getMajorRecommend?type=" + type
                        + "&total_score=" + total_score + "&province_id=" + province_id + "&major_field_code=" + major_field_code);
                recommend_major_info_list.clear();
                recommend_major_info_list.addAll(JSON.parseArray(jsonObject_recommend_major_info_list.getString("data"), MajorInfo.class));
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        dialogueActivity_04_adapter.notifyDataSetChanged();
                        imageView_next.setVisibility(View.VISIBLE);
                        loading.setVisibility(View.GONE);
                        textView_notes.setVisibility(View.GONE);
                    }
                });
            }
        }).start();

        imageView_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user_id = SharedPreferencesUtils.getString(getApplicationContext(), "user_id", "");
                List<MajorInfo> majorInfoList = new ArrayList<>();
                int[] recommend_favorite_position = dialogueActivity_04_adapter.recommend_favorite_position;
                for (int i = 0; i < recommend_favorite_position.length; i++) {
                    System.out.println(recommend_favorite_position[i]);
                    if (recommend_favorite_position[i] == 1) {
                        MajorInfo majorInfo = recommend_major_info_list.get(i);
                        majorInfo.setUser_id(user_id);
                        majorInfoList.add(majorInfo);
                    }
                }
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        HTTPUtils.doPost("/userCollectionInfo/setUserCollectionInfo", JSON.toJSONString(majorInfoList, true));
                    }
                }).start();
                SwitchUtils.toSwitch(getApplicationContext(), intent.getStringExtra("next_dialogue_id"));
                overridePendingTransition(R.anim.activity_open_in_anim, R.anim.activity_close_out_anim);
            }
        });
    }

}
