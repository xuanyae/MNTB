package com.ydlab.mntb_client.bean;

import java.io.Serializable;

public class MajorGroupInfo implements Serializable {

    private String college_id;

    private String major_group_id;

    private String major_group_name;

    public String getCollege_id() {
        return college_id;
    }

    public void setCollege_id(String college_id) {
        this.college_id = college_id;
    }

    public String getMajor_group_id() {
        return major_group_id;
    }

    public void setMajor_group_id(String major_group_id) {
        this.major_group_id = major_group_id;
    }

    public String getMajor_group_name() {
        return major_group_name;
    }

    public void setMajor_group_name(String major_group_name) {
        this.major_group_name = major_group_name;
    }
}
