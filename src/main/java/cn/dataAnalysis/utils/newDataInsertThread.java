package cn.dataAnalysis.utils;


import cn.dataAnalysis.model.SecondhandhouseNew;
import cn.dataAnalysis.model.SecondhandhouseOriginal;
import cn.dataAnalysis.service.SecondhandhouseNewService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by admin on 2017/4/6.
 */
public class NewDataInsertThread extends Thread{
    @Autowired
    private SecondhandhouseNewService secondhandhouseNewService;

    private List<SecondhandhouseOriginal> soList;

    public NewDataInsertThread(List<SecondhandhouseOriginal> soList){
        this.soList =soList;
    }

    public void run(){
        SecondhandhouseNew sn = new SecondhandhouseNew();
        for(int j = 0 ; j < soList.size(); j++){
            sn = ConvertUtils.dealWithSecondhandhouseOriginal(soList.get(j));
            secondhandhouseNewService.insert(sn);
        }
    }
}
