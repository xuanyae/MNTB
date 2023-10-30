package com.ydlab.mntbbackend.pojo.ipojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class iDialogueJudgmentInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String dialogueJudgmentBranchOrder;

    private String dialogueJudgmentNextDialogueId;

}
