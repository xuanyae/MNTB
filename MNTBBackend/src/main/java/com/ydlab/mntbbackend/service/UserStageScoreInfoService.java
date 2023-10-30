package com.ydlab.mntbbackend.service;

import com.ydlab.mntbbackend.pojo.UserStageScoreInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author LiHaoXuan
 * @since 2023-08-13
 */
public interface UserStageScoreInfoService extends IService<UserStageScoreInfo> {

    void setUserStageScoreInfo(Map<String, Object> userStageScoreInfoMap);

}
