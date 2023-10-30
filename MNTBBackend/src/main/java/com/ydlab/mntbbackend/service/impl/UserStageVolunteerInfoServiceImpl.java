package com.ydlab.mntbbackend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ydlab.mntbbackend.pojo.UserStageVolunteerInfo;
import com.ydlab.mntbbackend.mapper.UserStageVolunteerInfoMapper;
import com.ydlab.mntbbackend.service.UserStageVolunteerInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ydlab.mntbbackend.utils.ResultUtils;
import com.ydlab.mntbbackend.vo.ResultVo;
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
 * @since 2023-08-11
 */
@Service
public class UserStageVolunteerInfoServiceImpl extends ServiceImpl<UserStageVolunteerInfoMapper, UserStageVolunteerInfo> implements UserStageVolunteerInfoService {

    @Autowired
    private UserStageVolunteerInfoMapper userStageVolunteerInfoMapper;

    @Override
    public void setUserStageVolunteer(List<Map<String, Object>> userStageVolunteerList) {
        QueryWrapper<UserStageVolunteerInfo> queryWrapper_UserStageVolunteerInfo = new QueryWrapper<>();
        queryWrapper_UserStageVolunteerInfo.eq("user_id", (String) userStageVolunteerList.get(0).get("user_id"));
        queryWrapper_UserStageVolunteerInfo.eq("stage_id", (String) userStageVolunteerList.get(0).get("stage_id"));
        List<UserStageVolunteerInfo> userStageVolunteerInfoList = userStageVolunteerInfoMapper.selectList(queryWrapper_UserStageVolunteerInfo);
        if (userStageVolunteerInfoList.size() != 0) {
            userStageVolunteerInfoMapper.delete(queryWrapper_UserStageVolunteerInfo);
        }
        for (Map<String, Object> userStageVolunteerMap : userStageVolunteerList) {
            UserStageVolunteerInfo userStageVolunteerInfo = new UserStageVolunteerInfo();
            userStageVolunteerInfo.setUserId((String) userStageVolunteerMap.get("user_id"));
            userStageVolunteerInfo.setStageId((String) userStageVolunteerMap.get("stage_id"));
            userStageVolunteerInfo.setType((String) userStageVolunteerMap.get("type"));
            userStageVolunteerInfo.setVolunteerOrder((String) userStageVolunteerMap.get("volunteer_order"));
            userStageVolunteerInfo.setCollegeId((String) userStageVolunteerMap.get("college_id"));
            userStageVolunteerInfo.setCollegeName((String) userStageVolunteerMap.get("college_name"));
            userStageVolunteerInfo.setMajorGroupId((String) userStageVolunteerMap.get("major_group_id"));
            userStageVolunteerInfo.setMajorGroupName((String) userStageVolunteerMap.get("major_group_name"));
            userStageVolunteerInfo.setIsAdjust((String) userStageVolunteerMap.get("is_adjust"));
            userStageVolunteerInfo.setMajorName1((String) userStageVolunteerMap.get("major_name_1"));
            userStageVolunteerInfo.setMajorNotes1((String) userStageVolunteerMap.get("major_notes_1"));
            userStageVolunteerInfo.setMajorName2((String) userStageVolunteerMap.get("major_name_2"));
            userStageVolunteerInfo.setMajorNotes2((String) userStageVolunteerMap.get("major_notes_2"));
            userStageVolunteerInfo.setMajorName3((String) userStageVolunteerMap.get("major_name_3"));
            userStageVolunteerInfo.setMajorNotes3((String) userStageVolunteerMap.get("major_notes_3"));
            userStageVolunteerInfo.setMajorName4((String) userStageVolunteerMap.get("major_name_4"));
            userStageVolunteerInfo.setMajorNotes4((String) userStageVolunteerMap.get("major_notes_4"));
            userStageVolunteerInfo.setMajorName5((String) userStageVolunteerMap.get("major_name_5"));
            userStageVolunteerInfo.setMajorNotes5((String) userStageVolunteerMap.get("major_notes_5"));
            userStageVolunteerInfo.setMajorName6((String) userStageVolunteerMap.get("major_name_6"));
            userStageVolunteerInfo.setMajorNotes6((String) userStageVolunteerMap.get("major_notes_6"));
            userStageVolunteerInfoMapper.insert(userStageVolunteerInfo);
        }
    }

    @Override
    public ResultVo getUserStageVolunteerIsSet(String user_id, String stage_id) {
        QueryWrapper<UserStageVolunteerInfo> queryWrapper_UserStageVolunteerInfo = new QueryWrapper<>();
        queryWrapper_UserStageVolunteerInfo.eq("user_id", user_id);
        queryWrapper_UserStageVolunteerInfo.eq("stage_id", String.valueOf(Integer.parseInt(stage_id) - 1));
        List<UserStageVolunteerInfo> userStageVolunteerInfos = userStageVolunteerInfoMapper.selectList(queryWrapper_UserStageVolunteerInfo);
        if (userStageVolunteerInfos.size() > 0) {
            return ResultUtils.success("", "1");
        } else {
            return ResultUtils.success("", "0");
        }
    }
}
