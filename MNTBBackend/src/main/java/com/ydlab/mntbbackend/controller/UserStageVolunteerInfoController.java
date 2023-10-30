package com.ydlab.mntbbackend.controller;


import com.ydlab.mntbbackend.service.UserStageVolunteerInfoService;
import com.ydlab.mntbbackend.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author LiHaoXuan
 * @since 2023-08-11
 */
@RestController
@RequestMapping("/userStageVolunteerInfo")
public class UserStageVolunteerInfoController {

    @Autowired
    private UserStageVolunteerInfoService userStageVolunteerInfoService;

    @PostMapping("/setUserStageVolunteer")
    public void setUserStageVolunteer(@RequestBody List<Map<String, Object>> userStageVolunteerList) {
        userStageVolunteerInfoService.setUserStageVolunteer(userStageVolunteerList);
    }

    @GetMapping("/getVolunteerIsSet")
    public ResultVo getUserStageVolunteerIsSet(@RequestParam("user_id") String user_id,
                                               @RequestParam("stage_id") String stage_id) {
        return userStageVolunteerInfoService.getUserStageVolunteerIsSet(user_id, stage_id);
    }

}

