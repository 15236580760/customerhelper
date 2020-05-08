package com.sun.util;

import java.util.HashMap;
import java.util.Map;

public class EtcUtil {

    public static boolean checkIsSame(String cur, String tar) {

        if (cur.equals(tar)) {
            return true;
        }
        return false;
    }

    /**
     * 王者段位初始段位与目标段位矫正
     * @param cur
     * @param tar
     * @return
     */
    public static Map<String,String> proof(String cur, String tar) {

        String[] curArr = cur.split("_");
        String[] tarArr = tar.split("_");
        String curEtc = curArr[0];
        String curEtcNum = curArr[1];
        String curEtcStar = curArr[2];
        String tarEtc = tarArr[0];
        String tarEtcNum = tarArr[1];
        String tarEtcStar = tarArr[2];

        Map<String, String> map = new HashMap<>();
        if (curEtc.equals("wz") && curEtc.equals(tarEtc)) {
            if (Integer.parseInt(curEtcNum) - Integer.parseInt(tarEtcNum) > 0) {
                String newCur = tar;
                String newTar = cur;
                map.put("cur", newCur);
                map.put("tar", newTar);
                return map;
            } else if (Integer.parseInt(curEtcNum) - Integer.parseInt(tarEtcNum) == 0) {
                if (Integer.parseInt(curEtcStar) - Integer.parseInt(tarEtcStar) > 0) {
                    String newCur = tar;
                    String newTar = cur;
                    map.put("cur", newCur);
                    map.put("tar", newTar);
                    return map;
                }
            }
        }
        map.put("cur", cur);
        map.put("tar", tar);
        return map;
    }

}
