package com.ydlab.mntbbackend.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
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
@ApiModel(value="StageInfo对象", description="")
public class StageInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String stageId;

    private Date stageStartTime;

    private Date stageEndTime;

    private String stageTitle;


}
