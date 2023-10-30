package com.ydlab.mntbbackend.controller;


import com.ydlab.mntbbackend.service.UserStageScoreInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author LiHaoXuan
 * @since 2023-08-13
 */
@RestController
@RequestMapping("/userStageScoreInfo")
public class UserStageScoreInfoController {

    @Autowired
    private UserStageScoreInfoService userStageScoreInfoService;

    @PostMapping("/setUserStageScoreInfo")
    public void setUserStageScoreInfo(@RequestBody Map<String, Object> userStageScoreInfoMap) {
        userStageScoreInfoService.setUserStageScoreInfo(userStageScoreInfoMap);
    }

}

