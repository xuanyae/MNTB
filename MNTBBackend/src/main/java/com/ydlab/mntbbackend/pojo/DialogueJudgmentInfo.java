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
@ApiModel(value = "DialogueJudgmentInfo对象", description = "")
public class DialogueJudgmentInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "对话判断填充规则id")
    private String dialogueJudgmentId;

    @ApiModelProperty(value = "对话判断填充规则分支id")
    private String dialogueJudgmentBranchOrder;

    @ApiModelProperty(value = "下一个对话id")
    private String dialogueJudgmentNextDialogueId;

    @ApiModelProperty(value = "对话判断分支规则描述(无用,当备注使用,实际开发中可删除该字段)")
    private String dialogueJudgmentBranchDescribe;


}
