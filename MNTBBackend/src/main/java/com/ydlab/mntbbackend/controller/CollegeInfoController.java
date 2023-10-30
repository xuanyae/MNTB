package com.ydlab.mntbbackend.controller;


import com.ydlab.mntbbackend.service.CollegeInfoService;
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
 * @since 2023-08-07
 */
@RestController
@RequestMapping("/collegeInfo")
public class CollegeInfoController {

    @Autowired
    private CollegeInfoService collegeInfoService;

    @GetMapping("/getCollegeInfoList")
    public ResultVo getCollegeInfoList(@RequestParam("province_id") String province_id,
                                   @RequestParam("type") String type,
                                   @RequestParam(value = "year", defaultValue = "2022") String year) {
        return collegeInfoService.getCollegeInfoList(province_id, type, year);
    }

}

