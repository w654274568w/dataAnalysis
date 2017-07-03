package cn.dataAnalysis.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by feng on 2017/7/3.
 */
public class ListUtils {

    /**
     * 取两个String数组中的不同值
     *
     * @param list1
     * @param list2
     * @return
     */
    public static List<String> compareStrList(List<String> list1, List<String> list2) {
        List<String> difList = new ArrayList<String>();
        List<String> maxList = list1;
        List<String> minList = list2;
        if (list2.size() > list1.size()) {
            maxList = list2;
            minList = list1;
        }
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String str : maxList) {
            map.put(str, 1);
        }
        for (String str : minList) {
            Integer val = map.get(str);
            if (null != val){
                map.put(str,val++);
                continue;
            }
            map.put(str,1);
        }
        for (Map.Entry<String,Integer> entry:map.entrySet()){
            if (1 == entry.getValue()){
                difList.add(entry.getKey());
            }
        }
        return difList;
    }
}
