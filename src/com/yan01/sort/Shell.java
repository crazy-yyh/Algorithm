package com.yan01.sort;

import java.util.Arrays;

/**
 * 1.选定一个增长量h，按照增长量h作为数据分组的依据，对数据进行分组；
 * 2.对分好组的每一组数据完成插入排序；
 * 3.减小增长量，最小减为1，重复第二步操作。
 * O(n^2)
 * @author yyh
 * @create 2020-09-05 17:07
 */
public class Shell {
    /**
     * 测试
     */
    public static void main(String[] args) {
        Integer[] arr = {4,5,6,13,23,2,1,8};
        Shell.sort(arr);

        System.out.println(Arrays.toString(arr));
    }

    /**
     * 排序
     */
//    public static void sort(Comparable[] a){
//        //1.根据数组a的长度，确定增长量h的初始值；
//        int h = 1;
//        while(h<a.length/2){
//            h=2*h+1;
//        }
//        //2.希尔排序
//        while(h>=1){
//            //排序
//            //2.1.找到待插入的元素
//            for (int i=h;i<a.length;i++){
//                //2.2把待插入的元素插入到有序数列中
//                for (int j=i;j>=h;j-=h){
//
//                    //待插入的元素是a[j],比较a[j]和a[j-h]
//                    if (greater(a[j-h],a[j])){
//                        //交换元素
//                        exchange(a,j-h,j);
//                    }else{
//                        //待插入元素已经找到了合适的位置，结束循环；
//                        break;
//                    }
//                }
//
//            }
//            //减小h的值
//            h= h/2;
//        }
//
//    }

    public static void sort(Comparable[] a){
        int h = 1;
        while(h < a.length/2){
            h = h * 2 + 1;
        }

        while(h >= 1){
            for(int i = h ; i < a.length; i++){
                for(int j = i; j >= h; j-=h){
                    if(greater(a[j-h],a[j])){
                        exchange(a,j-h,j);
                    }else{
                        break;
                    }
                }
            }

            h = h / 2;
        }
    }


    /**
     * 比较两个数的大小
     */
    public static boolean greater(Comparable v, Comparable w){
        return v.compareTo(w) > 0;
    }

    /**
     * 交换两个数
     */
    public static void exchange(Comparable[] a , int i , int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
