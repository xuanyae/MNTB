package com.ydlab.mntbbackend.mapper;

import com.ydlab.mntbbackend.pojo.DialogueInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ydlab.mntbbackend.pojo.ipojo.iDialogueInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author LiHaoXuan
 * @since 2023-08-07
 */
@Repository
public interface DialogueInfoMapper extends BaseMapper<DialogueInfo> {

    iDialogueInfo getDialogueInfoByDialogueId(@Param("dialogue_id") String dialogue_id);

}
