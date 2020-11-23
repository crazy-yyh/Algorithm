package com.yan01.sort;

import java.util.Arrays;

/**
 * 选择排序
 * 每一次遍历的过程中，都假定第一个索引处的元素是最小值，和其他索引处的值依次进行比较，如果当前索引处
 * 的值大于其他某个索引处的值，则假定其他某个索引出的值为最小值，最后可以找到最小值所在的索引
 *
 * 选择排序的时间复杂度分析：
 * 选择排序使用了双层for循环，其中外层循环完成了数据交换，内层循环完成了数据比较，所以我们分别统计数据
 * 交换次数和数据比较次数：
 * 数据比较次数：
 * (N-1)+(N-2)+(N-3)+...+2+1=((N-1)+1)*(N-1)/2=N^2/2-N/2;
 *
 * 数据交换次数：
 * N-1
 * 时间复杂度：N^2/2-N/2+（N-1）=N^2/2+N/2-1;
 * 根据大O推导法则，保留最高阶项，去除常数因子，时间复杂度为O(N^2);
 * @author yyh
 * @create 2020-09-05 15:19
 */
public class Selection {

    /**
     * 测试
     */
    public static void main(String[] args) {
        Integer[] arr = {4,5,6,16,3,23,2,1,8};
        Selection.sort(arr);

        System.out.println(Arrays.toString(arr));
    }

    /**
     * 排序
     */
//    public static void sort(Comparable[] a){
//        for(int i=0;i<=a.length-2;i++){
//            //定义一个变量，记录最小元素所在的索引，默认为参与选择排序的第一个元素所在的位置
//            int minIndex = i;
//            for(int j=i+1;j<a.length;j++){
//                //需要比较最小索引minIndex处的值和j索引处的值；
//                if (greater(a[minIndex],a[j])){
//                    minIndex=j;
//                }
//            }
//
//            //交换最小元素所在索引minIndex处的值和索引i处的值
//            exchange(a,minIndex,i);
//        }
//    }
    public static void sort(Comparable[] a){
        for(int i = 0; i < a.length; i++){
            int minIndex = i;
            for(int j = i + 1; j < a.length; j++){
                if(greater(a[minIndex],a[j])){
                    minIndex = j;
                }
            }
            exchange(a,i,minIndex);
        }
    }





    /**
     *比较两个数的大小
     */
    public static boolean greater(Comparable v, Comparable w){
        return v.compareTo(w) > 0;

    }

    /**
     * 交换两个数的位置
     */
    public static void exchange(Comparable[] a, int i , int j){
        Comparable temp  =  a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}