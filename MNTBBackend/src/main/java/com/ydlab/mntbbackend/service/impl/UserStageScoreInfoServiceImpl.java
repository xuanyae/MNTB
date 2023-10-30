package com.ydlab.mntbbackend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ydlab.mntbbackend.pojo.UserStageScoreInfo;
import com.ydlab.mntbbackend.mapper.UserStageScoreInfoMapper;
import com.ydlab.mntbbackend.service.UserStageScoreInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author LiHaoXuan
 * @since 2023-08-13
 */
@Service
public class UserStageScoreInfoServiceImpl extends ServiceImpl<UserStageScoreInfoMapper, UserStageScoreInfo> implements UserStageScoreInfoService {

    @Autowired
    private UserStageScoreInfoMapper userStageScoreInfoMapper;

    @Override
    public void setUserStageScoreInfo(Map<String, Object> userStageScoreInfoMap) {
        QueryWrapper<UserStageScoreInfo> queryWrapper_userSatgeScoreInfo = new QueryWrapper<>();
        queryWrapper_userSatgeScoreInfo.eq("user_id", (String) userStageScoreInfoMap.get("user_id"));
        queryWrapper_userSatgeScoreInfo.eq("stage_id", (String) userStageScoreInfoMap.get("stage_id"));
        List<UserStageScoreInfo> userStageScoreInfoList = userStageScoreInfoMapper.selectList(queryWrapper_userSatgeScoreInfo);
        if (userStageScoreInfoList.size() != 0) {
            userStageScoreInfoMapper.delete(queryWrapper_userSatgeScoreInfo);
        }
        UserStageScoreInfo userStageScoreInfo = new UserStageScoreInfo();
        userStageScoreInfo.setUserId((String) userStageScoreInfoMap.get("user_id"));
        userStageScoreInfo.setStageId((String) userStageScoreInfoMap.get("stage_id"));
        userStageScoreInfo.setSubjectScore1((String) userStageScoreInfoMap.get("subject_score_1"));
        userStageScoreInfo.setSubjectScore2((String) userStageScoreInfoMap.get("subject_score_2"));
        userStageScoreInfo.setSubjectScore3((String) userStageScoreInfoMap.get("subject_score_3"));
        userStageScoreInfo.setSubjectScore4((String) userStageScoreInfoMap.get("subject_score_4"));
        userStageScoreInfo.setSubjectScore5((String) userStageScoreInfoMap.get("subject_score_5"));
        userStageScoreInfo.setSubjectScore6((String) userStageScoreInfoMap.get("subject_score_6"));
        userStageScoreInfo.setSubjectScore7((String) userStageScoreInfoMap.get("subject_score_7"));
        userStageScoreInfo.setSubjectScore8((String) userStageScoreInfoMap.get("subject_score_8"));
        userStageScoreInfo.setSubjectScore9((String) userStageScoreInfoMap.get("subject_score_9"));
        userStageScoreInfo.setTotalScore((String) userStageScoreInfoMap.get("total_score"));
        userStageScoreInfo.setType((String) userStageScoreInfoMap.get("type"));
//        userStageScoreInfo.setType(userStageScoreInfoMap.get("subject_score_4") != null ? "1" : "2");
        userStageScoreInfoMapper.insert(userStageScoreInfo);
    }
}
