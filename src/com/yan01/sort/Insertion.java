package com.yan01.sort;

import java.util.Arrays;

/**
 *1.把所有的元素分为两组，已经排序的和未排序的；
 * 2.找到未排序的组中的第一个元素，向已经排序的组中进行插入；
 * 3.倒叙遍历已经排序的元素，依次和待插入的元素进行比较，直到找到一个元素小于等于待插入元素，那么就把待插入元素放到这个位置，其他的元素向后移动一位；
 *
 * 插入排序的时间复杂度分析
 * 插入排序使用了双层for循环，其中内层循环的循环体是真正完成排序的代码，所以，我们分析插入排序的时间复
 * 杂度，主要分析一下内层循环体的执行次数即可。
 * 最坏情况，也就是待排序的数组元素为{12,10,6,5,4,3,2,1}，那么：
 * 比较的次数为：
 * (N-1)+(N-2)+(N-3)+...+2+1=((N-1)+1)*(N-1)/2=N^2/2-N/2;
 * 交换的次数为：
 * (N-1)+(N-2)+(N-3)+...+2+1=((N-1)+1)*(N-1)/2=N^2/2-N/2;
 * 总执行次数为：
 * (N^2/2-N/2)+(N^2/2-N/2)=N^2-N;
 * 按照大O推导法则，保留函数中的最高阶项那么最终插入排序的时间复杂度为O(N^2)  稳定
 *  @author yyh
 * @create 2020-09-05 16:46
 */
public class Insertion {
    /**
     * 测试
     */
    public static void main(String[] args) {
        Integer[] arr = {4,5,3,6,65,2,1};
        Insertion.sort(arr);

        System.out.println(Arrays.toString(arr));
    }

    /**
     * 排序
     */
//    public static void sort(Comparable[] a){
//        for(int i = 1; i < a.length; i++){
//            for(int j = i; j > 0 ; j--){
//                //比较索引j处的值和索引j-1处的值，如果索引j-1处的值比索引j处的值大，则交换数据，
//                // 如果不大，那么就找到合适的位置了，退出循环即可；
//                if(greater(a[j-1],a[j])){
//                    exchange(a,j-1,j);
//                }else{
//                    break;
//                }
//            }
//        }
//    }
    public static void sort(Comparable[] a){
        for(int i = 1; i < a.length; i++){
            for(int j = i; j > 0; j--){
                if(greater(a[j-1],a[j])){
                    exchange(a,j-1,j);
                }else{
                    break;
                }
            }
        }
    }


    /**
     * 计较两个数的大小
     */
    public static boolean greater(Comparable v, Comparable w){
        return v.compareTo(w) > 0;
    }

    /**
     * 交换两个数的位置
     */
    public static void exchange(Comparable[] a, int i , int j){
        Comparable  temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
