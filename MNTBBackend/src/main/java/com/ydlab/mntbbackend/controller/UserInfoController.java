package com.ydlab.mntbbackend.controller;


import com.ydlab.mntbbackend.service.UserInfoService;
import com.ydlab.mntbbackend.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author LiHaoXuan
 * @since 2023-08-11
 */
@RestController
@RequestMapping("/userInfo")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("/getUserId")
    public ResultVo getUserId() {
        return userInfoService.setUserInfo();
    }

}

