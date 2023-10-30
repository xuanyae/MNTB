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
@ApiModel(value="MajorScoreInfo对象", description="")
public class MajorScoreInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String collegeId;

    private String type;

    private String batchId;

    private String majorFieldCode;

    private String majorCategoryCode;

    private String majorCode;

    private String major;

    private String majorNotes;

    private String scoreMax;

    private String scoreAvg;

    private String scoreMin;

    private String sectionMin;

    private String year;


}
