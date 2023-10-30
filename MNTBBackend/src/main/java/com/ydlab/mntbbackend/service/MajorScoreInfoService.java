package com.ydlab.mntbbackend.service;

import com.ydlab.mntbbackend.pojo.MajorScoreInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ydlab.mntbbackend.vo.ResultVo;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author LiHaoXuan
 * @since 2023-08-07
 */
public interface MajorScoreInfoService extends IService<MajorScoreInfo> {

    ResultVo getMajorGroupInfoList(String college_id, String type, String year);

    ResultVo getMajorInfoList(String college_id, String type, String major_group_id, String year);

    ResultVo getMajorRecommend(String type, String total_score, String province_id, String major_field_code, String year);

    ResultVo getAdmissionInfo(String user_id, String stage_id, String year);

}
