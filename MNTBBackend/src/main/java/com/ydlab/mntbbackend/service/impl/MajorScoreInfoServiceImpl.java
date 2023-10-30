package com.ydlab.mntbbackend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ydlab.mntbbackend.mapper.UserStageScoreInfoMapper;
import com.ydlab.mntbbackend.mapper.UserStageVolunteerInfoMapper;
import com.ydlab.mntbbackend.pojo.MajorScoreInfo;
import com.ydlab.mntbbackend.mapper.MajorScoreInfoMapper;
import com.ydlab.mntbbackend.pojo.UserStageScoreInfo;
import com.ydlab.mntbbackend.pojo.UserStageVolunteerInfo;
import com.ydlab.mntbbackend.pojo.ipojo.iAdmissionInfo;
import com.ydlab.mntbbackend.pojo.ipojo.iMajorGroupInfo;
import com.ydlab.mntbbackend.pojo.ipojo.iMajorInfo;
import com.ydlab.mntbbackend.service.MajorScoreInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ydlab.mntbbackend.utils.ListUtils;
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
public class MajorScoreInfoServiceImpl extends ServiceImpl<MajorScoreInfoMapper, MajorScoreInfo> implements MajorScoreInfoService {

    @Autowired
    private MajorScoreInfoMapper majorScoreInfoMapper;

    @Autowired
    private UserStageScoreInfoMapper userStageScoreInfoMapper;

    @Autowired
    private UserStageVolunteerInfoMapper userStageVolunteerInfoMapper;

    @Override
    public ResultVo getMajorGroupInfoList(String college_id, String type, String year) {
        List<String> majorGroupIdList = majorScoreInfoMapper.getMajorGroupInfoList(college_id, type, year);
        List<iMajorGroupInfo> iMajorGroupInfoList = new ArrayList<>();
        for (String majorGroupId : majorGroupIdList) {
            iMajorGroupInfo i_iMajorGroupInfo = new iMajorGroupInfo();
            i_iMajorGroupInfo.setCollegeId(college_id);
            i_iMajorGroupInfo.setMajorGroupId(majorGroupId);
            i_iMajorGroupInfo.setMajorGroupName("(" + majorGroupId + ")");
            iMajorGroupInfoList.add(i_iMajorGroupInfo);
        }
        return ResultUtils.success("", iMajorGroupInfoList);
    }

    @Override
    public ResultVo getMajorInfoList(String college_id, String type, String major_group_id, String year) {
        int year_int = Integer.parseInt(year);
        List<iMajorInfo> majorInfoList = majorScoreInfoMapper.getMajorInfoList(college_id, type, major_group_id, year);
        for (iMajorInfo i_iMajorInfo : majorInfoList) {
            i_iMajorInfo.setMajorGroupName("(" + i_iMajorInfo.getMajorGroupId() + ")");
            List<String> majorScoreList_2 = majorScoreInfoMapper.getMajorScoreList(college_id, type, major_group_id, i_iMajorInfo.getMajorName(), String.valueOf(year_int - 1));
            if (majorScoreList_2.size() != 0) {
                i_iMajorInfo.setMajorScore2(ListUtils.getMinInListString(majorScoreList_2));
            }
            List<String> majorScoreList_3 = majorScoreInfoMapper.getMajorScoreList(college_id, type, major_group_id, i_iMajorInfo.getMajorName(), String.valueOf(year_int - 2));
            if (majorScoreList_3.size() != 0) {
                i_iMajorInfo.setMajorScore3(ListUtils.getMinInListString(majorScoreList_3));
            }
            List<String> majorScoreList_4 = majorScoreInfoMapper.getMajorScoreList(college_id, type, major_group_id, i_iMajorInfo.getMajorName(), String.valueOf(year_int - 3));
            if (majorScoreList_4.size() != 0) {
                i_iMajorInfo.setMajorScore4(ListUtils.getMinInListString(majorScoreList_4));
            }
            List<String> majorScoreList_5 = majorScoreInfoMapper.getMajorScoreList(college_id, type, major_group_id, i_iMajorInfo.getMajorName(), String.valueOf(year_int - 4));
            if (majorScoreList_5.size() != 0) {
                i_iMajorInfo.setMajorScore5(ListUtils.getMinInListString(majorScoreList_5));
            }
        }
        return ResultUtils.success("", majorInfoList);
    }

    @Override
    public ResultVo getMajorRecommend(String type, String total_score, String province_id, String major_field_code, String year) {
        int year_int = Integer.parseInt(year);
        String total_score_min = String.valueOf(Integer.parseInt(total_score) - 5);
        List<iMajorInfo> majorRecommendList = majorScoreInfoMapper.getMajorRecommend(type, total_score, total_score_min, province_id, major_field_code, year);
        int i = 2;
        while (majorRecommendList.size() < 5) {
            total_score_min = String.valueOf(Integer.parseInt(total_score) - (5 * i++));
            majorRecommendList = majorScoreInfoMapper.getMajorRecommend(type, total_score, total_score_min, province_id, major_field_code, year);
        }
        majorRecommendList = ListUtils.getRandomList(majorRecommendList, 5);
        for (iMajorInfo i_iMajorInfo : majorRecommendList) {
            i_iMajorInfo.setMajorGroupName("(" + i_iMajorInfo.getMajorGroupId() + ")");
            List<String> majorScoreList_2 = majorScoreInfoMapper.getMajorScoreList(i_iMajorInfo.getCollegeId(), type, i_iMajorInfo.getMajorGroupId(), i_iMajorInfo.getMajorName(), String.valueOf(year_int - 1));
            if (majorScoreList_2.size() != 0) {
                i_iMajorInfo.setMajorScore2(ListUtils.getMinInListString(majorScoreList_2));
            }
            List<String> majorScoreList_3 = majorScoreInfoMapper.getMajorScoreList(i_iMajorInfo.getCollegeId(), type, i_iMajorInfo.getMajorGroupId(), i_iMajorInfo.getMajorName(), String.valueOf(year_int - 2));
            if (majorScoreList_3.size() != 0) {
                i_iMajorInfo.setMajorScore3(ListUtils.getMinInListString(majorScoreList_3));
            }
            List<String> majorScoreList_4 = majorScoreInfoMapper.getMajorScoreList(i_iMajorInfo.getCollegeId(), type, i_iMajorInfo.getMajorGroupId(), i_iMajorInfo.getMajorName(), String.valueOf(year_int - 3));
            if (majorScoreList_4.size() != 0) {
                i_iMajorInfo.setMajorScore4(ListUtils.getMinInListString(majorScoreList_4));
            }
            List<String> majorScoreList_5 = majorScoreInfoMapper.getMajorScoreList(i_iMajorInfo.getCollegeId(), type, i_iMajorInfo.getMajorGroupId(), i_iMajorInfo.getMajorName(), String.valueOf(year_int - 4));
            if (majorScoreList_5.size() != 0) {
                i_iMajorInfo.setMajorScore5(ListUtils.getMinInListString(majorScoreList_5));
            }
        }
        return ResultUtils.success("", majorRecommendList);
    }

    @Override
    public ResultVo getAdmissionInfo(String user_id, String stage_id, String year) {
        iAdmissionInfo i_iAdmissionInfo = new iAdmissionInfo();

        String stage_id_previous = String.valueOf(Integer.parseInt(stage_id) - 1);

        QueryWrapper<UserStageScoreInfo> queryWrapper_UserStageScoreInfo = new QueryWrapper<>();
        queryWrapper_UserStageScoreInfo.eq("user_id", user_id);
        queryWrapper_UserStageScoreInfo.eq("stage_id", stage_id_previous);
        UserStageScoreInfo userStageScoreInfo = userStageScoreInfoMapper.selectOne(queryWrapper_UserStageScoreInfo);
        String total_score = userStageScoreInfo.getTotalScore();
        String type = userStageScoreInfo.getType();

        QueryWrapper<UserStageVolunteerInfo> queryWrapper_UserStageVolunteerInfo = new QueryWrapper<>();
        queryWrapper_UserStageVolunteerInfo.eq("user_id", user_id);
        queryWrapper_UserStageVolunteerInfo.eq("stage_id", stage_id_previous);
        List<UserStageVolunteerInfo> userStageVolunteerInfoList = userStageVolunteerInfoMapper.selectList(queryWrapper_UserStageVolunteerInfo);
        for (UserStageVolunteerInfo userStageVolunteerInfo : userStageVolunteerInfoList) {
            String college_id = userStageVolunteerInfo.getCollegeId();
            String major_group_id = userStageVolunteerInfo.getMajorGroupId();
            List<String> majorGroupScoreList = majorScoreInfoMapper.getMajorGroupScoreList(college_id, type, major_group_id, year);
            if (majorGroupScoreList.size() != 0) {
                String group_score_min = ListUtils.getMinInListString(majorGroupScoreList);
                if (Integer.parseInt(group_score_min) <= Integer.parseInt(total_score)) {
                    i_iAdmissionInfo.setCollegeName(userStageVolunteerInfo.getCollegeName());
                    i_iAdmissionInfo.setGroupScoreMin(group_score_min);

                    String major_name_1 = userStageVolunteerInfo.getMajorName1();
                    if (major_name_1 == null) {

                    } else if (!major_name_1.equals("")) {
                        List<String> majorScoreList_1 = majorScoreInfoMapper.getMajorScoreList(college_id, type, major_group_id, major_name_1, year);
                        String major_name_1_score_min = ListUtils.getMinInListString(majorScoreList_1);
                        if (Integer.parseInt(major_name_1_score_min) <= Integer.parseInt(total_score)) {
                            i_iAdmissionInfo.setMajorName(major_name_1);
                            i_iAdmissionInfo.setMajorNotes(userStageVolunteerInfo.getMajorNotes1());
                            i_iAdmissionInfo.setMajorScoreMin(major_name_1_score_min);
                            return ResultUtils.success("", i_iAdmissionInfo);
                        }
                    }
                    if (major_name_1 != null) {
                        List<String> majorScoreList_1 = majorScoreInfoMapper.getMajorScoreList(college_id, type, major_group_id, major_name_1, year);
                        String major_name_1_score_min = ListUtils.getMinInListString(majorScoreList_1);
                        if (Integer.parseInt(major_name_1_score_min) <= Integer.parseInt(total_score)) {
                            i_iAdmissionInfo.setMajorName(major_name_1);
                            i_iAdmissionInfo.setMajorNotes(userStageVolunteerInfo.getMajorNotes1());
                            i_iAdmissionInfo.setMajorScoreMin(major_name_1_score_min);
                            return ResultUtils.success("", i_iAdmissionInfo);
                        }
                    }

                    String major_name_2 = userStageVolunteerInfo.getMajorName2();
                    if (major_name_2 == null) {

                    } else if (!major_name_2.equals("")) {
                        List<String> majorScoreList_2 = majorScoreInfoMapper.getMajorScoreList(college_id, type, major_group_id, major_name_2, year);
                        String major_name_2_score_min = ListUtils.getMinInListString(majorScoreList_2);
                        if (Integer.parseInt(major_name_2_score_min) <= Integer.parseInt(total_score)) {
                            i_iAdmissionInfo.setMajorName(major_name_2);
                            i_iAdmissionInfo.setMajorNotes(userStageVolunteerInfo.getMajorNotes2());
                            i_iAdmissionInfo.setMajorScoreMin(major_name_2_score_min);
                            return ResultUtils.success("", i_iAdmissionInfo);
                        }
                    }
                    if (major_name_2 != null) {
                        List<String> majorScoreList_2 = majorScoreInfoMapper.getMajorScoreList(college_id, type, major_group_id, major_name_2, year);
                        String major_name_2_score_min = ListUtils.getMinInListString(majorScoreList_2);
                        if (Integer.parseInt(major_name_2_score_min) <= Integer.parseInt(total_score)) {
                            i_iAdmissionInfo.setMajorName(major_name_2);
                            i_iAdmissionInfo.setMajorNotes(userStageVolunteerInfo.getMajorNotes2());
                            i_iAdmissionInfo.setMajorScoreMin(major_name_2_score_min);
                            return ResultUtils.success("", i_iAdmissionInfo);
                        }
                    }

                    String major_name_3 = userStageVolunteerInfo.getMajorName3();
                    if (major_name_3 == null) {

                    } else if (!major_name_3.equals("")) {
                        List<String> majorScoreList_3 = majorScoreInfoMapper.getMajorScoreList(college_id, type, major_group_id, major_name_3, year);
                        String major_name_3_score_min = ListUtils.getMinInListString(majorScoreList_3);
                        if (Integer.parseInt(major_name_3_score_min) <= Integer.parseInt(total_score)) {
                            i_iAdmissionInfo.setMajorName(major_name_3);
                            i_iAdmissionInfo.setMajorNotes(userStageVolunteerInfo.getMajorNotes3());
                            i_iAdmissionInfo.setMajorScoreMin(major_name_3_score_min);
                            return ResultUtils.success("", i_iAdmissionInfo);
                        }
                    }
                    if (major_name_3 != null) {
                        List<String> majorScoreList_3 = majorScoreInfoMapper.getMajorScoreList(college_id, type, major_group_id, major_name_3, year);
                        String major_name_3_score_min = ListUtils.getMinInListString(majorScoreList_3);
                        if (Integer.parseInt(major_name_3_score_min) <= Integer.parseInt(total_score)) {
                            i_iAdmissionInfo.setMajorName(major_name_3);
                            i_iAdmissionInfo.setMajorNotes(userStageVolunteerInfo.getMajorNotes3());
                            i_iAdmissionInfo.setMajorScoreMin(major_name_3_score_min);
                            return ResultUtils.success("", i_iAdmissionInfo);
                        }
                    }

                    String major_name_4 = userStageVolunteerInfo.getMajorName4();
                    if (major_name_4 == null) {

                    } else if (!major_name_4.equals("")) {
                        List<String> majorScoreList_4 = majorScoreInfoMapper.getMajorScoreList(college_id, type, major_group_id, major_name_4, year);
                        String major_name_4_score_min = ListUtils.getMinInListString(majorScoreList_4);
                        if (Integer.parseInt(major_name_4_score_min) <= Integer.parseInt(total_score)) {
                            i_iAdmissionInfo.setMajorName(major_name_4);
                            i_iAdmissionInfo.setMajorNotes(userStageVolunteerInfo.getMajorNotes4());
                            i_iAdmissionInfo.setMajorScoreMin(major_name_4_score_min);
                            return ResultUtils.success("", i_iAdmissionInfo);
                        }
                    }
                    if (major_name_4 != null) {
                        List<String> majorScoreList_4 = majorScoreInfoMapper.getMajorScoreList(college_id, type, major_group_id, major_name_4, year);
                        String major_name_4_score_min = ListUtils.getMinInListString(majorScoreList_4);
                        if (Integer.parseInt(major_name_4_score_min) <= Integer.parseInt(total_score)) {
                            i_iAdmissionInfo.setMajorName(major_name_4);
                            i_iAdmissionInfo.setMajorNotes(userStageVolunteerInfo.getMajorNotes4());
                            i_iAdmissionInfo.setMajorScoreMin(major_name_4_score_min);
                            return ResultUtils.success("", i_iAdmissionInfo);
                        }
                    }

                    String major_name_5 = userStageVolunteerInfo.getMajorName5();
                    if (major_name_5 == null) {

                    } else if (!major_name_5.equals("")) {
                        List<String> majorScoreList_5 = majorScoreInfoMapper.getMajorScoreList(college_id, type, major_group_id, major_name_5, year);
                        String major_name_5_score_min = ListUtils.getMinInListString(majorScoreList_5);
                        if (Integer.parseInt(major_name_5_score_min) <= Integer.parseInt(total_score)) {
                            i_iAdmissionInfo.setMajorName(major_name_5);
                            i_iAdmissionInfo.setMajorNotes(userStageVolunteerInfo.getMajorNotes5());
                            i_iAdmissionInfo.setMajorScoreMin(major_name_5_score_min);
                            return ResultUtils.success("", i_iAdmissionInfo);
                        }
                    }
                    if (major_name_5 != null) {
                        List<String> majorScoreList_5 = majorScoreInfoMapper.getMajorScoreList(college_id, type, major_group_id, major_name_5, year);
                        String major_name_5_score_min = ListUtils.getMinInListString(majorScoreList_5);
                        if (Integer.parseInt(major_name_5_score_min) <= Integer.parseInt(total_score)) {
                            i_iAdmissionInfo.setMajorName(major_name_5);
                            i_iAdmissionInfo.setMajorNotes(userStageVolunteerInfo.getMajorNotes5());
                            i_iAdmissionInfo.setMajorScoreMin(major_name_5_score_min);
                            return ResultUtils.success("", i_iAdmissionInfo);
                        }
                    }

                    String major_name_6 = userStageVolunteerInfo.getMajorName5();
                    if (major_name_6 == null) {

                    } else if (!major_name_6.equals("")) {
                        List<String> majorScoreList_6 = majorScoreInfoMapper.getMajorScoreList(college_id, type, major_group_id, major_name_6, year);
                        String major_name_6_score_min = ListUtils.getMinInListString(majorScoreList_6);
                        if (Integer.parseInt(major_name_6_score_min) <= Integer.parseInt(total_score)) {
                            i_iAdmissionInfo.setMajorName(major_name_6);
                            i_iAdmissionInfo.setMajorNotes(userStageVolunteerInfo.getMajorNotes6());
                            i_iAdmissionInfo.setMajorScoreMin(major_name_6_score_min);
                            return ResultUtils.success("", i_iAdmissionInfo);
                        }
                    }
                    if (major_name_6 != null) {
                        List<String> majorScoreList_6 = majorScoreInfoMapper.getMajorScoreList(college_id, type, major_group_id, major_name_6, year);
                        String major_name_6_score_min = ListUtils.getMinInListString(majorScoreList_6);
                        if (Integer.parseInt(major_name_6_score_min) <= Integer.parseInt(total_score)) {
                            i_iAdmissionInfo.setMajorName(major_name_6);
                            i_iAdmissionInfo.setMajorNotes(userStageVolunteerInfo.getMajorNotes6());
                            i_iAdmissionInfo.setMajorScoreMin(major_name_6_score_min);
                            return ResultUtils.success("", i_iAdmissionInfo);
                        }
                    }

                    String isAdjust = userStageVolunteerInfo.getIsAdjust();
                    if (isAdjust.equals("1")) {
                        List<iMajorInfo> adjustVolunteerByDescList = majorScoreInfoMapper.getAdjustVolunteerByAsc(college_id, type, major_group_id, year);
                        iMajorInfo iMajorInfo_adjust = adjustVolunteerByDescList.get(0);
                        i_iAdmissionInfo.setMajorName(iMajorInfo_adjust.getMajorName());
                        i_iAdmissionInfo.setMajorNotes(iMajorInfo_adjust.getMajorNotes());
                        i_iAdmissionInfo.setMajorScoreMin(iMajorInfo_adjust.getMajorScore1());
                        return ResultUtils.success("调剂", i_iAdmissionInfo);
                    }
                }
            }
        }
        return ResultUtils.success("", i_iAdmissionInfo);
    }
}
