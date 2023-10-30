package com.ydlab.mntbbackend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ydlab.mntbbackend.mapper.DialogueJudgmentInfoMapper;
import com.ydlab.mntbbackend.pojo.DialogueInfo;
import com.ydlab.mntbbackend.mapper.DialogueInfoMapper;
import com.ydlab.mntbbackend.pojo.DialogueJudgmentInfo;
import com.ydlab.mntbbackend.pojo.ipojo.iDialogueInfo;
import com.ydlab.mntbbackend.pojo.ipojo.iDialogueJudgmentInfo;
import com.ydlab.mntbbackend.service.DialogueInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ydlab.mntbbackend.utils.ResultUtils;
import com.ydlab.mntbbackend.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
public class DialogueInfoServiceImpl extends ServiceImpl<DialogueInfoMapper, DialogueInfo> implements DialogueInfoService {

    @Autowired
    private DialogueInfoMapper dialogueInfoMapper;

    @Autowired
    private DialogueJudgmentInfoMapper dialogueJudgmentInfoMapper;

    @Override
    public ResultVo getDialogueInfoByDialogueId(String dialogue_id) {
//        iDialogueInfo iDialogueInfo = dialogueInfoMapper.getDialogueInfoByDialogueId(dialogue_id);
        QueryWrapper<DialogueInfo> queryWrapper_dialogue_info = new QueryWrapper<>();
        queryWrapper_dialogue_info.eq("dialogue_id", dialogue_id);
        DialogueInfo dialogueInfo = dialogueInfoMapper.selectOne(queryWrapper_dialogue_info);
        iDialogueInfo i_iDialogueInfo = new iDialogueInfo();
        if (dialogueInfo != null) {
            i_iDialogueInfo.setDialogueId(dialogueInfo.getDialogueId());
            i_iDialogueInfo.setStageId(dialogueInfo.getStageId());
            i_iDialogueInfo.setNpcId(dialogueInfo.getNpcId());
            i_iDialogueInfo.setDialogueContent(dialogueInfo.getDialogueContent());
            i_iDialogueInfo.setNextDialogueId(dialogueInfo.getNextDialogueId());
            i_iDialogueInfo.setDialogueJudgmentId(dialogueInfo.getDialogueJudgmentId());
            i_iDialogueInfo.setDialogueFillId(dialogueInfo.getDialogueFillId());
            i_iDialogueInfo.setDialogueWaitingTime(dialogueInfo.getDialogueWaitingTime());
            i_iDialogueInfo.setDialogueExtrasContent(dialogueInfo.getDialogueExtrasContent());
            i_iDialogueInfo.setDialogueFlag(dialogueInfo.getDialogueFlag());
            i_iDialogueInfo.setDialoguePageId(dialogueInfo.getDialoguePageId());
            if (dialogueInfo.getDialogueJudgmentId() != null) {
                QueryWrapper<DialogueJudgmentInfo> queryWrapper_dialogue_judgment_info = new QueryWrapper<>();
                queryWrapper_dialogue_judgment_info.eq("dialogue_judgment_id", dialogueInfo.getDialogueJudgmentId());
                List<DialogueJudgmentInfo> dialogue_judgment_info_list = dialogueJudgmentInfoMapper.selectList(queryWrapper_dialogue_judgment_info);
                List<iDialogueJudgmentInfo> iDialogueJudgmentInfo_list = new ArrayList<>();
                for (int i = 0; i < dialogue_judgment_info_list.size(); i++) {
                    iDialogueJudgmentInfo iDialogueJudgmentInfo = new iDialogueJudgmentInfo();
                    iDialogueJudgmentInfo.setDialogueJudgmentBranchOrder(dialogue_judgment_info_list.get(i).getDialogueJudgmentBranchOrder());
                    iDialogueJudgmentInfo.setDialogueJudgmentNextDialogueId(dialogue_judgment_info_list.get(i).getDialogueJudgmentNextDialogueId());
                    iDialogueJudgmentInfo_list.add(iDialogueJudgmentInfo);
                }
                i_iDialogueInfo.setDialogueJudgmentInfoList(iDialogueJudgmentInfo_list);
            }
        }
        if (i_iDialogueInfo == null) {
            return ResultUtils.error("没有该问题");
        } else {
            return ResultUtils.success("查询成功", i_iDialogueInfo);
        }
    }

    @Override
    public ResultVo getStageFirstDialogueInfo(String stage_id) {
        QueryWrapper<DialogueInfo> queryWrapper_StageFirstDialogueInfo = new QueryWrapper<>();
        queryWrapper_StageFirstDialogueInfo.eq("stage_id", stage_id);
        queryWrapper_StageFirstDialogueInfo.and(wrapper -> wrapper.eq("dialogue_flag", "1").or().eq("dialogue_flag", "12"));
        DialogueInfo dialogueInfo_StageFirst = dialogueInfoMapper.selectOne(queryWrapper_StageFirstDialogueInfo);
        iDialogueInfo i_iDialogueInfo_StageFirst = new iDialogueInfo();
        if (dialogueInfo_StageFirst != null) {
            i_iDialogueInfo_StageFirst.setDialogueId(dialogueInfo_StageFirst.getDialogueId());
            i_iDialogueInfo_StageFirst.setStageId(dialogueInfo_StageFirst.getStageId());
            i_iDialogueInfo_StageFirst.setNpcId(dialogueInfo_StageFirst.getNpcId());
            i_iDialogueInfo_StageFirst.setDialogueContent(dialogueInfo_StageFirst.getDialogueContent());
            i_iDialogueInfo_StageFirst.setNextDialogueId(dialogueInfo_StageFirst.getNextDialogueId());
            i_iDialogueInfo_StageFirst.setDialogueJudgmentId(dialogueInfo_StageFirst.getDialogueJudgmentId());
            i_iDialogueInfo_StageFirst.setDialogueFillId(dialogueInfo_StageFirst.getDialogueFillId());
            i_iDialogueInfo_StageFirst.setDialogueWaitingTime(dialogueInfo_StageFirst.getDialogueWaitingTime());
            i_iDialogueInfo_StageFirst.setDialogueExtrasContent(dialogueInfo_StageFirst.getDialogueExtrasContent());
            i_iDialogueInfo_StageFirst.setDialogueFlag(dialogueInfo_StageFirst.getDialogueFlag());
            i_iDialogueInfo_StageFirst.setDialoguePageId(dialogueInfo_StageFirst.getDialoguePageId());
            if (dialogueInfo_StageFirst.getDialogueJudgmentId() != null) {
                QueryWrapper<DialogueJudgmentInfo> queryWrapper_dialogue_judgment_info = new QueryWrapper<>();
                queryWrapper_dialogue_judgment_info.eq("dialogue_judgment_id", dialogueInfo_StageFirst.getDialogueJudgmentId());
                List<DialogueJudgmentInfo> dialogue_judgment_info_list = dialogueJudgmentInfoMapper.selectList(queryWrapper_dialogue_judgment_info);
                List<iDialogueJudgmentInfo> iDialogueJudgmentInfo_list = new ArrayList<>();
                for (int i = 0; i < dialogue_judgment_info_list.size(); i++) {
                    iDialogueJudgmentInfo iDialogueJudgmentInfo = new iDialogueJudgmentInfo();
                    iDialogueJudgmentInfo.setDialogueJudgmentBranchOrder(dialogue_judgment_info_list.get(i).getDialogueJudgmentBranchOrder());
                    iDialogueJudgmentInfo.setDialogueJudgmentNextDialogueId(dialogue_judgment_info_list.get(i).getDialogueJudgmentNextDialogueId());
                    iDialogueJudgmentInfo_list.add(iDialogueJudgmentInfo);
                }
                i_iDialogueInfo_StageFirst.setDialogueJudgmentInfoList(iDialogueJudgmentInfo_list);
            }
        }
        if (i_iDialogueInfo_StageFirst == null) {
            return ResultUtils.error("没有该问题");
        } else {
            return ResultUtils.success("查询成功", i_iDialogueInfo_StageFirst);
        }
    }
}
