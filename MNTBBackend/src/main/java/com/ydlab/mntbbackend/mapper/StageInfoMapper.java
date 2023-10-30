package com.ydlab.mntbbackend.mapper;

import com.ydlab.mntbbackend.pojo.StageInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author LiHaoXuan
 * @since 2023-08-07
 */
@Repository
public interface StageInfoMapper extends BaseMapper<StageInfo> {

    String getStageId(@Param("current_time") String current_time);

}
