package com.figer.algorithm;

import java.util.HashSet;
import java.util.Set;

public class NumberCrossTest {
    public static void main(String[] args) {
        int[] a1 = new int[1000000];
        for (int i = 0; i < a1.length; i++) {
            a1[i] = i + 10;
        }
        int[] a2 = new int[2000000];
        for (int i = 0; i < a2.length; i++) {
            a2[i] = i + 20;
        }
        long begin = System.currentTimeMillis();
        Set<Integer> set1 = setMethod(a1, a2);
        long end = System.currentTimeMillis();
        System.out.println(end - begin);// 359
        
        begin = System.currentTimeMillis();
        Set<Integer> set2 = forMethod(a1, a2);
        end = System.currentTimeMillis();
        System.out.println(end - begin);// 160
        
        begin = System.currentTimeMillis();
        int[] c = intersect(a1, a2);
        end = System.currentTimeMillis();
        System.out.println(end - begin);// 10
        
        // 测试两种方法的结果是否相等
        System.out.println(set1.equals(set2));// true
        Set<Integer> set3 = new HashSet<Integer>();
        for (int i = 0; i < c.length; i++) {
            set3.add(c[i]);
        }
        System.out.println(set1.equals(set3));// true
    }

    private static Set<Integer> setMethod(int[] a, int[] b) {
        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> set2 = new HashSet<Integer>();
        for (int i = 0; i < a.length; i++) {
            set.add(a[i]);
        }
        for (int j = 0; j < b.length; j++) {
            if (!set.add(b[j]))
                set2.add(b[j]);
        }
        return set2;
    }

    private static Set<Integer> forMethod(int[] a, int[] b) {
        Set<Integer> set = new HashSet<Integer>();
        int i = 0, j = 0;
        while (i < a.length && j < b.length) {
            if (a[i] < b[j])
                i++;
            else if (a[i] > b[j])
                j++;
            else {
                set.add(a[i]);
                i++;
                j++;
            }
        }
        return set;
    }

    private static int[] intersect(int[] a, int[] b) {
        if (a[0] > b[b.length - 1] || b[0] > a[a.length - 1]) {
            return new int[0];
        }
        int[] intersection = new int[Math.max(a.length, b.length)];
        int offset = 0;
        for (int i = 0, s = i; i < a.length && s < b.length; i++) {
            while (a[i] > b[s]) {
                s++;
            }
            if (a[i] == b[s]) {
                intersection[offset++] = b[s++];
            }
            while (i < (a.length - 1) && a[i] == a[i + 1]) {
                i++;
            }
        }
        if (intersection.length == offset) {
            return intersection;
        }
        int[] duplicate = new int[offset];
        System.arraycopy(intersection, 0, duplicate, 0, offset);
        return duplicate;
    }
}