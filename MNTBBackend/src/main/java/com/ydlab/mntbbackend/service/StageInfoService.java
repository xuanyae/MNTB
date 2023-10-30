package com.ydlab.mntbbackend.service;

import com.ydlab.mntbbackend.pojo.StageInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ydlab.mntbbackend.vo.ResultVo;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author LiHaoXuan
 * @since 2023-08-07
 */
public interface StageInfoService extends IService<StageInfo> {

    ResultVo getStageId();

}
