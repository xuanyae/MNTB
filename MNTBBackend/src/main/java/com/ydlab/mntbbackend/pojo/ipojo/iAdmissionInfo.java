package com.ydlab.mntbbackend.pojo.ipojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class iAdmissionInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String collegeName;

    private String majorName;

    private String majorNotes;

    private String groupScoreMin;

    private String majorScoreMin;

}
