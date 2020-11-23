package com.yan01.sort;

import java.util.Arrays;

/**
 * 1.首先设定一个分界值，通过该分界值将数组分成左右两部分；
 * 2.将大于或等于分界值的数据放到到数组右边，小于分界值的数据放到数组的左边。此时左边部分中各元素都小于或等于分界值，而右边部分中各元素都大于或等于分界值；
 * 3.然后，左边和右边的数据可以独立排序。对于左侧的数组数据，又可以取一个分界值，将该部分数据分成左右两
 * 部分，同样在左边放置较小值，右边放置较大值。右侧的数组数据也可以做类似处理。
 * 4.重复上述过程，可以看出，这是一个递归定义。通过递归将左侧部分排好序后，再递归排好右侧部分的顺序。
 * 当左侧和右侧两个部分的数据排完序后，整个数组的排序也就完成
 * O(N^2)  稳定
 * @author yyh
 * @create 2020-09-06 8:32
 */
public class Quick {

    /**
     * 测试
     */
    public static void main(String[] args) {
        Integer[] arr = {4,8,2,16,9,45,21,1,3};
        Quick.sort(arr);

        System.out.println(Arrays.toString(arr));
    }



//    /**
//     *对数组内的元素进行排序
//     */
//    public static void sort(Comparable[] a) {
//        int lo = 0;
//        int hi = a.length-1;
//        sort(a,lo,hi);
//    }
//
//    /**
//     * 对数组a中从索引lo到索引hi之间的元素进行排序
//     */
//    private static void sort(Comparable[] a, int lo, int hi) {
//        //安全性校验
//        if (hi<=lo){
//            return;
//        }
//
//        //需要对数组中lo索引到hi索引处的元素进行分组（左子组和右子组）；
//        int partition = partition(a, lo, hi);//返回的是分组的分界值所在的索引，分界值位置变换后的索引
//
//        //让左子组有序
//        sort(a,lo,partition-1);
//
//        //让右子组有序
//        sort(a,partition+1,hi);
//    }
//
//    //对数组a中，从索引 lo到索引 hi之间的元素进行分组，并返回分组界限对应的索引
//    public static int partition(Comparable[] a, int lo, int hi) {
//        //确定分界值
//        Comparable key = a[lo];
//        //定义两个指针，分别指向待切分元素的最小索引处和最大索引处的下一个位置
//        int left=lo;
//        int right=hi+1;
//
//        while(true){
//            //先从右往左扫描，移动right指针，找到一个比分界值小的元素，停止
//            while(less(key,a[--right])){
//                if (right==lo){
//                    break;
//                }
//            }
//
//            //再从左往右扫描，移动left指针，找到一个比分界值大的元素，停止
//            while(less(a[++left],key)){
//                if (left==hi){
//                    break;
//                }
//            }
//            //判断 left>=right,如果是，则证明元素扫描完毕，结束循环，如果不是，则交换元素即可
//            if (left>=right){
//                break;
//            }else{
//                exchange(a,left,right);
//            }
//        }
//
//        //交换分界值
//        exchange(a,lo,right);
//
//        return right;
//    }
    public static void sort(Comparable[] a){
        int lo = 0;
        int hi = a.length-1;
        sort(a,lo,hi);
    }

    public static void sort(Comparable[] a, int lo, int hi){
        while(hi <= lo){
            return;
        }
        int partition = partition(a, lo, hi);
        sort(a,lo,partition-1);
        sort(a,partition+1,hi);


    }

    public static int partition(Comparable[] a, int lo, int hi){
        Comparable key = a[lo];
        int left = lo;
        int right = hi + 1;
        while(true){
            while(less(key,a[--right])){
                if(right == lo){
                    break;
                }
            }

            while(less(a[++left],key)){
                if(left == hi){
                    break;
                }
            }

            if(left >= right){
                break;
            }else{
                exchange(a,left,right);
            }
        }
        exchange(a,lo,right);
        return right;
    }

    /**
     * 比较两个数的大小
     */
    public static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }

    /**
     * 交换两个数的位置
     */
    public static void exchange(Comparable[] a, int i, int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
