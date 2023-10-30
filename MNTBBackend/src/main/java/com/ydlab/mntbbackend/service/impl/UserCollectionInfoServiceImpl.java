package com.ydlab.mntbbackend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ydlab.mntbbackend.pojo.UserCollectionInfo;
import com.ydlab.mntbbackend.mapper.UserCollectionInfoMapper;
import com.ydlab.mntbbackend.service.UserCollectionInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ydlab.mntbbackend.utils.ResultUtils;
import com.ydlab.mntbbackend.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
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
public class UserCollectionInfoServiceImpl extends ServiceImpl<UserCollectionInfoMapper, UserCollectionInfo> implements UserCollectionInfoService {

    @Autowired
    private UserCollectionInfoMapper userCollectionInfoMapper;

    @Override
    public ResultVo getUserCollectionInfo(String user_id) {
        QueryWrapper<UserCollectionInfo> queryWrapper_userCollectionInfo = new QueryWrapper<>();
        queryWrapper_userCollectionInfo.eq("user_id", user_id);
        List<UserCollectionInfo> userCollectionInfo_list = userCollectionInfoMapper.selectList(queryWrapper_userCollectionInfo);
        return ResultUtils.success("", userCollectionInfo_list);
    }

    @Override
    public void setUserCollectionInfo(List<Map<String, Object>> userCollectionInfoList) {
        for (Map<String, Object> userCollectionInfoMap : userCollectionInfoList) {
            UserCollectionInfo userCollectionInfo = new UserCollectionInfo();
            userCollectionInfo.setUserId((String) userCollectionInfoMap.get("user_id"));
            userCollectionInfo.setCollectionCollegeId((String) userCollectionInfoMap.get("college_id"));
            userCollectionInfo.setCollectionCollegeName((String) userCollectionInfoMap.get("college_name"));
            userCollectionInfo.setType((String) userCollectionInfoMap.get("type"));
            userCollectionInfo.setCollectionMajorGroupId((String) userCollectionInfoMap.get("major_group_id"));
            userCollectionInfo.setCollectionMajorGroupName((String) userCollectionInfoMap.get("major_group_name"));
            userCollectionInfo.setCollectionMajorName((String) userCollectionInfoMap.get("major_name"));
            userCollectionInfo.setCollectionMajorNotes((String) userCollectionInfoMap.get("major_notes"));
            userCollectionInfo.setMajorScore1((String) userCollectionInfoMap.get("major_score_1"));
            userCollectionInfo.setMajorScore2((String) userCollectionInfoMap.get("major_score_2"));
            userCollectionInfo.setMajorScore3((String) userCollectionInfoMap.get("major_score_3"));
            userCollectionInfo.setMajorScore4((String) userCollectionInfoMap.get("major_score_4"));
            userCollectionInfo.setMajorScore5((String) userCollectionInfoMap.get("major_score_5"));
            HashMap<String, Object> map = new HashMap<>();
            map.put("user_id", userCollectionInfo.getUserId());
            map.put("collection_college_id", userCollectionInfo.getCollectionCollegeId());
            map.put("collection_major_group_id", userCollectionInfo.getCollectionMajorGroupId());
            map.put("collection_major_name", userCollectionInfo.getCollectionMajorName());
            map.put("collection_major_notes", userCollectionInfo.getCollectionMajorNotes());
            List<UserCollectionInfo> collectionInfoList = userCollectionInfoMapper.selectByMap(map);
            if (collectionInfoList.size() == 0) {
                userCollectionInfoMapper.insert(userCollectionInfo);
            }
        }
    }
}
