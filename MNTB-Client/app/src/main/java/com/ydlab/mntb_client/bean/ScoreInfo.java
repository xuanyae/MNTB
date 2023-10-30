package com.ydlab.mntb_client.bean;

import java.io.Serializable;

public class ScoreInfo implements Serializable {

    private String user_id;

    private String stage_id;

    private String subject_score_1;//语文

    private String subject_score_2;//数学

    private String subject_score_3;//英语

    private String subject_score_4;//物理

    private String subject_score_5;//历史

    private String subject_score_6;//化学

    private String subject_score_7;//生物

    private String subject_score_8;//地理

    private String subject_score_9;//政治

    private String total_score;//总分

    private String type;//物理?历史?

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getStage_id() {
        return stage_id;
    }

    public void setStage_id(String stage_id) {
        this.stage_id = stage_id;
    }

    public String getSubject_score_1() {
        return subject_score_1;
    }

    public void setSubject_score_1(String subject_score_1) {
        this.subject_score_1 = subject_score_1;
    }

    public String getSubject_score_2() {
        return subject_score_2;
    }

    public void setSubject_score_2(String subject_score_2) {
        this.subject_score_2 = subject_score_2;
    }

    public String getSubject_score_3() {
        return subject_score_3;
    }

    public void setSubject_score_3(String subject_score_3) {
        this.subject_score_3 = subject_score_3;
    }

    public String getSubject_score_4() {
        return subject_score_4;
    }

    public void setSubject_score_4(String subject_score_4) {
        this.subject_score_4 = subject_score_4;
    }

    public String getSubject_score_5() {
        return subject_score_5;
    }

    public void setSubject_score_5(String subject_score_5) {
        this.subject_score_5 = subject_score_5;
    }

    public String getSubject_score_6() {
        return subject_score_6;
    }

    public void setSubject_score_6(String subject_score_6) {
        this.subject_score_6 = subject_score_6;
    }

    public String getSubject_score_7() {
        return subject_score_7;
    }

    public void setSubject_score_7(String subject_score_7) {
        this.subject_score_7 = subject_score_7;
    }

    public String getSubject_score_8() {
        return subject_score_8;
    }

    public void setSubject_score_8(String subject_score_8) {
        this.subject_score_8 = subject_score_8;
    }

    public String getSubject_score_9() {
        return subject_score_9;
    }

    public void setSubject_score_9(String subject_score_9) {
        this.subject_score_9 = subject_score_9;
    }

    public String getTotal_score() {
        return total_score;
    }

    public void setTotal_score(String total_score) {
        this.total_score = total_score;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
