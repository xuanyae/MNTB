package com.ydlab.mntb_client.bean;

import java.io.Serializable;

public class ProvinceInfo implements Serializable {

    private String province_id;

    private String province_name;

    public String getProvince_id() {
        return province_id;
    }

    public void setProvince_id(String province_id) {
        this.province_id = province_id;
    }

    public String getProvince_name() {
        return province_name;
    }

    public void setProvince_name(String province_name) {
        this.province_name = province_name;
    }
}
