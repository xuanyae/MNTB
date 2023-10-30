package com.ydlab.mntb_client.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.alibaba.fastjson.JSON;
import com.ydlab.mntb_client.R;
import com.ydlab.mntb_client.adapter.DialogueActivity_05_Adapter;
import com.ydlab.mntb_client.bean.VolunteerInfo;
import com.ydlab.mntb_client.utils.HTTPUtils;
import com.ydlab.mntb_client.utils.SwitchUtils;

import java.util.ArrayList;
import java.util.List;

/*
    志愿填报
 */
public class DialogueActivity_05 extends AppCompatActivity {
    private ListView listView_volunteer;
    private ImageView imageView_next;
    private List<VolunteerInfo> volunteer_info_list = new ArrayList<>();
    private DialogueActivity_05_Adapter dialogueActivity_05_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogue_05);
        initData();
        init(getIntent());
    }

    private void init(Intent intent) {
        imageView_next = findViewById(R.id.imageView_next);
        listView_volunteer = findViewById(R.id.listView_volunteer);

        dialogueActivity_05_adapter = new DialogueActivity_05_Adapter(this, DialogueActivity_05.this, volunteer_info_list);
        listView_volunteer.setAdapter(dialogueActivity_05_adapter);

        imageView_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<VolunteerInfo> volunteer_info_list_final = dialogueActivity_05_adapter.volunteer_info_list;
                System.out.println(JSON.toJSONString(volunteer_info_list_final, true));
                List<VolunteerInfo> volunteerInfoList = new ArrayList<>();
                int volunteer_order_temp = 1;
                for (int i = 0; i < volunteer_info_list_final.size(); i++) {
                    VolunteerInfo volunteerInfo = volunteer_info_list_final.get(i);
                    if (volunteerInfo.getCollege_id() != null) {
                        volunteerInfo.setVolunteer_order(String.valueOf(volunteer_order_temp++));
                        volunteerInfo.setIs_adjust(volunteerInfo.getIs_adjust().equals("服从调剂") ? "1" : "0");
                        volunteerInfoList.add(volunteerInfo);
                    }
                }
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        HTTPUtils.doPost("/userStageVolunteerInfo/setUserStageVolunteer", JSON.toJSONString(volunteerInfoList, true));
                    }
                }).start();
                SwitchUtils.toSwitch(getApplicationContext(), intent.getStringExtra("next_dialogue_id"));
                overridePendingTransition(R.anim.activity_open_in_anim, R.anim.activity_close_out_anim);
            }
        });
    }

    private void initData() {
        for (int i = 0; i < 10; i++) {
            VolunteerInfo volunteer_info = new VolunteerInfo();
            volunteer_info.setTextView_add_or_delete("0");
            volunteer_info.setTextView_college_major_group("院校专业组" + (i + 1));
            volunteer_info_list.add(volunteer_info);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == 1) {
            int position = data.getIntExtra("position", 0);
            VolunteerInfo volunteer_info = (VolunteerInfo) data.getSerializableExtra("volunteer_Info");
            volunteer_info_list.get(position).setUser_id(volunteer_info.getUser_id());
            volunteer_info_list.get(position).setStage_id(volunteer_info.getStage_id());
            volunteer_info_list.get(position).setVolunteer_order(position + "");
            volunteer_info_list.get(position).setType(volunteer_info.getType());
            volunteer_info_list.get(position).setCollege_id(volunteer_info.getCollege_id());
            volunteer_info_list.get(position).setCollege_name(volunteer_info.getCollege_name());
            volunteer_info_list.get(position).setMajor_group_id(volunteer_info.getMajor_group_id());
            volunteer_info_list.get(position).setMajor_group_name(volunteer_info.getMajor_group_name());
            volunteer_info_list.get(position).setIs_adjust(volunteer_info.getIs_adjust().equals("1") ? "服从调剂" : "不服从调剂");
            volunteer_info_list.get(position).setMajor_name_1(volunteer_info.getMajor_name_1());
            volunteer_info_list.get(position).setMajor_notes_1(volunteer_info.getMajor_notes_1());
            volunteer_info_list.get(position).setMajor_name_2(volunteer_info.getMajor_name_2());
            volunteer_info_list.get(position).setMajor_notes_2(volunteer_info.getMajor_notes_2());
            volunteer_info_list.get(position).setMajor_name_3(volunteer_info.getMajor_name_3());
            volunteer_info_list.get(position).setMajor_notes_3(volunteer_info.getMajor_notes_3());
            volunteer_info_list.get(position).setMajor_name_4(volunteer_info.getMajor_name_4());
            volunteer_info_list.get(position).setMajor_notes_4(volunteer_info.getMajor_notes_4());
            volunteer_info_list.get(position).setMajor_name_5(volunteer_info.getMajor_name_5());
            volunteer_info_list.get(position).setMajor_notes_5(volunteer_info.getMajor_notes_5());
            volunteer_info_list.get(position).setMajor_name_6(volunteer_info.getMajor_name_6());
            volunteer_info_list.get(position).setMajor_notes_6(volunteer_info.getMajor_notes_6());
            volunteer_info_list.get(position).setTextView_add_or_delete("1");
            dialogueActivity_05_adapter.notifyDataSetChanged();
        }
    }
}
