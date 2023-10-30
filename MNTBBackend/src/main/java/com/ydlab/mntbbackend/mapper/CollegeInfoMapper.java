package com.ydlab.mntbbackend.mapper;

import com.ydlab.mntbbackend.pojo.CollegeInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author LiHaoXuan
 * @since 2023-08-07
 */
@Repository
public interface CollegeInfoMapper extends BaseMapper<CollegeInfo> {

    List<CollegeInfo> getCollegeInfoList(@Param("province_id") String province_id,
                                                        @Param("type") String type,
                                                        @Param(("year")) String year);

}
