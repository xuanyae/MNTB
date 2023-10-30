package com.ydlab.mntbbackend.controller;


import com.ydlab.mntbbackend.service.StageInfoService;
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
 * @since 2023-08-07
 */
@RestController
@RequestMapping("/stageInfo")
public class StageInfoController {

    @Autowired
    private StageInfoService stageInfoService;

    @GetMapping("/getStageId")
    public ResultVo getStageId() {
        return stageInfoService.getStageId();
    }

}

