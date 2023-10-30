package com.ydlab.mntbbackend.controller;


import com.ydlab.mntbbackend.service.ScoreLineInfoService;
import com.ydlab.mntbbackend.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author LiHaoXuan
 * @since 2023-08-18
 */
@RestController
@RequestMapping("/scoreLineInfo")
public class ScoreLineInfoController {

    @Autowired
    private ScoreLineInfoService scoreLineInfoService;

    @GetMapping("/getScoreLine")
    public ResultVo getScoreLine(@RequestParam(value = "type", defaultValue = "1") String type) {
        return scoreLineInfoService.getScoreLine(type);
    }

}

