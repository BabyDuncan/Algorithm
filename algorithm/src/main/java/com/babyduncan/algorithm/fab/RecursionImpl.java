package com.babyduncan.algorithm.fab;

/**
 * Created by zhaoguohao on 2018/7/15.
 */
public class RecursionImpl {

    private static class Fab {

        public int getResult(int n) {
            if (n < 1) {
                return 0;
            }
            if (n <= 2) {
                return 1;
            } else {
                return getResult(n - 1) + getResult(n - 2);
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++)
            System.out.println(new Fab().getResult(i));
    }
}
