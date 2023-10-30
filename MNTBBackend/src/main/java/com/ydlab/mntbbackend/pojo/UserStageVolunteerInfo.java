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
 * @since 2023-08-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="UserStageVolunteerInfo对象", description="")
public class UserStageVolunteerInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userId;

    private String stageId;

    private String type;

    private String volunteerOrder;

    private String collegeId;

    private String collegeName;

    private String majorGroupId;

    private String majorGroupName;

    @ApiModelProperty(value = "是否接受调剂")
    private String isAdjust;

    private String majorName1;

    private String majorNotes1;

    private String majorName2;

    private String majorNotes2;

    private String majorName3;

    private String majorNotes3;

    private String majorName4;

    private String majorNotes4;

    private String majorName5;

    private String majorNotes5;

    private String majorName6;

    private String majorNotes6;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;


}
