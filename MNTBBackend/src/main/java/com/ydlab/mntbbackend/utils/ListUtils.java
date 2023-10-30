package com.ydlab.mntbbackend.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class ListUtils {

    public static String getMinInListString(List<String> list) {
        List<Integer> integerList = list.stream().map(Integer::valueOf).collect(Collectors.toList());
        return String.valueOf(Collections.min(integerList));
    }

    public static <T> List<T> getRandomList(List<T> list, int count) {
        List<T> oList = new ArrayList<>();
        if (list.size() < count) {
            return list;
        } else {
            Random random = new Random();
            for (int i = 0; i < count; i++) {
                int intRandom = random.nextInt(list.size() - 1);
                oList.add(list.get(intRandom));
                list.remove(intRandom);
            }
            return oList;
        }
    }
}
