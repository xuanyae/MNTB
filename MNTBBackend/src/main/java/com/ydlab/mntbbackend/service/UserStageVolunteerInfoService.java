package com.ydlab.mntbbackend.service;

import com.ydlab.mntbbackend.pojo.UserStageVolunteerInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ydlab.mntbbackend.vo.ResultVo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

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
public interface UserStageVolunteerInfoService extends IService<UserStageVolunteerInfo> {

    void setUserStageVolunteer(List<Map<String, Object>> userStageVolunteerList);

    ResultVo getUserStageVolunteerIsSet(String user_id, String stage_id);

}
