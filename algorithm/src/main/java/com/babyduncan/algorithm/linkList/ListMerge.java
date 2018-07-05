package com.babyduncan.algorithm.linkList;

public class ListMerge {
    /**
     *     问题描述:
     *     两个有序链表,合并成一个有序链表
     *     链表1:  1,2,5,6,8
     *     链表2:  3,4,7,9,10
     *     合并后的链表:  1,2,3,4,5,6,7,8,9,10
     */

    /**
     * 解题思路:
     * 输入参数:两个链表的头接电  输出:结果链表的头结点
     * 步骤一:如果两个链表有一个是空,就返回另一个头结点即可
     * 步骤二:确定哪一链表作为基础链表,那么就是头结点更小的链表作为结果链表的头结点
     * 步骤三:取临时空间 node1(链表1的当前节点),node2(链表2的当前节点),
     * pre 已经添加到结果链表中的最后的一个节点,next 下一个用来判断的节点
     * 计算顺序如下:
     * 初始状态 node1=1;node2=3, pre=null,next=null
     * 1,3  -> 1 node=1;node2=3,pre=1,next=2
     * node1=2,node2=3,pre=1; next=2
     * 1,2,3 -> 1,2,3  pre=2,next=5,node1=2,node2=3
     * nod1=5,node2=3,pre=2,next=5
     * pre=3,next=4,node1=5,node2=3
     * ...
     * ...
     * ...
     * 步骤四:如果一个遍历完了,把另一个直接贴在他的最后一个节点的前面或者后面 就完成
     */

//    public OneWayListNode merge(OneWayListNode node1, OneWayListNode node2) {
//
//    }


}
