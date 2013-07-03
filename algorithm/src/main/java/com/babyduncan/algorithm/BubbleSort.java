package com.babyduncan.algorithm;

/**
 * 冒泡排序
 * <p/>
 * User: guohaozhao (guohaozhao@sohu-inc.com)
 * Date: 13-7-2 17:56
 */
public class BubbleSort {

    public static void main(String... args) {
        int[] array = {-1, 12, 34, 123, 435, 9876, 0};

        sort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

    }

    private static void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < array.length - i; j++) {
                if (array[j] < array[j + 1]) {
                    array[j] = array[j] ^ array[j + 1];
                    array[j + 1] = array[j] ^ array[j + 1];
                    array[j] = array[j] ^ array[j + 1];
                }
            }
        }
    }

}
