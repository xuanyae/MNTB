package com.ydlab.mntbbackend.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
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
 * @since 2023-08-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="UserStageScoreInfo对象", description="")
public class UserStageScoreInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userId;

    private String stageId;

    private String type;

    private String subjectScore1;

    private String subjectScore2;

    private String subjectScore3;

    private String subjectScore4;

    private String subjectScore5;

    private String subjectScore6;

    private String subjectScore7;

    private String subjectScore8;

    private String subjectScore9;

    private String totalScore;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;


}
