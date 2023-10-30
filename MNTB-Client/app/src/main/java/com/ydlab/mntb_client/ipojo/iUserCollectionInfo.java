package com.ydlab.mntb_client.ipojo;

import java.io.Serializable;
import java.util.Date;

public class iUserCollectionInfo implements Serializable {

    private String collectionId;

    private String userId;

    private String collectionCollegeId;

    private String collectionCollegeName;

    private String type;

    private String collectionMajorGroupId;

    private String collectionMajorGroupName;

    private String collectionMajorName;

    private String collectionMajorNotes;

    private String majorScore1;

    private String majorScore2;

    private String majorScore3;

    private String majorScore4;

    private String majorScore5;

    private Integer deleted;

    private Date createTime;

    public String getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(String collectionId) {
        this.collectionId = collectionId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCollectionCollegeId() {
        return collectionCollegeId;
    }

    public void setCollectionCollegeId(String collectionCollegeId) {
        this.collectionCollegeId = collectionCollegeId;
    }

    public String getCollectionCollegeName() {
        return collectionCollegeName;
    }

    public void setCollectionCollegeName(String collectionCollegeName) {
        this.collectionCollegeName = collectionCollegeName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCollectionMajorGroupId() {
        return collectionMajorGroupId;
    }

    public void setCollectionMajorGroupId(String collectionMajorGroupId) {
        this.collectionMajorGroupId = collectionMajorGroupId;
    }

    public String getCollectionMajorGroupName() {
        return collectionMajorGroupName;
    }

    public void setCollectionMajorGroupName(String collectionMajorGroupName) {
        this.collectionMajorGroupName = collectionMajorGroupName;
    }

    public String getCollectionMajorName() {
        return collectionMajorName;
    }

    public void setCollectionMajorName(String collectionMajorName) {
        this.collectionMajorName = collectionMajorName;
    }

    public String getCollectionMajorNotes() {
        return collectionMajorNotes;
    }

    public void setCollectionMajorNotes(String collectionMajorNotes) {
        this.collectionMajorNotes = collectionMajorNotes;
    }

    public String getMajorScore1() {
        return majorScore1;
    }

    public void setMajorScore1(String majorScore1) {
        this.majorScore1 = majorScore1;
    }

    public String getMajorScore2() {
        return majorScore2;
    }

    public void setMajorScore2(String majorScore2) {
        this.majorScore2 = majorScore2;
    }

    public String getMajorScore3() {
        return majorScore3;
    }

    public void setMajorScore3(String majorScore3) {
        this.majorScore3 = majorScore3;
    }

    public String getMajorScore4() {
        return majorScore4;
    }

    public void setMajorScore4(String majorScore4) {
        this.majorScore4 = majorScore4;
    }

    public String getMajorScore5() {
        return majorScore5;
    }

    public void setMajorScore5(String majorScore5) {
        this.majorScore5 = majorScore5;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
