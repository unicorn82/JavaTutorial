package com.unicorn.jdk8;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.LongAdder;

public class ImpertivevsFunctional {

    private Map streamMethodMap = new HashMap<String, List<String>>();

//    public void count1(){
//        Set<String> sourceKeySet = streamMethodMap.keySet();
//        LongAdder longAdder = new LongAdder();
//        sourceKeySet.stream().forEach(c -> longAdder.add(streamMethodMap.get(c).size()));
//    }
}
