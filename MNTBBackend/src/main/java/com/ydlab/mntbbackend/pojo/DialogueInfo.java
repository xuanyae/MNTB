package com.ydlab.mntbbackend.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author LiHaoXuan
 * @since 2023-08-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "DialogueInfo对象", description = "")
public class DialogueInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "对话id")
    private String dialogueId;

    @ApiModelProperty(value = "对话所处阶段")
    private String stageId;

    @ApiModelProperty(value = "对话NPC")
    private String npcId;

    @ApiModelProperty(value = "对话内容")
    private String dialogueContent;

    @ApiModelProperty(value = "下一个对话id")
    private String nextDialogueId;

    @ApiModelProperty(value = "对话判断规则id")
    private String dialogueJudgmentId;

    @ApiModelProperty(value = "对话填充规则id")
    private String dialogueFillId;

    @ApiModelProperty(value = "对话等待自动跳转时长")
    private String dialogueWaitingTime;

    @ApiModelProperty(value = "对话附加内容(进度条的内容)")
    private String dialogueExtrasContent;

    private String dialogueFlag;

    private String dialoguePageId;

}
