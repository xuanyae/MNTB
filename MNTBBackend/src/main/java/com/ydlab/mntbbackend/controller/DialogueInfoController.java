package com.ydlab.mntbbackend.controller;


import com.ydlab.mntbbackend.service.DialogueInfoService;
import com.ydlab.mntbbackend.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author LiHaoXuan
 * @since 2023-08-07
 */
@RestController
@RequestMapping("/dialogueInfo")
public class DialogueInfoController {

    @Autowired
    private DialogueInfoService dialogueInfoService;

    @GetMapping("/getDialogueInfo")
    public ResultVo getDialogueInfoByDialogueId(@RequestParam(value = "dialogue_id", defaultValue = "1") String dialogue_id) {
        return dialogueInfoService.getDialogueInfoByDialogueId(dialogue_id);
    }

    @GetMapping("/getStageFirstDialogueInfo")
    public ResultVo getStageFirstDialogueInfo(@RequestParam("stage_id") String stage_id) {
        return dialogueInfoService.getStageFirstDialogueInfo(stage_id);
    }
}

