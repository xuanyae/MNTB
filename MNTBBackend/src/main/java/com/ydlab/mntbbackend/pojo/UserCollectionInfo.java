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
@ApiModel(value = "UserCollectionInfo对象", description = "")
public class UserCollectionInfo implements Serializable {

    private static final long serialVersionUID = 1L;

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

    @ApiModelProperty(value = "逻辑删除")
    private Integer deleted;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;


}
