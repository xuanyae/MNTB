package com.ydlab.mntb_client.ipojo;

import java.io.Serializable;

public class iDialogueJudgmentInfo implements Serializable {

    private String dialogueJudgmentBranchOrder;

    private String dialogueJudgmentNextDialogueId;

    public String getDialogueJudgmentBranchOrder() {
        return dialogueJudgmentBranchOrder;
    }

    public void setDialogueJudgmentBranchOrder(String dialogueJudgmentBranchOrder) {
        this.dialogueJudgmentBranchOrder = dialogueJudgmentBranchOrder;
    }

    public String getDialogueJudgmentNextDialogueId() {
        return dialogueJudgmentNextDialogueId;
    }

    public void setDialogueJudgmentNextDialogueId(String dialogueJudgmentNextDialogueId) {
        this.dialogueJudgmentNextDialogueId = dialogueJudgmentNextDialogueId;
    }
}
