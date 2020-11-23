package com.yan01.sort;

import java.util.Arrays;

/**
 * @author yyh
 * @create 2020-11-01 11:15
 */
public class Test {

    private static Comparable[] assist;

    public static void main(String[] args) {
        Integer[] arr = {2,9,6,8,4,12,24,19,31,25};
        Test.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(Comparable[] a){

        assist = new Comparable[a.length];
        int lo = 0;
        int hi = a.length-1;
        sort(a,lo,hi);
    }

    private static void sort(Comparable[] a, int lo,int hi){
        while(hi <= lo){
            return;
        }

        int mid = lo +(hi-lo)/2;
        sort(a,lo,mid);
        sort(a,mid+1,hi);
        merge(a,lo,mid,hi);


    }

    private static void merge(Comparable[] a,int lo, int mid, int hi){
        int i = lo;
        int left = lo;
        int right = mid+1;

        while(left <= mid && right <= hi){
            if(less(a[left],a[right])){
                assist[i++] = a[left++];
            }else{
                assist[i++] = a[right++];
            }
        }

        while(left <= mid){
            assist[i++] = a[left++];
        }

        while(right <= hi){
            assist[i++] = a[right++];
        }

        for (int index = lo; index <i ; index++) {
            a[index] = assist[index];
        }


    }



    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
