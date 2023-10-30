package com.ydlab.mntbbackend.service;

import com.ydlab.mntbbackend.pojo.UserCollectionInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ydlab.mntbbackend.vo.ResultVo;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author LiHaoXuan
 * @since 2023-08-11
 */
public interface UserCollectionInfoService extends IService<UserCollectionInfo> {

    ResultVo getUserCollectionInfo(String user_id);

    void setUserCollectionInfo(List<Map<String, Object>> userCollectionInfoList);
}
