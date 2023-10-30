package com.ydlab.mntb_client.utils;

import android.content.Context;
import android.content.Intent;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ydlab.mntb_client.activity.DialogueActivity_01;
import com.ydlab.mntb_client.activity.DialogueActivity_02;
import com.ydlab.mntb_client.activity.DialogueActivity_03;
import com.ydlab.mntb_client.activity.DialogueActivity_04;
import com.ydlab.mntb_client.activity.DialogueActivity_05;
import com.ydlab.mntb_client.activity.DialogueActivity_07;
import com.ydlab.mntb_client.activity.DialogueActivity_08;
import com.ydlab.mntb_client.activity.DialogueActivity_09;
import com.ydlab.mntb_client.ipojo.iAdmissionInfo;
import com.ydlab.mntb_client.ipojo.iDialogueJudgmentInfo;

import java.util.List;

public class SwitchUtils {

    public static void toSwitch(Context context, String next_dialogue_id) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                JSONObject jsonObject_dialogueInfo_next = HTTPUtils.doGet("/dialogueInfo/getDialogueInfo?dialogue_id=" + next_dialogue_id);
                JSONObject jsonObject_dialogueInfo_next_data = JSONObject.parseObject(jsonObject_dialogueInfo_next.get("data").toString());
                String dialogue_page_id = (String) jsonObject_dialogueInfo_next_data.get("dialoguePageId");
                switch (dialogue_page_id) {
                    case "1":
                        Intent intent_1 = new Intent(context, DialogueActivity_01.class);

                        String dialogueContent = (String) jsonObject_dialogueInfo_next_data.get("dialogueContent");
                        String dialogueInf_fill_id = (String) jsonObject_dialogueInfo_next_data.get("dialogueFillId");
                        if (dialogueInf_fill_id != null) {
                            switch (dialogueInf_fill_id) {
                                case "1":
                                    String type = SharedPreferencesUtils.getString(context, "type", "1");
                                    JSONObject jsonObject_ScoreLine = HTTPUtils.doGet("/scoreLineInfo/getScoreLine?type=" + type);
                                    String score_line = (String) jsonObject_ScoreLine.get("data");
                                    dialogueContent = String.format(dialogueContent, type.equals("1") ? "物理" : "历史", score_line);
                                    break;
                                case "2":
                                    String stage_id_2 = SharedPreferencesUtils.getString(context, "stage_id", "2");
                                    String user_id_2 = SharedPreferencesUtils.getString(context, "user_id", "1");
                                    JSONObject jsonObject_AdmissionInfo_2 = HTTPUtils.doGet("/majorScoreInfo/getAdmissionInfo?stage_id=" + stage_id_2 + "&user_id=" + user_id_2);
                                    String collegeName_2 = (String) jsonObject_AdmissionInfo_2.get("collegeName");
                                    String groupScoreMin_2 = (String) jsonObject_AdmissionInfo_2.get("groupScoreMin");
                                    dialogueContent = String.format(dialogueContent, collegeName_2, groupScoreMin_2);
                                    break;
                                case "3":
                                    String stage_id_3 = SharedPreferencesUtils.getString(context, "stage_id", "2");
                                    String user_id_3 = SharedPreferencesUtils.getString(context, "user_id", "1");
                                    JSONObject jsonObject_AdmissionInfo_3 = HTTPUtils.doGet("/majorScoreInfo/getAdmissionInfo?stage_id=" + stage_id_3 + "&user_id=" + user_id_3);
                                    String collegeName_3 = (String) jsonObject_AdmissionInfo_3.get("collegeName");
                                    String majorName_3 = (String) jsonObject_AdmissionInfo_3.get("majorName");
                                    String majorNotes_3 = (String) jsonObject_AdmissionInfo_3.get("majorNotes");
                                    String majorScoreMin_3 = (String) jsonObject_AdmissionInfo_3.get("majorScoreMin");
                                    dialogueContent = String.format(dialogueContent, collegeName_3, majorName_3 + majorNotes_3, majorScoreMin_3);
                                    break;
                            }
                        }

                        String nextDialogueId = (String) jsonObject_dialogueInfo_next_data.get("nextDialogueId");
                        String dialogueJudgmentId = (String) jsonObject_dialogueInfo_next_data.get("dialogueJudgmentId");
                        if (dialogueJudgmentId != null) {
                            List<iDialogueJudgmentInfo> dialogueJudgmentInfoList = JSON.parseArray((String) jsonObject_dialogueInfo_next_data.get("dialogueJudgmentInfoList"), iDialogueJudgmentInfo.class);
                            if (dialogueJudgmentId.equals("1") ||
                                    dialogueJudgmentId.equals("4") ||
                                    dialogueJudgmentId.equals("7") ||
                                    dialogueJudgmentId.equals("11") ||
                                    dialogueJudgmentId.equals("15") ||
                                    dialogueJudgmentId.equals("19") ||
                                    dialogueJudgmentId.equals("23") ||
                                    dialogueJudgmentId.equals("27") ||
                                    dialogueJudgmentId.equals("31")) {
                                String total_score = SharedPreferencesUtils.getString(context, "total_score", "0");
                                String user_id = SharedPreferencesUtils.getString(context, "user_id", "1");
                                String stage_id = SharedPreferencesUtils.getString(context, "stage_id", "2");
                                String type = SharedPreferencesUtils.getString(context, "type", "1");
                                JSONObject jsonObject_VolunteerIsSet = HTTPUtils.doGet("/userStageVolunteerInfo/getVolunteerIsSet?user_id=" + user_id + "&stage_id=" + stage_id);
                                String volunteer_is_set = (String) jsonObject_VolunteerIsSet.get("data");
                                JSONObject jsonObject_ScoreLine = HTTPUtils.doGet("/scoreLineInfo/getScoreLine?type=" + type);
                                String score_line = (String) jsonObject_ScoreLine.get("data");
                                if (volunteer_is_set.equals("1")) {
                                    if (Integer.parseInt(total_score) >= Integer.parseInt(score_line)) {
                                        nextDialogueId = dialogueJudgmentInfoList.get(0).getDialogueJudgmentNextDialogueId();
                                    } else {
                                        nextDialogueId = dialogueJudgmentInfoList.get(1).getDialogueJudgmentNextDialogueId();
                                    }
                                } else {
                                    nextDialogueId = dialogueJudgmentInfoList.get(2).getDialogueJudgmentNextDialogueId();
                                }
                            }

                            if (dialogueJudgmentId.equals("2") ||
                                    dialogueJudgmentId.equals("5") ||
                                    dialogueJudgmentId.equals("8") ||
                                    dialogueJudgmentId.equals("12") ||
                                    dialogueJudgmentId.equals("16") ||
                                    dialogueJudgmentId.equals("20") ||
                                    dialogueJudgmentId.equals("24") ||
                                    dialogueJudgmentId.equals("28") ||
                                    dialogueJudgmentId.equals("32")) {
                                String user_id = SharedPreferencesUtils.getString(context, "user_id", "1");
                                String stage_id = SharedPreferencesUtils.getString(context, "stage_id", "2");
                                JSONObject jsonObject_AdmissionInfo = HTTPUtils.doGet("/majorScoreInfo/getAdmissionInfo?user_id=" + user_id + "&stage_id=" + stage_id);
                                iAdmissionInfo i_iAdmissionInfo = JSON.parseObject((String) jsonObject_AdmissionInfo.get("data"), iAdmissionInfo.class);
                                if (i_iAdmissionInfo.getCollegeName() != null) {
                                    nextDialogueId = dialogueJudgmentInfoList.get(0).getDialogueJudgmentNextDialogueId();
                                } else {
                                    nextDialogueId = dialogueJudgmentInfoList.get(1).getDialogueJudgmentNextDialogueId();
                                }
                            }

                            if (dialogueJudgmentId.equals("3") ||
                                    dialogueJudgmentId.equals("6") ||
                                    dialogueJudgmentId.equals("9") ||
                                    dialogueJudgmentId.equals("13") ||
                                    dialogueJudgmentId.equals("17") ||
                                    dialogueJudgmentId.equals("21") ||
                                    dialogueJudgmentId.equals("25") ||
                                    dialogueJudgmentId.equals("29") ||
                                    dialogueJudgmentId.equals("33")) {
                                String user_id = SharedPreferencesUtils.getString(context, "user_id", "1");
                                String stage_id = SharedPreferencesUtils.getString(context, "stage_id", "2");
                                JSONObject jsonObject_AdmissionInfo = HTTPUtils.doGet("/majorScoreInfo/getAdmissionInfo?user_id=" + user_id + "&stage_id=" + stage_id);
                                iAdmissionInfo i_iAdmissionInfo = JSON.parseObject((String) jsonObject_AdmissionInfo.get("data"), iAdmissionInfo.class);
                                if (i_iAdmissionInfo.getMajorName() != null) {
                                    nextDialogueId = dialogueJudgmentInfoList.get(0).getDialogueJudgmentNextDialogueId();
                                } else {
                                    nextDialogueId = dialogueJudgmentInfoList.get(1).getDialogueJudgmentNextDialogueId();
                                }
                            }
                        }

                        intent_1.putExtra("dialogue_content", dialogueContent);
                        intent_1.putExtra("next_dialogue_id", nextDialogueId);
                        intent_1.putExtra("npc_id", (String) jsonObject_dialogueInfo_next_data.get("npcId"));
                        intent_1.putExtra("loading_time", (String) jsonObject_dialogueInfo_next_data.get("dialogueWaitingTime"));
                        intent_1.putExtra("dialogue_extras_content", (String) jsonObject_dialogueInfo_next_data.get("dialogueExtrasContent"));
                        intent_1.putExtra("dialogue_id", (String) jsonObject_dialogueInfo_next_data.get("dialogueId"));
                        intent_1.putExtra("dialogue_flag", (String) jsonObject_dialogueInfo_next_data.get("dialogueFlag"));
                        context.startActivity(intent_1);
                        break;

                    case "2":
                        Intent intent_2 = new Intent(context, DialogueActivity_02.class);
                        intent_2.putExtra("dialogue_id", (String) jsonObject_dialogueInfo_next_data.get("dialogueId"));
                        intent_2.putExtra("next_dialogue_id", (String) jsonObject_dialogueInfo_next_data.get("nextDialogueId"));
                        intent_2.putExtra("dialogue_flag", (String) jsonObject_dialogueInfo_next_data.get("dialogueFlag"));
                        context.startActivity(intent_2);
                        break;

                    case "3":
                        Intent intent_3 = new Intent(context, DialogueActivity_03.class);
                        intent_3.putExtra("dialogue_id", (String) jsonObject_dialogueInfo_next_data.get("dialogueId"));
                        intent_3.putExtra("next_dialogue_id", (String) jsonObject_dialogueInfo_next_data.get("nextDialogueId"));
                        intent_3.putExtra("dialogue_flag", (String) jsonObject_dialogueInfo_next_data.get("dialogueFlag"));
                        context.startActivity(intent_3);
                        break;

                    case "4":
                        Intent intent_4 = new Intent(context, DialogueActivity_04.class);
                        intent_4.putExtra("dialogue_id", (String) jsonObject_dialogueInfo_next_data.get("dialogueId"));
                        intent_4.putExtra("next_dialogue_id", (String) jsonObject_dialogueInfo_next_data.get("nextDialogueId"));
                        intent_4.putExtra("dialogue_flag", (String) jsonObject_dialogueInfo_next_data.get("dialogueFlag"));
                        context.startActivity(intent_4);
                        break;

                    case "5":
                        Intent intent_5 = new Intent(context, DialogueActivity_05.class);
                        intent_5.putExtra("dialogue_id", (String) jsonObject_dialogueInfo_next_data.get("dialogueId"));
                        intent_5.putExtra("next_dialogue_id", (String) jsonObject_dialogueInfo_next_data.get("nextDialogueId"));
                        intent_5.putExtra("dialogue_flag", (String) jsonObject_dialogueInfo_next_data.get("dialogueFlag"));
                        context.startActivity(intent_5);
                        break;

                    case "7":
                        Intent intent_7 = new Intent(context, DialogueActivity_07.class);
                        intent_7.putExtra("dialogue_id", (String) jsonObject_dialogueInfo_next_data.get("dialogueId"));
                        intent_7.putExtra("next_dialogue_id", (String) jsonObject_dialogueInfo_next_data.get("nextDialogueId"));
                        intent_7.putExtra("dialogue_flag", (String) jsonObject_dialogueInfo_next_data.get("dialogueFlag"));
                        context.startActivity(intent_7);
                        break;

                    case "8":
                        Intent intent_8 = new Intent(context, DialogueActivity_08.class);
                        intent_8.putExtra("dialogue_id", (String) jsonObject_dialogueInfo_next_data.get("dialogueId"));
                        intent_8.putExtra("dialogue_flag", (String) jsonObject_dialogueInfo_next_data.get("dialogueFlag"));
                        List<iDialogueJudgmentInfo> dialogueJudgmentInfoList = JSON.parseArray((String) jsonObject_dialogueInfo_next_data.get("dialogueJudgmentInfoList"), iDialogueJudgmentInfo.class);
                        intent_8.putExtra("next_dialogue_id_1", dialogueJudgmentInfoList.get(0).getDialogueJudgmentNextDialogueId());
                        intent_8.putExtra("next_dialogue_id_2", dialogueJudgmentInfoList.get(1).getDialogueJudgmentNextDialogueId());
                        context.startActivity(intent_8);
                        break;

                    case "9":
                        Intent intent_9 = new Intent(context, DialogueActivity_09.class);
                        intent_9.putExtra("dialogue_id", (String) jsonObject_dialogueInfo_next_data.get("dialogueId"));
                        intent_9.putExtra("next_dialogue_id", (String) jsonObject_dialogueInfo_next_data.get("nextDialogueId"));
                        intent_9.putExtra("dialogue_flag", (String) jsonObject_dialogueInfo_next_data.get("dialogueFlag"));
                        context.startActivity(intent_9);
                        break;
                }
            }
        }).start();
    }

}
