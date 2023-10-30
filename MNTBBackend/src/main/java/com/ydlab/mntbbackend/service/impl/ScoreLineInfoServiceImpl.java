package com.ydlab.mntbbackend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ydlab.mntbbackend.pojo.ScoreLineInfo;
import com.ydlab.mntbbackend.mapper.ScoreLineInfoMapper;
import com.ydlab.mntbbackend.service.ScoreLineInfoService;
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
 * @since 2023-08-18
 */
@Service
public class ScoreLineInfoServiceImpl extends ServiceImpl<ScoreLineInfoMapper, ScoreLineInfo> implements ScoreLineInfoService {

    @Autowired
    private ScoreLineInfoMapper scoreLineInfoMapper;

    @Override
    public ResultVo getScoreLine(String type) {
        QueryWrapper<ScoreLineInfo> queryWrapper_ScoreLineInfo = new QueryWrapper<>();
        queryWrapper_ScoreLineInfo.eq("type", type);
        ScoreLineInfo scoreLineInfo = scoreLineInfoMapper.selectOne(queryWrapper_ScoreLineInfo);
        return ResultUtils.success("", scoreLineInfo.getScoreLine());
    }
}
