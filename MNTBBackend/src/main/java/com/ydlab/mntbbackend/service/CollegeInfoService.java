package com.ydlab.mntbbackend.service;

import com.ydlab.mntbbackend.pojo.CollegeInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ydlab.mntbbackend.vo.ResultVo;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author LiHaoXuan
 * @since 2023-08-07
 */
public interface CollegeInfoService extends IService<CollegeInfo> {

    ResultVo getCollegeInfoList(String province_id, String type, String year);

}
