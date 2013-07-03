package com.babyduncan.algorithm;

/**
 * 选择排序
 * User: guohaozhao (guohaozhao@sohu-inc.com)
 * Date: 13-7-2 17:36
 */
public class SelectSort {


    public static void main(String... args) {

        int[] array = {1, 2, 32, 12, 34, 543, 1434, 565, 777};

        sort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

    }

    private static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                if (array[j] > array[i]) {
                    array[j] = array[i] ^ array[j];
                    array[i] = array[i] ^ array[j];
                    array[j] = array[i] ^ array[j];
                }
            }
        }
    }

}
