package com.ydlab.mntbbackend.service.impl;

import com.ydlab.mntbbackend.pojo.ProvinceInfo;
import com.ydlab.mntbbackend.mapper.ProvinceInfoMapper;
import com.ydlab.mntbbackend.service.ProvinceInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ydlab.mntbbackend.utils.ResultUtils;
import com.ydlab.mntbbackend.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author LiHaoXuan
 * @since 2023-08-07
 */
@Service
public class ProvinceInfoServiceImpl extends ServiceImpl<ProvinceInfoMapper, ProvinceInfo> implements ProvinceInfoService {

    @Autowired
    private ProvinceInfoMapper provinceInfoMapper;

    @Override
    public ResultVo getProvinceList() {
        return ResultUtils.success("", provinceInfoMapper.selectList(null));
    }
}
