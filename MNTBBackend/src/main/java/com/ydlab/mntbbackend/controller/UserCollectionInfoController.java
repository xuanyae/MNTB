package com.ydlab.mntbbackend.controller;


import com.ydlab.mntbbackend.service.UserCollectionInfoService;
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
@RequestMapping("/userCollectionInfo")
public class UserCollectionInfoController {

    @Autowired
    private UserCollectionInfoService userCollectionInfoService;

    @GetMapping("/getUserCollectionInfo")
    public ResultVo getUserCollectionInfo(@RequestParam("user_id") String user_id) {
        return userCollectionInfoService.getUserCollectionInfo(user_id);
    }

    @PostMapping("/setUserCollectionInfo")
    public void setUserCollectionInfo(@RequestBody List<Map<String, Object>> userCollectionInfoList) {
        userCollectionInfoService.setUserCollectionInfo(userCollectionInfoList);
    }
}

