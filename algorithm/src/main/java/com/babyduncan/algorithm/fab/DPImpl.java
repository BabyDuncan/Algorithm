package com.babyduncan.algorithm.fab;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhaoguohao on 2018/7/15.
 */
public class DPImpl {

    private static class Fab {

        private static final Map<Integer, Integer> cache = new HashMap<Integer, Integer>();

        static {
            cache.put(1, 1);
            cache.put(2, 1);
        }

        public int getResult(int n) {
            if (n < 1) {
                return 0;
            }
            if (n <= 2) {
                return cache.get(n);
            } else {
                for (int j = 3; j <= n; j++) {
                    cache.put(j, cache.get(j - 1) + cache.get(j - 2));
                }
                return cache.get(n);
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++)
            System.out.println(new DPImpl.Fab().getResult(i));
    }

}
