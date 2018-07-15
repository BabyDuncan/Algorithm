package com.babyduncan.algorithm.lru;

import java.util.Hashtable;

/**
 * Created by zhaoguohao on 2018/7/15.
 */
public class LRUCache {

    int size;
    Hashtable<String, Node> nodes = new Hashtable<String, Node>(size);
    int currentSize;
    Node head;
    Node tail;

    public LRUCache(int size) {
        this.size = size;
    }

    public String get(String key) {
        for (String s : nodes.keySet()) {
            if (key.equals(s)) {
                Node n = nodes.get(s);
                move2Head(n);
                return n.getValue();

            }
        }
        return "";
    }

    public void add(String key, String value) {
        Node n = new Node();
        n.setKey(key);
        n.setValue(value);
        Node oldHead = head;
        n.setNext(oldHead);
        if (oldHead == null) {
            tail = n;
        } else {
            oldHead.pre = n;
        }
        head = n;
        nodes.put(key, n);
        currentSize++;
        if (currentSize > size) {
            deleteTail();
        }
    }

    public void remove(String key) {
        for (String s : nodes.keySet()) {
            if (key.equals(s)) {
                Node n = nodes.get(s);
                nodes.remove(s);
                Node pre = n.getPre();
                Node next = n.getNext();
                if (pre != null) {
                    pre.setNext(next);
                }
                if (next != null) {
                    next.setPre(pre);
                }
            }
        }

    }

    private void move2Head(Node node) {
        Node oldHead = head;
        Node pre = node.getPre();
        Node next = node.getNext();
        if (pre != null) {
            pre.setNext(next);
        } else {
            return;
        }
        if (next != null) {
            next.setPre(pre);
        } else {
            tail = pre;
        }
        node.setNext(oldHead);
        node.setPre(null);
        head = node;

    }

    private void deleteTail() {
        tail.pre.setNext(null);
        nodes.remove(tail.getKey());

    }


    private class Node {
        String key;
        String value;
        Node pre;
        Node next;

        public Node() {

        }

        public Node(String key, String value, Node pre, Node next) {
            this.key = key;
            this.value = value;
            this.pre = pre;
            this.next = next;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public Node getPre() {
            return pre;
        }

        public void setPre(Node pre) {
            this.pre = pre;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }


    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.add("1", "1");
        lruCache.add("2", "2");
        lruCache.add("3", "3");
        System.out.println(lruCache.get("1"));
        lruCache.add("4", "4");
        System.out.println(lruCache.get("1"));
        System.out.println(lruCache.get("2"));
    }

}
