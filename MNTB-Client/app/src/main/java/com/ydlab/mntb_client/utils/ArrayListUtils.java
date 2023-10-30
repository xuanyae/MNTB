package com.ydlab.mntb_client.utils;

import java.util.ArrayList;
import java.util.List;

public class ArrayListUtils {

    public static List<String> removeDuplicateElements(List<String> arrayList) {
        //对比两边去重
        List<String> arrayList_temp = new ArrayList<>();
        while (arrayList.size() > 0) {
            String value = arrayList.get(0);
            arrayList.remove(0);
            if (!arrayList_temp.contains(value) && !arrayList.contains(value)) {
                arrayList_temp.add(value);
            }
            arrayList.remove(value);//删除在动态数组中第一次出现的元素。
        }
        return arrayList_temp;
    }
}
