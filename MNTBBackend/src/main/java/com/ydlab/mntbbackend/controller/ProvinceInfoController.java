package com.ydlab.mntbbackend.controller;


import com.ydlab.mntbbackend.service.ProvinceInfoService;
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
@RequestMapping("/provinceInfo")
public class ProvinceInfoController {

    @Autowired
    private ProvinceInfoService provinceInfoService;

    @GetMapping("/getProvinceList")
    public ResultVo getProvinceList() {
        return provinceInfoService.getProvinceList();
    }

}

