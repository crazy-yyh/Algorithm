package com.yan01.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * 1. 比较相邻的元素。如果前一个元素比后一个元素大，就交换这两个元素的位置。
 * 2. 对每一对相邻元素做同样的工作，从开始第一对元素到结尾的最后一对元素。最终最后位置的元素就是最大值
 * 冒泡排序的时间复杂度分析 冒泡排序使用了双层for循环，其中内层循环的循环体是真正完成排序的代码，所以，
 * 我们分析冒泡排序的时间复杂度，主要分析一下内层循环体的执行次数即可。
 * 在最坏情况下，也就是假如要排序的元素为{6,5,4,3,2,1}逆序，那么：
 * 元素比较的次数为：
 * (N-1)+(N-2)+(N-3)+...+2+1=((N-1)+1)*(N-1)/2=N^2/2-N/2;
 * 元素交换的次数为：
 * (N-1)+(N-2)+(N-3)+...+2+1=((N-1)+1)*(N-1)/2=N^2/2-N/2;
 * 总执行次数为：
 * (N^2/2-N/2)+(N^2/2-N/2)=N^2-N;
 * 按照大O推导法则，保留函数中的最高阶项那么最终冒泡排序的时间复杂度为O(N^2). 稳定
 * @author yyh
 * @create 2020-08-22 9:32
 */
public class Bubble {

    /**
     * 测试
     */
    public static void main(String[] args) {
        Integer[] arr = {4,5,6,12,3,2,1,16};
        Bubble.sort(arr);

        System.out.println(Arrays.toString(arr));

    }

    /**
     * 对两个数进行排序
     */
//    public static void sort(Comparable[] a){
//        for(int i = a.length -1;i > 0; i-- ){
//            for(int j = 0; j < i; j++){
//                //比较索引j和索引j+1处的值
//                if(greater(a[j],a[j+1])){
//                    exchange(a,j,j+1);
//                }
//            }
//        }
//
//    }


    public static void sort(Comparable[] a){
        for(int i = a.length-1 ; i > 0 ; i--){
            for(int j = 0; j < i; j++){
                if(greater(a[j],a[j+1])){
                    exchange(a,j,j+1);
                }
            }
        }
    }






    /**
     * 比较两个数的大小
     */
    public static boolean greater(Comparable v, Comparable w){
        return v.compareTo(w) > 0 ;
    }

    /**
     *交换两个数的位置
     */
    public static void exchange(Comparable[] a ,int i , int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;

    }


}
