package com.yan01.sort;

import java.util.Arrays;

/**
 * 1.尽可能的一组数据拆分成两个元素相等的子组，并对每一个子组继续拆分，直到拆分后的每个子组的元素个数是1为止。
 * 2.将相邻的两个子组进行合并成一个有序的大组；
 * 3.不断的重复步骤2，直到最终只有一个组为止。
 * 归并排序是分治思想的最典型的例子，上面的算法中，对a[lo...hi]进行排序，先将它分为a[lo...mid]和a[mid+1...hi]
 * 两部分，分别通过递归调用将他们单独排序，最后将有序的子数组归并为最终的排序结果。该递归的出口在于如果
 * 一个数组不能再被分为两个子数组，那么就会执行merge进行归并，在归并的时候判断元素的大小进行排序。
 * 用树状图来描述归并，如果一个数组有8个元素，那么它将每次除以2找最小的子数组，共拆log8次，值为3，所以
 * 树共有3层,那么自顶向下第k层有2^k个子数组，每个数组的长度为2^(3-k)，归并最多需要2^(3-k)次比较。因此每层
 * 的比较次数为 2^k * 2^(3-k)=2^3,那么3层总共为 3*2^3。
 * 假设元素的个数为n，那么使用归并排序拆分的次数为log2(n),所以共log2(n)层，那么使用log2(n)替换上面3*2^3中
 * 的3这个层数，最终得出的归并排序的时间复杂度为：log2(n)* 2^(log2(n))=log2(n)*n,根据大O推导法则，忽略底
 * 数，最终归并排序的时间复杂度为O(nlogn);
 * 归并排序的缺点：
 * 需要申请额外的数组空间，导致空间复杂度提升，是典型的以空间换时间的操作。
 * @author yyh
 * @create 2020-09-06 9:55
 */
public class Merge {


    /**
     * 测试
     */
    public static void main(String[] args) {
        Integer[] arr = {4,8,2,6,9,45,10,21,1,3};
        Merge.sort(arr);

        System.out.println(Arrays.toString(arr));
    }


//    private static Comparable[] assist;
//
//
//    /**
//     *对数组a中的元素进行排序
//     */
//    public static void sort(Comparable[] a) {
//        //1.初始化辅助数组assist；
//        assist = new Comparable[a.length];
//        //2.定义一个lo变量，和hi变量，分别记录数组中最小的索引和最大的索引；
//        int lo=0;
//        int hi=a.length-1;
//        //3.调用sort重载方法完成数组a中，从索引lo到索引hi的元素的排序
//        sort(a,lo,hi);
//    }
//
//    /**
//     *   对数组a中从lo到hi的元素进行排序
//     */
//    private static void sort(Comparable[] a, int lo, int hi) {
//        //做安全性校验；
//        if (hi<=lo){
//            return;
//        }
//
//        //对lo到hi之间的数据进行分为两个组
//        int mid = lo+(hi-lo)/2;
//
//        //分别对每一组数据进行排序
//        sort(a,lo,mid);
//        sort(a,mid+1,hi);
//
//        //再把两个组中的数据进行归并
//        merge(a,lo,mid,hi);
//    }
//
//    /**
//    *对数组中，从lo到mid为一组，从mid+1到hi为一组，对这两组数据进行归并
//    */
//    private static void merge(Comparable[] a, int lo, int mid, int hi) {
//        //定义三个指针
//        int i=lo;
//        int p1=lo;
//        int p2=mid+1;
//
//        //遍历，移动p1指针和p2指针，比较对应索引处的值，找出小的那个，放到辅助数组的对应索引处
//        while(p1<=mid && p2<=hi){
//            //比较对应索引处的值
//            if (less(a[p1],a[p2])){
//                assist[i++] = a[p1++];
//            }else{
//                assist[i++]=a[p2++];
//            }
//        }
//
//        //遍历，如果p1的指针没有走完，那么顺序移动p1指针，把对应的元素放到辅助数组的对应索引处
//        while(p1<=mid){
//            assist[i++]=a[p1++];
//        }
//        //遍历，如果p2的指针没有走完，那么顺序移动p2指针，把对应的元素放到辅助数组的对应索引处
//        while(p2<=hi){
//            assist[i++]=a[p2++];
//        }
//        //把辅助数组中的元素拷贝到原数组中
//        for(int index=lo;index<=hi;index++){
//            a[index]=assist[index];
//        }
//
//    }
    private static Comparable[] assist;

    public static void sort(Comparable[] a){
        assist = new Comparable[a.length];
        int lo = 0;
        int hi = a.length -1;
        sort(a,lo,hi);
    }

    public static void sort(Comparable[] a, int lo,int hi){
        while(hi <= lo){
            return;
        }

        int mid = lo + (hi-lo)/2;
        sort(a,lo,mid);
        sort(a,mid+1,hi);
        merge(a,lo,mid,hi);

    }

    public static void merge(Comparable[] a, int lo, int mid, int hi){
        int i = lo;
        int left = lo;
        int right = mid +1;

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

        for(int index = lo; index <= hi; index++){
            a[index] = assist[index];
        }
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
    public static void exch(Comparable[] a, int i, int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
