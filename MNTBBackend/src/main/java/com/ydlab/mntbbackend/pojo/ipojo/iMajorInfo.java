package com.ydlab.mntbbackend.pojo.ipojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class iMajorInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String collegeId;

    private String collegeName;

    private String type;

    private String majorGroupId;

    private String majorGroupName;

    private String majorName;

    private String majorNotes;

    private String majorScore1;

    private String majorScore2;

    private String majorScore3;

    private String majorScore4;

    private String majorScore5;

}
