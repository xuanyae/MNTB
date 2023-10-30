package com.ydlab.mntbbackend.service;

import com.ydlab.mntbbackend.pojo.DialogueInfo;
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
public interface DialogueInfoService extends IService<DialogueInfo> {

    ResultVo getDialogueInfoByDialogueId(String dialogue_id);

    ResultVo getStageFirstDialogueInfo(String stage_id);

}
