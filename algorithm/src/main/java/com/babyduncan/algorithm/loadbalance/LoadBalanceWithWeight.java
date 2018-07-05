package com.babyduncan.algorithm.loadbalance;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class LoadBalanceWithWeight {

    /**
     * dubbo的实现办法
     * 问题描述:
     * 有很多server的ip,并且每个server会配置一个权重,根据权重来计算每一个请求应该分给哪一个server
     * 解决办法:
     * 1,把所有的权重加起来,总和为n
     * 2,取n以内的随机数 m
     * 3,遍历server列表,每遍历一个减去他的权重x
     * 4,发现x小于0 就返回这个server,说明这次请求散落到他上面
     */

    public static void main(String[] args) {
        Map<String, Integer> serverList = new HashMap<String, Integer>();
        serverList.put("127.0.0.1", 1);
        serverList.put("127.0.0.2", 2);
        serverList.put("127.0.0.3", 3);
        serverList.put("127.0.0.4", 4);
        serverList.put("127.0.0.5", 5);


        String server = randomServerWithWeight(serverList);
        System.out.println("server is " + server);
    }

    private static String randomServerWithWeight(Map<String, Integer> serverList) {
        //考虑到程序员的鲁棒性,那么需要针对很多条件做处理,这不是重要的地方,先不加入代码.
        //1,首先考虑 serverList是否为空以及是否为null
        //2,考虑权重是否都一样,都一样的话就直接针对size取随机数然后get即可
        //3,针对权重取最大公约数
        //下面代码认为1-3 都已经做过了
        int totalWeight = 0;
        for (Map.Entry<String, Integer> entry : serverList.entrySet()) {
            totalWeight += entry.getValue();
        }
        System.out.println("total weight is " + totalWeight);
        int random = new Random().nextInt(totalWeight);
        System.out.println("random is " + random);
        for (Map.Entry<String, Integer> entry : serverList.entrySet()) {
            random -= entry.getValue();
            if (random <= 0) {
                return entry.getKey();
            }
        }
        return null;
    }


}
