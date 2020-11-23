package com.yan01.test;

import com.yan01.sort.Bubble;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author yyh
 * @create 2020-10-28 9:17
 */
public class Year<T> {
    public static void main(String[] args) {
        Integer[] arr = {4,5,6,12,3,2,1,16};
        Year.sort(arr);

        System.out.println(Arrays.toString(arr));

    }
    public static void sort(Comparable[] a){
        for(int i = a.length-1; i>0; i--){
            for(int j = 0; j < i; j++){
                if(!less(a[j],a[j+1])){
                    exch(a,j,j+1);
                }
            }
        }
    }

    public static boolean less(Comparable v ,Comparable w){
        return v.compareTo(w) < 0;
    }

    public static void exch(Comparable[] a, int i, int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
