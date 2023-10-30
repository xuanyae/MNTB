package com.ydlab.mntb_client.ipojo;

import java.io.Serializable;
import java.util.List;

public class iDialogueInfo implements Serializable {

    private String dialogueId;

    private String stageId;

    private String npcId;

    private String dialogueContent;

    private String nextDialogueId;

    private String dialogueJudgmentId;

    private List<iDialogueJudgmentInfo> dialogueJudgmentInfoList;

    private String dialogueFillId;

    private String dialogueWaitingTime;

    private String dialogueExtrasContent;

    private String dialogueFlag;

    private String dialoguePageId;

    public String getDialogueId() {
        return dialogueId;
    }

    public void setDialogueId(String dialogueId) {
        this.dialogueId = dialogueId;
    }

    public String getStageId() {
        return stageId;
    }

    public void setStageId(String stageId) {
        this.stageId = stageId;
    }

    public String getNpcId() {
        return npcId;
    }

    public void setNpcId(String npcId) {
        this.npcId = npcId;
    }

    public String getDialogueContent() {
        return dialogueContent;
    }

    public void setDialogueContent(String dialogueContent) {
        this.dialogueContent = dialogueContent;
    }

    public String getNextDialogueId() {
        return nextDialogueId;
    }

    public void setNextDialogueId(String nextDialogueId) {
        this.nextDialogueId = nextDialogueId;
    }

    public String getDialogueJudgmentId() {
        return dialogueJudgmentId;
    }

    public void setDialogueJudgmentId(String dialogueJudgmentId) {
        this.dialogueJudgmentId = dialogueJudgmentId;
    }

    public List<iDialogueJudgmentInfo> getDialogueJudgmentInfoList() {
        return dialogueJudgmentInfoList;
    }

    public void setDialogueJudgmentInfoList(List<iDialogueJudgmentInfo> dialogueJudgmentInfoList) {
        this.dialogueJudgmentInfoList = dialogueJudgmentInfoList;
    }

    public String getDialogueFillId() {
        return dialogueFillId;
    }

    public void setDialogueFillId(String dialogueFillId) {
        this.dialogueFillId = dialogueFillId;
    }

    public String getDialogueWaitingTime() {
        return dialogueWaitingTime;
    }

    public void setDialogueWaitingTime(String dialogueWaitingTime) {
        this.dialogueWaitingTime = dialogueWaitingTime;
    }

    public String getDialogueExtrasContent() {
        return dialogueExtrasContent;
    }

    public void setDialogueExtrasContent(String dialogueExtrasContent) {
        this.dialogueExtrasContent = dialogueExtrasContent;
    }

    public String getDialogueFlag() {
        return dialogueFlag;
    }

    public void setDialogueFlag(String dialogueFlag) {
        this.dialogueFlag = dialogueFlag;
    }

    public String getDialoguePageId() {
        return dialoguePageId;
    }

    public void setDialoguePageId(String dialoguePageId) {
        this.dialoguePageId = dialoguePageId;
    }
}
