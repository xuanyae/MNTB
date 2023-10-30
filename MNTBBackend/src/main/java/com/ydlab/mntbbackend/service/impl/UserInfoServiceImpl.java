package com.ydlab.mntbbackend.service.impl;

import com.ydlab.mntbbackend.pojo.UserInfo;
import com.ydlab.mntbbackend.mapper.UserInfoMapper;
import com.ydlab.mntbbackend.service.UserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ydlab.mntbbackend.utils.ResultUtils;
import com.ydlab.mntbbackend.utils.SnowFlakeUtils;
import com.ydlab.mntbbackend.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public ResultVo setUserInfo() {
        String user_id = SnowFlakeUtils.getId(1, 1, 1);
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(user_id);
        userInfoMapper.insert(userInfo);
        return ResultUtils.success("获取成功", user_id);
    }
}
