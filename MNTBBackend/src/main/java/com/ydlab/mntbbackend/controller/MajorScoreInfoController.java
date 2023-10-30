package com.ydlab.mntbbackend.controller;


import com.ydlab.mntbbackend.service.MajorScoreInfoService;
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
@RequestMapping("/majorScoreInfo")
public class MajorScoreInfoController {

    @Autowired
    private MajorScoreInfoService majorScoreInfoService;

    @GetMapping("/getMajorGroupInfoList")
    public ResultVo getMajorGroupInfoList(@RequestParam("college_id") String college_id,
                                          @RequestParam("type") String type,
                                          @RequestParam(value = "year", defaultValue = "2022") String year) {
        return majorScoreInfoService.getMajorGroupInfoList(college_id, type, year);
    }

    @GetMapping("/getMajorInfoList")
    public ResultVo getMajorInfoList(@RequestParam("college_id") String college_id,
                                     @RequestParam("type") String type,
                                     @RequestParam("major_group_id") String major_group_id,
                                     @RequestParam(value = "year", defaultValue = "2022") String year) {
        return majorScoreInfoService.getMajorInfoList(college_id, type, major_group_id, year);
    }

    @GetMapping("/getMajorRecommend")
    public ResultVo getMajorRecommend(@RequestParam("type") String type,
                                      @RequestParam("total_score") String total_score,
                                      @RequestParam("province_id") String province_id,
                                      @RequestParam("major_field_code") String major_field_code,
                                      @RequestParam(value = "year", defaultValue = "2022") String year) {
        return majorScoreInfoService.getMajorRecommend(type, total_score, province_id, major_field_code, year);
    }

    @GetMapping("/getAdmissionInfo")
    public ResultVo getAdmissionInfo(@RequestParam("user_id") String user_id,
                                     @RequestParam("stage_id") String stage_id,
                                     @RequestParam(value = "year", defaultValue = "2022") String year) {
        return majorScoreInfoService.getAdmissionInfo(user_id, stage_id, year);
    }

}

