package cn.edu.idea.entity;

import java.util.*;

/**
 * @Author chenrui
 * @Date 2022/11/23
 */
public class Node {

    public Node(char c) {
        this.c = c;
    }

    private Node() {
    }

    public static Node head() {
        return new Node();
    }

    private char c;

    private Map<Character,Node> nextMap = new TreeMap<>();

    private Queue<Long> docIds = new PriorityQueue<>(1,Long::compareTo);

    public boolean hasNext() {
        return nextMap.size() > 0;
    }

    public Node next(byte b) {
        return nextMap.get(b);
    }

    public Map<Character,Node> getNextMap() {
        return nextMap;
    }

    public Queue<Long> docIds() {
        return docIds;
    }

}
