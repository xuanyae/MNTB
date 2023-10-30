package com.ydlab.mntbbackend.pojo.ipojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class iMajorGroupInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String collegeId;

    private String majorGroupId;

    private String majorGroupName;

}
