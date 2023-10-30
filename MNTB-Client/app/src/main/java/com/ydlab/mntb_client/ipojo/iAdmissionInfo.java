package com.ydlab.mntb_client.ipojo;

import java.io.Serializable;

public class iAdmissionInfo implements Serializable {

    private String collegeName;

    private String majorName;

    private String majorNotes;

    private String groupScoreMin;

    private String majorScoreMin;

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public String getMajorNotes() {
        return majorNotes;
    }

    public void setMajorNotes(String majorNotes) {
        this.majorNotes = majorNotes;
    }

    public String getGroupScoreMin() {
        return groupScoreMin;
    }

    public void setGroupScoreMin(String groupScoreMin) {
        this.groupScoreMin = groupScoreMin;
    }

    public String getMajorScoreMin() {
        return majorScoreMin;
    }

    public void setMajorScoreMin(String majorScoreMin) {
        this.majorScoreMin = majorScoreMin;
    }
}
