package com.ydlab.mntb_client.bean;

import java.io.Serializable;

public class CollegeInfo implements Serializable {

    private String college_id;

    private String college_name;

    private String college_province_id;

    public String getCollege_id() {
        return college_id;
    }

    public void setCollege_id(String college_id) {
        this.college_id = college_id;
    }

    public String getCollege_name() {
        return college_name;
    }

    public void setCollege_name(String college_name) {
        this.college_name = college_name;
    }

    public String getCollege_province_id() {
        return college_province_id;
    }

    public void setCollege_province_id(String college_province_id) {
        this.college_province_id = college_province_id;
    }
}
