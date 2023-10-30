package com.ydlab.mntbbackend.pojo.ipojo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class iDialogueInfo implements Serializable {

    private static final long serialVersionUID = 1L;

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

}
