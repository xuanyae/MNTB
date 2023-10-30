package com.ydlab.mntbbackend.service.impl;

import com.ydlab.mntbbackend.pojo.StageInfo;
import com.ydlab.mntbbackend.mapper.StageInfoMapper;
import com.ydlab.mntbbackend.service.StageInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ydlab.mntbbackend.utils.ResultUtils;
import com.ydlab.mntbbackend.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author LiHaoXuan
 * @since 2023-08-07
 */
@Service
public class StageInfoServiceImpl extends ServiceImpl<StageInfoMapper, StageInfo> implements StageInfoService {

    @Autowired
    private StageInfoMapper stageInfoMapper;

    @Override
    public ResultVo getStageId() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd :HH:mm:ss");
        String stageId = stageInfoMapper.getStageId(dateFormat.format(date));
        if (stageId == null) {
            return ResultUtils.error();
//            return ResultUtils.success("", "1");
        } else {
            return ResultUtils.success(stageId);
        }
    }
}
