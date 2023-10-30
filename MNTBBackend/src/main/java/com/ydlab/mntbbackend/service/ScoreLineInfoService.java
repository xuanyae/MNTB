package com.ydlab.mntbbackend.service;

import com.ydlab.mntbbackend.pojo.ScoreLineInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ydlab.mntbbackend.vo.ResultVo;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author LiHaoXuan
 * @since 2023-08-18
 */
public interface ScoreLineInfoService extends IService<ScoreLineInfo> {

    ResultVo getScoreLine(String type);

}
