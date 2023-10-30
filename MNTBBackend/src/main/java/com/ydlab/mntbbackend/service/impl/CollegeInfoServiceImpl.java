package com.ydlab.mntbbackend.service.impl;

import com.ydlab.mntbbackend.pojo.CollegeInfo;
import com.ydlab.mntbbackend.mapper.CollegeInfoMapper;
import com.ydlab.mntbbackend.service.CollegeInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ydlab.mntbbackend.utils.ResultUtils;
import com.ydlab.mntbbackend.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author LiHaoXuan
 * @since 2023-08-07
 */
@Service
public class CollegeInfoServiceImpl extends ServiceImpl<CollegeInfoMapper, CollegeInfo> implements CollegeInfoService {

    @Autowired
    private CollegeInfoMapper collegeInfoMapper;

    @Override
    public ResultVo getCollegeInfoList(String province_id, String type, String year) {
        return ResultUtils.success("", collegeInfoMapper.getCollegeInfoList(province_id, type, year));
    }
}
