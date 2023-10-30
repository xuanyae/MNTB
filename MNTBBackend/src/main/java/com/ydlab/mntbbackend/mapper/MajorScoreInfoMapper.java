package com.ydlab.mntbbackend.mapper;

import com.ydlab.mntbbackend.pojo.MajorScoreInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ydlab.mntbbackend.pojo.ipojo.iMajorInfo;
import org.apache.ibatis.annotations.Param;
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
public interface MajorScoreInfoMapper extends BaseMapper<MajorScoreInfo> {

    List<String> getMajorGroupInfoList(@Param("college_id") String college_id,
                                       @Param("type") String type,
                                       @Param("year") String year);

    List<iMajorInfo> getMajorInfoList(@Param("college_id") String college_id,
                                      @Param("type") String type,
                                      @Param("major_group_id") String major_group_id,
                                      @Param("year") String year);

    List<String> getMajorScoreList(@Param("college_id") String college_id,
                                   @Param("type") String type,
                                   @Param("major_group_id") String major_group_id,
                                   @Param("major_name") String major_name,
                                   @Param("year") String year);

    List<iMajorInfo> getMajorRecommend(@Param("type") String type,
                                       @Param("total_score") String total_score,
                                       @Param("total_score_min") String total_score_min,
                                       @Param("province_id") String province_id,
                                       @Param("major_field_code") String major_field_code,
                                       @Param("year") String year);

    List<String> getMajorGroupScoreList(@Param("college_id") String college_id,
                                        @Param("type") String type,
                                        @Param("major_group_id") String major_group_id,
                                        @Param("year") String year);

    List<iMajorInfo> getAdjustVolunteerByAsc(@Param("college_id") String college_id,
                                              @Param("type") String type,
                                              @Param("major_group_id") String major_group_id,
                                              @Param("year") String year);

}
