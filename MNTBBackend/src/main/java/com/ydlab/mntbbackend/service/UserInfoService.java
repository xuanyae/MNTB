package com.ydlab.mntbbackend.service;

import com.ydlab.mntbbackend.pojo.UserInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ydlab.mntbbackend.vo.ResultVo;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author LiHaoXuan
 * @since 2023-08-11
 */
public interface UserInfoService extends IService<UserInfo> {

    ResultVo setUserInfo();

}
